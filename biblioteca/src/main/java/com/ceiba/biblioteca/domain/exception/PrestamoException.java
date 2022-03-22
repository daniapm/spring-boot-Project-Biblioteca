package com.ceiba.biblioteca.domain.exception;

public class PrestamoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PrestamoException(String mensaje) {
        super(mensaje);
    }
}