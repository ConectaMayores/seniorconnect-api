package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.Plataforma;
import com.conectamayores.seniorconnectapi.model.Programa;

import java.util.List;

public interface IProgramaService extends ICRUD<Programa, Integer>{
    Programa crearPrograma(Programa programa);
    Programa obtenerProgramaPorId(Long id);
    List<Programa> obtenerTodosLosProgramas();
    List<Programa> obtenerProgramasPorPlataforma(Plataforma plataforma);
    void eliminarPrograma(Long id);
    Programa actualizarPrograma(Programa programa);
}
