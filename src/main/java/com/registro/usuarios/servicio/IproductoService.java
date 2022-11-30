package com.registro.usuarios.servicio;

import com.registro.usuarios.modelo.Producto;

import java.util.List;
import java.util.Optional;

public interface IproductoService {

    public List<Producto>listar();
    public Optional<Producto>listarId(int id);
    public int save (Producto p);
    public void delete(int id);
}
