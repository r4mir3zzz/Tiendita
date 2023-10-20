package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //se obtiene la lista con todas las categorias de al tabla
    public List<Categoria> getCategorias(boolean activo);
    
    //se obtine una categoria segun el ID pasado por parametro
    public Categoria getCategoria(Categoria categoria);
    
    //Se actualiza una categoria o se inserta una nueva
    public void save(Categoria categoria);
    
    //Se elimina segun el id pasado
    public void delete(Categoria categoria);
    
}
