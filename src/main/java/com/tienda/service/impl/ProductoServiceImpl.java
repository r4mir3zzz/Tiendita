package com.tienda.service.impl;

import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import com.tienda.dao.ProductoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activo) {
        var productos = productoDao.findAll();
        
        //Si son solo activas se debe filtrar las inactivas
        if (activo){
            productos.removeIf(e -> !e.isActivo());
        }
        
        return productos;
    }
    
    //se obtine una producto segun el ID pasado por parametro
    @Transactional(readOnly=true)
    @Override
    public Producto getProducto(Producto producto){
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    
    //Se actualiza una producto o se inserta una nueva
    @Transactional
    @Override
    public void save(Producto producto){
        productoDao.save(producto);
    }
    
    //Se elimina segun el id pasado
    @Transactional
    @Override
    public void delete(Producto producto){
        productoDao.delete(producto);
    }
    
    //Metodo para obtener un listado de producto filtrado por precio, ordenado por descripcion  
    @Transactional(readOnly=true)
    @Override
    public List<Producto> consultaQuery(
            double precioInf, double precioSup){
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    @Transactional(readOnly=true)
    @Override
    public List<Producto> consultaJPQL(
            double precioInf, double precioSup){
        return productoDao.consultaJPQL(precioInf, precioSup);
    }
    
    @Transactional(readOnly=true)
    @Override
    public List<Producto> consultaSQL(
            double precioInf, double precioSup){
        return productoDao.consultaSQL(precioInf, precioSup);
    }
}
