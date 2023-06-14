package com.eXcelerate.exceptions;

public class SomethingWentWrongException extends Exception {
	/**
	 * This exception will be thrown to user with relavant message when there is
	 * something wrong in database related operations
	 */
	private static final long serialVersionUID = 1L;

	public SomethingWentWrongException(String message) {
		super(message);
	}
}
