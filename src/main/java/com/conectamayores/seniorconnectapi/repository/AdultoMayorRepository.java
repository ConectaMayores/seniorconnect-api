package com.conectamayores.seniorconnectapi.repository;

import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdultoMayorRepository extends JpaRepository<AdultoMayor, Integer> {

    List<AdultoMayor> findAll();

    void deleteById(Integer id);


}
