package org.shortrip.boozaa.libs.mediainfo.fiches;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.shortrip.boozaa.libs.mediainfo.MediaInfo;


public class MediaFiche {

	private List<AudioFiche> _audios;
	private List<TextFiche> _texts;
	private VideoFiche _video;
	private String _filename="", _size="", _duration="", _encoder="", _lib="";
	
	
	
	public MediaFiche( File file ){
		MediaInfo info    = new MediaInfo();
		this._audios = new ArrayList<AudioFiche>();
		this._texts = new ArrayList<TextFiche>();
		
		info.open(file);
		
		// infos générales
		Map<String, String> infosGeneral = info.snapshot(MediaInfo.StreamKind.General, 0);
		// Le nom du fichier
		this._filename = infosGeneral.get("FileName");
		// Le poids
		this._size = infosGeneral.get("FileSize/String");
		// La durée de cette vidéo
		this._duration = infosGeneral.get("Duration/String");
		// L'encoder
		this._encoder = infosGeneral.get("Encoded_Application");
		// La librairie d'encodage
		this._lib = infosGeneral.get("Encoded_Library/String");
		
		// Flux audios
		if( infosGeneral.get("AudioCount") != null ){
			int nbAudio = Integer.parseInt( infosGeneral.get("AudioCount") );
			for( int i = 0; i < nbAudio; i++){
				// On retrouve les infos de ce flux audio
				Map<String, String> infosAudios = info.snapshot(MediaInfo.StreamKind.Audio, i);
				// On construit une AudioFiche avec ces infos
				AudioFiche audiofiche = new AudioFiche(infosAudios);
				// Ajout dans la liste des flux audios
				this._audios.add(audiofiche);
			}
		}
		
		
		// Flux text
		if( infosGeneral.get("TextCount") != null ){
			int nbTexts = Integer.parseInt( infosGeneral.get("TextCount") );
			for( int i = 0; i < nbTexts; i++){
				// On retrouve les infos de ce flux audio
				Map<String, String> infosTexts = info.snapshot(MediaInfo.StreamKind.Text, i);
				// On construit une AudioFiche avec ces infos
				TextFiche textfiche = new TextFiche(infosTexts);
				// Ajout dans la liste des flux audios
				this._texts.add(textfiche);
			}
		}
		
		
		
		// Flux video
		Map<String, String> infosVideos = info.snapshot(MediaInfo.StreamKind.Video, 0);
		this._video = new VideoFiche(infosVideos);
		
		info.close();
		
		
	}


	/**
	 * @return the _size
	 */
	public String get_size() {
		return _size;
	}


	/**
	 * @return the _duration
	 */
	public String get_duration() {
		return _duration;
	}



	/**
	 * @return the _encoder
	 */
	public String get_encoder() {
		return _encoder;
	}



	/**
	 * @return the _lib
	 */
	public String get_lib() {
		return _lib;
	}


	public List<AudioFiche> getAudioFiches(){
		return this._audios;
	}
	
	public List<TextFiche> getTextFiches(){
		return this._texts;
	}

	/**
	 * @return the _video
	 */
	public VideoFiche get_video() {
		return _video;
	}
	
	
	public String printAudios() {
		StringBuilder build = new StringBuilder();
		build.append("Flux audio" + "\n");
		for( AudioFiche a : this._audios ){
			build.append(a.toString());
		}		
		return build.toString();
	}
	
	public String printTexts() {
		StringBuilder build = new StringBuilder();
		build.append("Flux text" + "\n");
		for( TextFiche t : this._texts ){
			build.append(t.toString());
		}		
		return build.toString();
	}
	
	
	@Override 
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append(this._filename + " - ");
		if( this._duration != null ){
			build.append(this._duration);
			build.append(" - ");
		}
		/*
		if( this._encoder != null ){
			build.append(this._encoder);
			build.append(" - ");
		}
		if( this._lib != null ){
			build.append(this._lib);
			build.append(" - ");
		}
		*/
		if( this._size != null ){
			build.append(this._size);
		}
		
		return build.toString();
	}
	
	
}
