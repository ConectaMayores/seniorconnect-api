package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.Familiar;

import java.util.List;

public interface IFamiliarService extends ICRUD<Familiar,Integer> {

    Familiar createFamiliar(Familiar familiar);
    Familiar getFamiliarById(Long id);
    List<Familiar> getAllFamiliares();
    void deleteFamiliar(Long id);
    Familiar updateFamiliar(Familiar familiar);
}
