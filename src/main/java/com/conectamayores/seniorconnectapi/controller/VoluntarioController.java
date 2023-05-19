package com.conectamayores.seniorconnectapi.controller;

import com.conectamayores.seniorconnectapi.model.Voluntario;
import com.conectamayores.seniorconnectapi.repository.VoluntarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntario")
@RequiredArgsConstructor
public class VoluntarioController {

    private final VoluntarioRepository voluntarioRepository;

    @PostMapping
    public ResponseEntity<Voluntario> createVoluntario(@RequestBody Voluntario voluntario) {
        Voluntario voluntario1 =voluntarioRepository.save(voluntario);
        return new ResponseEntity<Voluntario>(voluntario1, HttpStatus.CREATED);
    }

    @GetMapping("/voluntarios")
    public ResponseEntity<List<Voluntario>> getAllVoluntario () throws Exception{
        List<Voluntario> voluntarioListList =voluntarioRepository.findAll();
        return new ResponseEntity<List<Voluntario>>(voluntarioListList, HttpStatus.OK);
    }

    @PutMapping("/voluntarios/{id}")
    public ResponseEntity <Voluntario> updateVoluntario (@PathVariable("id") Integer id, @RequestBody Voluntario voluntario) {

        Voluntario voluntarioFound =voluntarioRepository.findById(Math.toIntExact(id)).orElse(new Voluntario());

        voluntarioFound.setGustos(voluntario.getGustos());
        voluntarioFound.setEdad(voluntario.getEdad());


        return new ResponseEntity<Voluntario>(voluntarioRepository.save(voluntario),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteVoluntario (@PathVariable ("id") Integer id){
        voluntarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
