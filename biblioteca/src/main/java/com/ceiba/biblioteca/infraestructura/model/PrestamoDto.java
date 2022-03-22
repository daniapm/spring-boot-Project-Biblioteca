package com.ceiba.biblioteca.infraestructura.model;

import java.io.Serializable;

public class PrestamoDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
    private String fechaMaximaDevolucion;
    
    public PrestamoDto() {}
    
    public PrestamoDto(long id, String isbn, String identificacionUsuario, int tipoUsuario) {
    	this.id = id;
    	this.isbn = isbn;
    	this.identificacionUsuario = identificacionUsuario;
    	this.tipoUsuario = tipoUsuario;
    }
    
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}
	
	public void setIdentificacionUsuario(String identificacionUsuario) {
		this.identificacionUsuario = identificacionUsuario;
	}
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}

	public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
