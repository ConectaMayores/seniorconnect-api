package com.conectamayores.seniorconnectapi.controller;


import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.repository.AdultoMayorRepository;
import com.conectamayores.seniorconnectapi.service.IAdultoMayoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adulto")
@RequiredArgsConstructor
public class AdultoMayorController {

    private final AdultoMayorRepository adultoMayorRepository;


    @PostMapping
    public ResponseEntity<AdultoMayor> createAdultoMayor(@RequestBody AdultoMayor adultoMayor) {
        AdultoMayor adultoMayor1 =adultoMayorRepository.save(adultoMayor);
        return new ResponseEntity<AdultoMayor>(adultoMayor1, HttpStatus.CREATED);
    }

    @GetMapping("/adultos")
    public ResponseEntity<List<AdultoMayor>> getAllAdultosMayores () throws Exception{
        List<AdultoMayor> adultoMayorList =adultoMayorRepository.findAll();
        return new ResponseEntity<List<AdultoMayor>>(adultoMayorList, HttpStatus.OK);
    }

    @PutMapping("/adultos/{id}")
    public ResponseEntity <AdultoMayor> updateAdultoMayor ( @PathVariable("id") Integer id, @RequestBody AdultoMayor adultoMayor) {

        AdultoMayor adultoFound =adultoMayorRepository.findById(Math.toIntExact(id)).orElse(new AdultoMayor());

        adultoFound.setGustos(adultoMayor.getGustos());
        adultoFound.setEdad(adultoMayor.getEdad());
        adultoFound.setApoyoEmocional(adultoMayor.isApoyoEmocional());
        adultoFound.setAsistencia(adultoMayor.isAsistencia());
        return new ResponseEntity<AdultoMayor>(adultoMayorRepository.save(adultoMayor),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteAdultoMayor (@PathVariable ("id") Integer id){
        adultoMayorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }







}
