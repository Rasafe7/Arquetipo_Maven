package es.daw.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.daw.model.Datos;
import es.daw.service.DatosService;

@RestController
@RequestMapping("/api/datos")
public class DatosController {

    private final DatosService datosService;

    public DatosController(DatosService datosService) {
        this.datosService = datosService;
    }

    @GetMapping
    public List<Datos> obtenerTodos() {
        return datosService.obtenerTodos();
    }
}