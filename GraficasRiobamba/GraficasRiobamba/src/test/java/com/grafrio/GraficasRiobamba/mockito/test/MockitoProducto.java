package com.grafrio.GraficasRiobamba.mockito.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.grafrio.GraficasRiobamba.entities.Producto;
import com.grafrio.GraficasRiobamba.repository.ProductoRepo;
import com.grafrio.GraficasRiobamba.service.ProductoService;


public class MockitoProducto {
	
	@Autowired
	private ProductoService productoService;
	
	@MockBean
	
	private ProductoRepo  productoRepo;
	
 
	@Test
	public void mockitoListarTest(){
		when(productoRepo.findAll()).thenReturn(Stream
				.of(new Producto (null, "aa","aa","aa", 0, 0, null),new Producto (null, "aa","aa","aa", 0, 0, null)).collect(Collectors.toList()) );
		           assertEquals(2,productoService.listar().size());
		
	}
 @Test
 public void mockitoSaveTest (){
	 
	 Producto producto  = new Producto( null, "aa","aa","aa", 0, 0, null);
	 when(productoRepo.save(producto)).thenReturn(producto);
	 assertEquals(producto,productoService.save(producto));
	 
 }

}
