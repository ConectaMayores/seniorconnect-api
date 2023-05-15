package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.Voluntario;

import java.util.List;

public interface IVoluntarioService extends ICRUD<Voluntario, Integer> {
    Voluntario crearVoluntario(Voluntario voluntario);
    Voluntario obtenerVoluntarioPorId(Long id);
    List<Voluntario> obtenerTodosLosVoluntarios();
    void eliminarVoluntario(Long id);
    Voluntario actualizarVoluntario(Voluntario voluntario);
}
