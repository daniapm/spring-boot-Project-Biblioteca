package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.domain.model.Prestamo;

public class PrestamoBuilder {
	
    private String isbn = "65656r4";
    private String identificacionUsuario = "12345647";
    private int tipoUsuario = 2;
    
    public PrestamoBuilder conIsbn(String isbn) {
    	this.isbn = isbn;
    	return this;
    }
    
    public PrestamoBuilder conIdentificacionUsuario(String identificacionUsuario) {
    	this.identificacionUsuario = identificacionUsuario;
    	return this;
    }
    
    public PrestamoBuilder conTipoUsuario(int tipoUsuario) {
    	this.tipoUsuario = tipoUsuario;
    	return this;
    }
    
    public Prestamo build() {
    	return new Prestamo(isbn, identificacionUsuario, tipoUsuario);
    }
}
