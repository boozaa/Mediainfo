package org.shortrip.boozaa.libs.mediainfo.fiches;

import java.util.Map;


public class VideoFiche {

	private String _codec= "", _bitrate="", _width="", _height="", _size="";
	
	
	public VideoFiche( Map<String, String> map ){
		this._codec = map.get("Encoded_Library/Name");
		this._bitrate = map.get("BitRate/String");
		this._width = map.get("Width");
		this._height = map.get("Height");
		this._size = map.get("StreamSize/String");
	}


	/**
	 * @return the _codec
	 */
	public String get_codec() {
		return _codec;
	}


	/**
	 * @return the _bitrate
	 */
	public String get_bitrate() {
		return _bitrate;
	}


	/**
	 * @return the _width
	 */
	public String get_width() {
		return _width;
	}


	/**
	 * @return the _height
	 */
	public String get_height() {
		return _height;
	}

	
	/**
	 * @return the _size
	 */
	public String get_size() {
		return _size;
	}
	
	
	@Override 
	public String toString() {
		// _codec= "", _bitrate="", _width="", _height="", _size=""
		StringBuilder build = new StringBuilder();
		if( this._codec != null ){
			build.append(this._codec);
			build.append(" - ");
		}
		if( this._bitrate != null ){
			build.append(this._bitrate);
			build.append(" - ");
		}
		if( this._width != null ){
			build.append(this._width + "x" + this._height);
			build.append(" - ");
		}
		if( this._size != null ){
			build.append(this._size);
		}
		
		return build.toString();
	}
	
}
