package com.registro.usuarios.repositorio;

import com.registro.usuarios.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProducto extends JpaRepository<Producto, Integer> {
}
