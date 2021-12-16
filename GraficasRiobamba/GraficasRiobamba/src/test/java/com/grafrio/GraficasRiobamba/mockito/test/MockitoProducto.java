package com.grafrio.GraficasRiobamba.mockito.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.TestPropertySource;

import com.grafrio.GraficasRiobamba.config.DBConnection;
import com.grafrio.GraficasRiobamba.entities.Producto;
import com.grafrio.GraficasRiobamba.repository.ProductoRepo;
import com.grafrio.GraficasRiobamba.service.ProductoService;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.Statement;
 
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
@TestPropertySource(
		locations = "classpath:aplication.properties")

public class MockitoProducto {
	
	
	private ProductoService productoService;
	private ProductoRepo  productoRepo;
	
	
	
 @Test
 public void mockitoSaveTest (){
	 
	 productoRepo = mock(ProductoRepo.class);
	 productoService = new ProductoService(productoRepo);
	 
	 Producto producto  = new Producto(null, "Cuadernos",
			 "Utiles Escolares","Cuadernos de papel reciclado", 12, 85, null);
	 when(productoRepo.save(producto)).thenReturn(producto);
	 assertEquals(1,productoService.save(producto));
	 
 }
 
 @Test
	public void mockitoListTest(){
		productoRepo = mock(ProductoRepo.class);
		productoService = new ProductoService(productoRepo);
		
		
		 List<Producto> productoList = new ArrayList<>();
		 
		 
		 
		 productoList.add( new Producto(null, "Cuadernos","Utiles Escolares",
				 "Cuadernos de papel reciclado", 12, 85, null));
		 productoList.add(new Producto(null, "Cuadernos","Utiles Escolares",
				 "Cuadernos de papel reciclado", 12, 85, null));
		 
		 
		    when(productoRepo.findAll()).thenReturn(productoList);
		    
		    List<Producto> expectedList = productoService.listar();
		    assertEquals(2, expectedList.size());
		    
	}
 
 @Test
 
 
 public void mockitoDeleteTest () {
	 productoRepo = mock(ProductoRepo.class);
	 productoService = new ProductoService(productoRepo);
	 long code = 20;
	 
	 Producto producto  = new Producto(null, 
			 "Cuadernos","Utiles Escolares","Cuadernos de papel reciclado", 12, 85, null);
	
	 productoService.delete(code);
	 
	 verify(productoRepo, times(1)).deleteById(code);
	 
 }

}
