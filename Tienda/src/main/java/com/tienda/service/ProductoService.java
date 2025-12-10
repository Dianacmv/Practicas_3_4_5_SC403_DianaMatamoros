package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> getProductos();
    Producto getProducto(Producto producto);
    void save(Producto producto);
    void delete(Producto producto);
}
