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
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioServiceImpl usuarioService;
    private final AdultoMayorRepository adultoMayorRepository;

    @PostMapping
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
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

    @PutMapping("/{username}/cambiar-contrasena")
    public ResponseEntity<String> cambiarContraseña(@PathVariable String username, @RequestBody CambioContraseñaRequest request) {
        try {
            usuarioService.cambiarContraseña(username, request.getContraseñaActual(), request.getNuevaContraseña());
            return ResponseEntity.ok("Contraseña cambiada con éxito");
        } catch (UsuarioNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no existe " + username);
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











