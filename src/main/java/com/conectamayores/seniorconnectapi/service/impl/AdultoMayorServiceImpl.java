package com.conectamayores.seniorconnectapi.service.impl;


import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.repository.AdultoMayorRepository;
import com.conectamayores.seniorconnectapi.service.IAdultoMayoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdultoMayorServiceImpl implements IAdultoMayoresService <AdultoMayor,Integer> {

    private final AdultoMayorRepository adultoMayorRepository;

    @Override
    public AdultoMayor createAdultoMayor(AdultoMayor adultoMayor) {
        return adultoMayorRepository.save(adultoMayor);
    }

    @Override
    public Optional<AdultoMayor> getAdultoMayorById(Integer id) {
        return adultoMayorRepository.findById(id);
    }

    @Override
    public List<AdultoMayor> getAllAdultosMayores() {
        return adultoMayorRepository.findAll();
    }

    @Override
    public void deleteAdultoMayor(Integer id) {
        adultoMayorRepository.deleteById(id);
    }

    @Override
    public AdultoMayor updateAdultoMayor(AdultoMayor adultoMayor) {
        return adultoMayorRepository.save(adultoMayor);
    }

    @Override
    public AdultoMayor save(AdultoMayor adultoMayor) throws Exception {
        return adultoMayorRepository.save(adultoMayor);
    }

    @Override
    public AdultoMayor update(AdultoMayor adultoMayor, Integer integer) throws Exception {
        return null;
    }

    @Override
    public List<AdultoMayor> readAll() throws Exception {
        return null;
    }

    @Override
    public AdultoMayor readById(Integer integer) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer integer) throws Exception {

    }
}
