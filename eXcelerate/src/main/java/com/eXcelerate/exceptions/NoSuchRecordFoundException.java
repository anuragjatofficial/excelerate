package com.eXcelerate.exceptions;

public class NoSuchRecordFoundException extends Exception {
	/**
	 * This Exception will be thrown in case if there is no relavant record found
	 * 
	 */
	private static final long serialVersionUID = 4113441402797810893L;

	public NoSuchRecordFoundException(String message) {
		super(message);
	}
}
