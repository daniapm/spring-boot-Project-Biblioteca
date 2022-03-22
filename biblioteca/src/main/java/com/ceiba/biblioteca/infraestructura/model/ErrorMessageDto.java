package com.ceiba.biblioteca.infraestructura.model;

import java.io.Serializable;

public class ErrorMessageDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String mensaje;
	
	public ErrorMessageDto() {}
	
	public ErrorMessageDto(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


}
