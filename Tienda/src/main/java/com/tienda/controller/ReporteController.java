package com.tienda.controller;

import com.tienda.service.ReporteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/principal")
    public String principal() {
        return "reportes/principal";
    }

    @GetMapping("/reporteProductos")
    public ResponseEntity<Resource> generarReporteProductos(HttpServletRequest request) throws IOException {

       
        String reporte = "Productos";
         
        var parametros = new HashMap<String, Object>();
        
        String tipo = "Pdf";
        
        return reporteService.generaReporte(reporte, parametros, tipo);
    }
}

