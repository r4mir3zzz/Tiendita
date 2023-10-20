package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    //se obtiene la lista con todas las productos de al tabla
    public List<Producto> getProductos(boolean activo);
    
    //se obtine una producto segun el ID pasado por parametro
    public Producto getProducto(Producto producto);
    
    //Se actualiza una producto o se inserta una nueva
    public void save(Producto producto);
    
    //Se elimina segun el id pasado
    public void delete(Producto producto);
    
}
