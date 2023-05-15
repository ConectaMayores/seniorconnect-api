package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.AdultoMayor;

import java.util.List;


public interface IAdultoMayoresService<A, I extends Number> extends ICRUD<AdultoMayor,Integer>{

    AdultoMayor createAdultoMayor(AdultoMayor adultoMayor);
    AdultoMayor getAdultoMayorById(Integer id);
    List<AdultoMayor> getAllAdultosMayores();
    void deleteAdultoMayor(Integer id);
    AdultoMayor updateAdultoMayor(AdultoMayor adultoMayor);

}
