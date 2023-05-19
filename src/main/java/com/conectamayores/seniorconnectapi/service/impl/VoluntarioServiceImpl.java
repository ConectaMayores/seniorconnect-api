package com.conectamayores.seniorconnectapi.service.impl;


import com.conectamayores.seniorconnectapi.model.Voluntario;
import com.conectamayores.seniorconnectapi.repository.VoluntarioRepository;
import com.conectamayores.seniorconnectapi.service.IVoluntarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoluntarioServiceImpl implements IVoluntarioService<Voluntario,Integer> {
    private final VoluntarioRepository voluntarioRepository;
    @Override
    public Voluntario save(Voluntario voluntario) throws Exception {
        return voluntarioRepository.save(voluntario);
    }

    @Override
    public Voluntario update(Voluntario voluntario, Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Voluntario> readAll() throws Exception {
        return null;
    }

    @Override
    public Voluntario readById(Integer id) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }

    @Override
    public Voluntario crearVoluntario(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    @Override
    public Voluntario obtenerVoluntarioPorId(Long id) {
        return null;
    }


    @Override
    public List<Voluntario> obtenerTodosLosVoluntarios() {
        return voluntarioRepository.findAll();
    }

    @Override
    public void eliminarVoluntario(Long id) {

    }



    @Override
    public Voluntario actualizarVoluntario(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }
}
