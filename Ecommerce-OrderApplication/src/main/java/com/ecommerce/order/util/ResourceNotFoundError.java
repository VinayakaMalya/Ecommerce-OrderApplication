package com.ecommerce.order.util;

public class ResourceNotFoundError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundError(String message, Throwable arg1) {
		super(message, arg1);

	}

	public ResourceNotFoundError(String message) {
		super(message);

	}

	public ResourceNotFoundError(Throwable message) {
		super(message);

	}


}
