package com.conectamayores.seniorconnectapi.repository;

import com.conectamayores.seniorconnectapi.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {
}
