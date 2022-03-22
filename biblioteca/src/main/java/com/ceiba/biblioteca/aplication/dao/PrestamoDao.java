package com.ceiba.biblioteca.aplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.aplication.entity.PrestamoEntity;

@Repository
public interface PrestamoDao extends JpaRepository<PrestamoEntity, Long> {

	PrestamoEntity findById(long id);
	PrestamoEntity findByIdentificacionUsuario(String identificacionUsuario);
}
