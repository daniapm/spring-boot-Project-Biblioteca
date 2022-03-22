package com.ceiba.biblioteca.infraestructura.model;

import java.io.Serializable;

public class PrestamoCreadoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String fechaMaximaDevolucion;
	
	public PrestamoCreadoDto() {}
	
	
	public PrestamoCreadoDto(long id, String fechaMaximaDevolucion) {
		this.id = id;
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}
	public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}
	

}
