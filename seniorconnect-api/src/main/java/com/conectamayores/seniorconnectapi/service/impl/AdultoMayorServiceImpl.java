package com.conectamayores.seniorconnectapi.service.impl;


import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.service.IAdultoMayoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdultoMayorServiceImpl implements IAdultoMayoresService <AdultoMayor,Integer> {


    @Override
    public AdultoMayor createAdultoMayor(AdultoMayor adultoMayor) {
        return null;
    }

    @Override
    public AdultoMayor getAdultoMayorById(Integer id) {
        return null;
    }

    @Override
    public List<AdultoMayor> getAllAdultosMayores() {
        return null;
    }

    @Override
    public void deleteAdultoMayor(Integer id) {

    }

    @Override
    public AdultoMayor updateAdultoMayor(AdultoMayor adultoMayor) {
        return null;
    }

    @Override
    public AdultoMayor save(AdultoMayor adultoMayor) throws Exception {
        return null;
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
