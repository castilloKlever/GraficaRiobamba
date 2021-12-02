package com.grafrio.GraficasRiobamba.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grafrio.GraficasRiobamba.entities.Producto;

public interface ProductoRepo extends CrudRepository<Producto,Long>{
	List<Producto>  findByCode(Long Id);

}
