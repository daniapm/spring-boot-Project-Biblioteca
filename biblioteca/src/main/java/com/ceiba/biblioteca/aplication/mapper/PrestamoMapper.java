package com.ceiba.biblioteca.aplication.mapper;

import com.ceiba.biblioteca.aplication.entity.PrestamoEntity;
import com.ceiba.biblioteca.domain.model.Prestamo;

public class PrestamoMapper {

    private PrestamoMapper() {}

    public static Prestamo aDominio(PrestamoEntity prestamoEntity) {
        Prestamo prestamo = null;

        if (prestamoEntity != null) {
            prestamo = new Prestamo(prestamoEntity.getIsbn(), prestamoEntity.getIdentificacionUsuario(), prestamoEntity.getTipoUsuario());
            prestamo.setId(prestamoEntity.getId());
            prestamo.setFechaMaximaDevolucion(prestamoEntity.getFechaMaximaDevolucion());
        }

        return prestamo;
    }

    public static PrestamoEntity aEntity(Prestamo prestamo) {
        PrestamoEntity prestamoEntity = null;

        if (prestamo != null) {
        	prestamoEntity = new PrestamoEntity();
            prestamoEntity.setIdentificacionUsuario(prestamo.getIdentificacionUsuario());
            prestamoEntity.setIsbn(prestamo.getIsbn());
            prestamoEntity.setTipoUsuario(prestamo.getTipoUsuario());
            prestamoEntity.setFechaMaximaDevolucion(prestamo.getFechaMaximaDevolucion());
        }

        return prestamoEntity;
    }
}