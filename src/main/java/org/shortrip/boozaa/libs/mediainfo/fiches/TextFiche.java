package org.shortrip.boozaa.libs.mediainfo.fiches;

import java.util.Map;

public class TextFiche {

	private String _codec="",_language="";
	
	public TextFiche( Map<String, String> map ){
		this._codec = map.get("Codec/String");
		this._language = map.get("Language/String");		
	}

	/**
	 * @return the _codec
	 */
	public String get_codec() {
		return _codec;
	}

	/**
	 * @return the _language
	 */
	public String get_language() {
		return _language;
	}
	
	@Override 
	public String toString() {
		// _codec="",_language=""
		StringBuilder build = new StringBuilder();
		if( this._codec != null ){
			build.append(this._codec);
			build.append(" - ");
		}
		if( this._language != null ){
			build.append(this._language);
		}		
		
		return build.toString();
	}
	
}
