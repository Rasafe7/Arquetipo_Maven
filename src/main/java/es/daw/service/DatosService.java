package es.daw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.daw.model.Datos;
import es.daw.repository.DatosRepository;

@Service
public class DatosService {

    private final DatosRepository datosRepository;

    public DatosService(DatosRepository datosRepository) {
        this.datosRepository = datosRepository;
    }

    public List<Datos> obtenerTodos() {
        return datosRepository.obtenerTodos();
    }
}