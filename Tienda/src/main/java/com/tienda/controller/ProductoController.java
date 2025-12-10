package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import com.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        
        model.addAttribute("productos", productoService.getProductos());
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        return "/producto/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoProducto(Model model) {
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        return "/producto/modifica";
    }

    @PostMapping("/guardar")
    public String guardarProducto(Producto producto) {
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String modificarProducto(@PathVariable("idProducto") Long idProducto, Model model) {
        Producto producto = new Producto(idProducto);
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        return "/producto/modifica";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String eliminarProducto(@PathVariable("idProducto") Long idProducto) {
        productoService.delete(new Producto(idProducto));
        return "redirect:/producto/listado";
    }
}
