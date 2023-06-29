package com.conectamayores.seniorconnectapi.controller;


import com.conectamayores.seniorconnectapi.dto.CambioContraseñaRequest;
import com.conectamayores.seniorconnectapi.exceptions.ContraseñaIgualException;
import com.conectamayores.seniorconnectapi.exceptions.ContraseñaInvalidaException;
import com.conectamayores.seniorconnectapi.exceptions.UsuarioExistenteException;
import com.conectamayores.seniorconnectapi.exceptions.UsuarioNoEncontradoException;
import com.conectamayores.seniorconnectapi.model.Usuario;
import com.conectamayores.seniorconnectapi.repository.AdultoMayorRepository;
import com.conectamayores.seniorconnectapi.repository.UsuarioRepository;
import com.conectamayores.seniorconnectapi.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {


    private final UsuarioServiceImpl usuarioService;


    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario "+ usuario.getNombreUsuario()+" registrado con exito ");
        } catch (UsuarioExistenteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre de usuario: " + usuario.getNombreUsuario()+", ya está registrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el usuario");
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios() throws Exception {
        List<Usuario> usuarioList = usuarioService.findAll();
        return new ResponseEntity<List<Usuario>>(usuarioList, HttpStatus.OK);
    }

    @PutMapping("/{username}/change-password")
    public ResponseEntity<String> cambiarContra(@PathVariable String username, @RequestBody CambioContraseñaRequest request) {
        try {
            usuarioService.cambiarContraseña(username, request.getContraseñaActual(), request.getNuevaContraseña());
            return ResponseEntity.ok("Contraseña cambiada con éxito");
        } catch (UsuarioNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario que me has dado no existe " + username);
        } catch (ContraseñaInvalidaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La contraseña actual es incorrecta " + request);
        } catch (ContraseñaIgualException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La nueva contraseña no puede ser igual a la actual " + request);
        }
    }


    @ExceptionHandler(UsuarioExistenteException.class)
    public ResponseEntity<String> handleUsuarioExistenteException(UsuarioExistenteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }




}











