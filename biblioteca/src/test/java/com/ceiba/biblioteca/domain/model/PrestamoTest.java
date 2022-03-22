package com.ceiba.biblioteca.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ceiba.biblioteca.domain.PrestamoBuilder;
import com.ceiba.biblioteca.domain.exception.PrestamoException;

@RunWith(SpringJUnit4ClassRunner.class)
public class PrestamoTest {
	
	private String isbn = "65656r4";
    private String identificacionUsuario = "12345647";
    private int tipoUsuario = 2;

	@Test
	public void crearPrestamoTest() {
		Prestamo prestamo = new PrestamoBuilder()
				.conIsbn(isbn)
				.conIdentificacionUsuario(identificacionUsuario)
				.conTipoUsuario(tipoUsuario)
				.build();
		
		assertEquals(prestamo.getIsbn(), isbn);
		assertEquals(prestamo.getIdentificacionUsuario(), identificacionUsuario);
		assertEquals(prestamo.getTipoUsuario(), tipoUsuario);
		assertNotNull(prestamo.getFechaMaximaDevolucion());
	}
	
	@Test
	public void crearPrestamoConIsbnNuloMensajeDeErrorTest() {
		try {
			new PrestamoBuilder()
					.conIsbn(null)
					.build();
		} catch(PrestamoException e) {
			assertEquals(e.getMessage(), Prestamo.ISBN_NULO);
			
		}
	}
	
	@Test
	public void crearPrestamoConIsbnMayorADiezCaracteresMensajeDeErrorTest() {
		try {
			isbn = "123569875gt9";
			new PrestamoBuilder()
					.conIsbn(isbn)
					.build();
		} catch(PrestamoException e) {
			assertEquals(e.getMessage(), Prestamo.ISBN_MAX_LENGTH);
			
		}
	}
	
	@Test
	public void crearPrestamoConIdentificacionUsuarioNuloMensajeDeErrorTest() {
		try {
			new PrestamoBuilder()
					.conIdentificacionUsuario(null)
					.build();
		} catch(PrestamoException e) {
			assertEquals(e.getMessage(), Prestamo.ID_USUARIO_NULO);
			
		}
	}
	
	@Test
	public void crearPrestamoConIdentificacionUsuarioMayorADiezCaracteresMensajeDeErrorTest() {
		try {
			identificacionUsuario = "12345678985632";
			new PrestamoBuilder()
					.conIdentificacionUsuario(identificacionUsuario)
					.build();
		} catch(PrestamoException e) {
			assertEquals(e.getMessage(), Prestamo.ID_USUARIO_MAX_LENGTH);
			
		}
	}
	
	@Test
	public void crearPrestamoConTipoUsuarioInvalidoMensajeDeErrorTest() {
		try {
			tipoUsuario = 5;
			new PrestamoBuilder()
					.conTipoUsuario(tipoUsuario)
					.build();
		} catch(PrestamoException e) {
			assertEquals(e.getMessage(), Prestamo.USUARIO_ERROR);
			
		}
	}
}

