package com.ceiba.biblioteca.infraestructura.mapper;

import com.ceiba.biblioteca.domain.model.Prestamo;
import com.ceiba.biblioteca.infraestructura.model.PrestamoCreadoDto;
import com.ceiba.biblioteca.infraestructura.model.PrestamoDto;

public class PrestamoMapper {
	
	private PrestamoMapper() {}
	
	public static PrestamoDto aDto (Prestamo prestamo) {
		PrestamoDto prestamoDto = null;
		
		if (prestamo != null) {
			prestamoDto = new PrestamoDto(prestamo.getId(), prestamo.getIsbn(), prestamo.getIdentificacionUsuario(), prestamo.getTipoUsuario());
			prestamoDto.setFechaMaximaDevolucion(prestamo.getFechaMaximaDevolucion());
		}
		
		return prestamoDto;
	}

	public static Prestamo aDominio(PrestamoDto prestamoDto) {
		Prestamo prestamo = null;
		
		if(prestamoDto != null) {
			prestamo = new Prestamo(prestamoDto.getIsbn(), prestamoDto.getIdentificacionUsuario(), prestamoDto.getTipoUsuario());
		}
		
		return prestamo;
	}
	
	public static PrestamoCreadoDto aResultDto(Prestamo prestamo) {
		PrestamoCreadoDto prestamoCreadoDto = null;
		
		if(prestamo != null) {
			prestamoCreadoDto = new PrestamoCreadoDto(prestamo.getId(), prestamo.getFechaMaximaDevolucion());
		}
		
		return prestamoCreadoDto;
	}
}
