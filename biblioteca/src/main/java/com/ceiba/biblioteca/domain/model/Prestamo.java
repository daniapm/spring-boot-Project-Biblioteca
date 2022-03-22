package com.ceiba.biblioteca.domain.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.biblioteca.domain.exception.PrestamoException;

public class Prestamo {

    static final int MAX_LENGTH = 10;
    static final String ISBN_NULO = "No se puede crear un prestamo sin el campo isbn";
    static final String ISBN_MAX_LENGTH = "No se puede crear un prestamo con el isbn con más de 10 caracteres";
    static final String ID_USUARIO_NULO = "No se puede crear un prestamo sin la identificacion del usuario";
    static final String ID_USUARIO_MAX_LENGTH = "No se puede crear un prestamo con la identificacion del usuario con más de 10 caracteres";
    static final String USUARIO_ERROR = "Tipo de usuario no permitido en la biblioteca";
    
    private long id;
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
    private String fechaMaximaDevolucion;
    
    public Prestamo(String isbn, String identificacionUsuario, int tipoUsuario) {
        validarInformacion(isbn, ISBN_NULO, ISBN_MAX_LENGTH);
        validarInformacion(identificacionUsuario, ID_USUARIO_NULO, ID_USUARIO_MAX_LENGTH);
        validarTipoDeUsuario(tipoUsuario);

        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
        fechaMaximaDevolucion = calcularFechaDevolucion();
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
		this.id = id;
		
	}

    public String getIsbn() {
        return isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
		
	}
    private void validarInformacion(String dato, String error1, String error2) {
        if (dato == null) {
            throw new PrestamoException(error1);
        }
        
        if (dato.length() > MAX_LENGTH) {
        	throw new PrestamoException(error2);
        }
    }

    private void validarTipoDeUsuario(int usuario) {
        if (usuario < 1 || usuario > 3) {
            throw new PrestamoException(USUARIO_ERROR);
        }
    }

    private String calcularFechaDevolucion() {
        int dias = 0;
        if (getTipoUsuario() == 1) {
            dias = 10; 
        }
        else if (getTipoUsuario() == 2) {
            dias = 8;
        }
        else if (getTipoUsuario() == 3){
            dias = 7;
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return agregarDiasHabiles(dias).format(formato);
    }

    private LocalDate agregarDiasHabiles(int days) {
        LocalDate result = LocalDate.now();
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }
	
}
