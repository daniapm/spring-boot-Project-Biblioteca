package com.ceiba.biblioteca.aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.biblioteca.aplication.dao.PrestamoDao;
import com.ceiba.biblioteca.aplication.entity.PrestamoEntity;
import com.ceiba.biblioteca.aplication.mapper.PrestamoMapper;
import com.ceiba.biblioteca.domain.exception.PrestamoException;
import com.ceiba.biblioteca.domain.model.Prestamo;
import com.ceiba.biblioteca.domain.repository.RepositorioPrestamo;

@Service
public class PrestamoServiceImp implements RepositorioPrestamo {
	
	static final String PRESTAMO_NO_EXISTE = "El prestamo buscado con el Id = %d no existe";
	static final String YA_TIENE_UN_PRESTAMO = "El usuario con identificación %s ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo";
	static final int USUARIO_INVITADO = 3;
	
	@Autowired
	private PrestamoDao prestamoDao;
	
	public PrestamoServiceImp() {}
	
	public PrestamoServiceImp(PrestamoDao prestamoDao) {
		this.prestamoDao = prestamoDao;
	}

	@Override
	public Prestamo crear(Prestamo prestamo) {
		PrestamoEntity prestamoEntity = prestamoDao.findByIdentificacionUsuario(prestamo.getIdentificacionUsuario());
		if (prestamoEntity != null && prestamoEntity.getTipoUsuario() == USUARIO_INVITADO) {
			throw new PrestamoException(String.format(YA_TIENE_UN_PRESTAMO, prestamo.getIdentificacionUsuario()));
		}
		prestamoDao.save(PrestamoMapper.aEntity(prestamo));
		return PrestamoMapper.aDominio(prestamoDao.findByIdentificacionUsuario(prestamo.getIdentificacionUsuario()));
		
	}

	@Override
	public Prestamo obtenerPorId(int id) {
		Prestamo prestamo = PrestamoMapper.aDominio(prestamoDao.findById(id));
		if (prestamo == null) {
			throw new PrestamoException(String.format(PRESTAMO_NO_EXISTE, id));
		}
		return prestamo;
	}
}
