package org.shortrip.boozaa.libs.mediainfo.fiches;

import java.util.Map;

public class AudioFiche {

	private String _codec="", _bitrate_mode="", _bitrate="", _channels="", _sampling_rate="", _size="", _language="";
	
	public AudioFiche(Map<String, String> map){
		this._codec = map.get("Codec/String");
		this._bitrate_mode = map.get("BitRate_Mode");
		this._bitrate = map.get("BitRate/String");
		this._channels = map.get("Channel(s)/String");
		this._sampling_rate = map.get("SamplingRate/String");
		this._size = map.get("StreamSize/String");
		this._language = map.get("Language/String");
	}


	/**
	 * @return the _codec
	 */
	public String get_codec() {
		return _codec;
	}

	/**
	 * @return the _bitrate_mode
	 */
	public String get_bitrate_mode() {
		return _bitrate_mode;
	}

	/**
	 * @return the _bitrate
	 */
	public String get_bitrate() {
		return _bitrate;
	}

	/**
	 * @return the _channels
	 */
	public String get_channels() {
		return _channels;
	}

	/**
	 * @return the _sampling_rate
	 */
	public String get_sampling_rate() {
		return _sampling_rate;
	}

	/**
	 * @return the _size
	 */
	public String get_size() {
		return _size;
	}
	
	
	@Override 
	public String toString() {
		// _codec="", _bitrate_mode="", _bitrate="", _channels="", _sampling_rate="", _size=""
		StringBuilder build = new StringBuilder();
		if( this._codec != null ){
			build.append(this._codec);
			build.append(" - ");
		}
		if( this._bitrate != null ){
			build.append(this._bitrate);
			build.append(" - ");
		}
		if( this._channels != null ){
			build.append(this._channels);
			build.append(" - ");
		}
		if( this._sampling_rate != null ){
			build.append(this._sampling_rate);
			build.append(" - ");
		}
		if( this._language != null ){
			build.append(this._language);
			build.append(" - ");
		}
		if( this._size != null ){
			build.append(this._size);
		}
		
		return build.toString();
	}
	
}
