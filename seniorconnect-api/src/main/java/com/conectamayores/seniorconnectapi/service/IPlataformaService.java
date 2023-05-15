package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.Plataforma;
import com.conectamayores.seniorconnectapi.model.Programa;

import java.util.List;

public interface IPlataformaService extends ICRUD<Plataforma,Integer>{

    Plataforma crearPlataforma(Plataforma plataforma);
    Plataforma obtenerPlataformaPorId(Integer id);
    List<Plataforma> obtenerTodasLasPlataformas();
    void eliminarPlataforma(Integer id);
    Plataforma actualizarPlataforma(Plataforma plataforma);

}
