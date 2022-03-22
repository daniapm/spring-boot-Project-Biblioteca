package com.ceiba.biblioteca.aplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Prestamo")
public class PrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "isbn", unique = false)
    private String isbn;

    @Column(name = "identificacion_usuario", unique = false)
    private String identificacionUsuario;

    @Column(name = "tipo_usuario")
    private int tipoUsuario;

    @Column(name = "fecha_maxima_devolucion")
    private String fechaMaximaDevolucion;
    
    public PrestamoEntity() {}
    
    public PrestamoEntity(long id, String isbn, String identificacionUsuario, int tipoUsuario, String fechaMaximaDevolucion) {
    	this.id = id;
    	this.isbn = isbn;
    	this.identificacionUsuario = identificacionUsuario;
    	this.tipoUsuario = tipoUsuario;
    	this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
