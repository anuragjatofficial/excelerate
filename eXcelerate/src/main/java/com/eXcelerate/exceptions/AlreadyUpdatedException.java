package com.eXcelerate.exceptions;

public class AlreadyUpdatedException extends Exception {
	/**
	 * This Exception should be thrown when we try to update any particular field
	 * which is already updated to same status
	 */
	private static final long serialVersionUID = 5283285298869828930L;

	public AlreadyUpdatedException(String str) {
		super(str);
	}
}
