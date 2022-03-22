package com.ceiba.biblioteca.infraestructura.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.aplication.service.PrestamoServiceImp;
import com.ceiba.biblioteca.domain.exception.PrestamoException;
import com.ceiba.biblioteca.domain.model.Prestamo;
import com.ceiba.biblioteca.infraestructura.mapper.PrestamoMapper;
import com.ceiba.biblioteca.infraestructura.model.ErrorMessageDto;
import com.ceiba.biblioteca.infraestructura.model.PrestamoCreadoDto;
import com.ceiba.biblioteca.infraestructura.model.PrestamoDto;

@RestController
@RequestMapping("prestamo")
public class PrestamoControlador {
	
	private PrestamoServiceImp prestamoServiceImp;
	
	public PrestamoControlador(PrestamoServiceImp prestamoServiceImp) {
		this.prestamoServiceImp = prestamoServiceImp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PrestamoDto> obtenerPrestamo(@PathVariable int id) {
		try {
			return new ResponseEntity<PrestamoDto>(PrestamoMapper.aDto(prestamoServiceImp.obtenerPorId(id)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new ErrorMessageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping
	public ResponseEntity<PrestamoCreadoDto> crearPrestamo(@RequestBody PrestamoDto prestamoDto) {
		try {
			return new ResponseEntity<>(PrestamoMapper.aResultDto(prestamoServiceImp.crear(PrestamoMapper.aDominio(prestamoDto))), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new ErrorMessageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
}
