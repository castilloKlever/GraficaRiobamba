package com.grafrio.GraficasRiobamba.mockito.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.grafrio.GraficasRiobamba.entities.Producto;
import com.grafrio.GraficasRiobamba.repository.ProductoRepo;
import com.grafrio.GraficasRiobamba.service.ProductoService;


public class MockitoProducto {
	
	
	private ProductoService productoService;
	
	
	
	private ProductoRepo  productoRepo;
	
 
	@Test
	public void mockitoListarTest(){
		productoRepo = mock(ProductoRepo.class);
		productoService = new ProductoService(productoRepo);
		
		 List<Producto> productoList = new ArrayList<>();
		 
		 productoList.add(new Producto(null, "aa","aa","aa", 0, 0, null));
		 productoList.add(new Producto(null, "aa","aa","aa", 0, 0, null));

		    when(productoRepo.findAll()).thenReturn(productoList);

		    List<Producto> expectedList = productoService.listar();

		    assertEquals(2, expectedList.size());
	    
	
		
	}
	
 @Test
 public void mockitoSaveTest (){
	 
	 productoRepo = mock(ProductoRepo.class);
	 productoService = new ProductoService(productoRepo);
	 Producto producto  = new Producto( null, "aa","aa","aa", 0, 0, null);
	 when(productoRepo.save(producto)).thenReturn(producto);
	 assertEquals(1,productoService.save(producto));
	 
 }
 
 @Test
 
 
 
 public void mockitoDeleteTest () {
	 productoRepo = mock(ProductoRepo.class);
	 productoService = new ProductoService(productoRepo);
	 long code = 20;
	 Producto producto  = new Producto( code, "aa","aa","aa", 0, 0, null);
	
	 productoService.delete(code);
	 
	 verify(productoRepo, times(1)).deleteById(code);
	 
	
	 

	 
 }

}
