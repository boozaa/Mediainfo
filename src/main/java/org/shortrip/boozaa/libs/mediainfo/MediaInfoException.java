package org.shortrip.boozaa.libs.mediainfo;



public class MediaInfoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public MediaInfoException(LinkageError e) {
		this("Unable to load %d-bit native library 'mediainfo'", e);
	}
	

	public MediaInfoException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
