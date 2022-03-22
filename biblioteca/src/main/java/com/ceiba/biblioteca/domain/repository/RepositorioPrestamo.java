package com.ceiba.biblioteca.domain.repository;

import com.ceiba.biblioteca.domain.model.Prestamo;

public interface RepositorioPrestamo {
    Prestamo crear(Prestamo prestamo);
    Prestamo obtenerPorId(int id);
}
