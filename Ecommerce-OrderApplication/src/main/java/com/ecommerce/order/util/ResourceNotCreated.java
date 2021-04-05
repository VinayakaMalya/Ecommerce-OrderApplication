package com.ecommerce.order.util;

public class ResourceNotCreated extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotCreated(String message, Throwable arg1) {
		super(message, arg1);

	}

	public ResourceNotCreated(String message) {
		super(message);

	}

	public ResourceNotCreated(Throwable message) {
		super(message);

	}

}