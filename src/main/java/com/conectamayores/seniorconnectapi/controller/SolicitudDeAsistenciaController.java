package com.conectamayores.seniorconnectapi.controller;


import com.conectamayores.seniorconnectapi.dto.SolicitudDTO;
import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import com.conectamayores.seniorconnectapi.service.impl.SolicitudDeAsistenciaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitudes")
@RequiredArgsConstructor
public class SolicitudDeAsistenciaController {

    private final SolicitudDeAsistenciaServiceImpl solicitudDeAsistenciaService;

    @PostMapping
    public ResponseEntity<SolicitudDeAsistencia> crearSolicitudDeAsistencia(@RequestBody SolicitudDeAsistencia solicitudDeAsistencia) {
        SolicitudDeAsistencia nuevaSolicitud = solicitudDeAsistenciaService.crearSolicitud(solicitudDeAsistencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSolicitud);
    }

    /*@GetMapping("/{solicitudId}")
    public ResponseEntity<SolicitudDeAsistencia> obtenerSolicitudDeAsistencia(@PathVariable int solicitudId) {
        SolicitudDeAsistencia solicitud = solicitudDeAsistenciaService.obtenerSolicitud(solicitudId);
        return ResponseEntity.ok(solicitud);
    }*/

    @PutMapping("/{solicitudId}/estado")
    public ResponseEntity<String> actualizarEstadoSolicitudDeAsistencia(@PathVariable int solicitudId, @RequestParam String nuevoEstado) {
        SolicitudDeAsistencia solicitud = solicitudDeAsistenciaService.obtenerSolicitud(solicitudId);
        solicitudDeAsistenciaService.actualizarSolicitud(solicitud, nuevoEstado);
        return ResponseEntity.ok("Estado de la solicitud actualizado exitosamente.");
    }

    @GetMapping("/{solicitudId}")
    public ResponseEntity<SolicitudDTO> obtenerSolicitudDeAsistencia(@PathVariable Integer solicitudId) {
        SolicitudDeAsistencia solicitud = solicitudDeAsistenciaService.obtenerSolicitud(solicitudId);
        solicitud.getVoluntario();
        solicitud.getChat();

        ModelMapper modelMapper = new ModelMapper();
        SolicitudDTO solicitudDTO = modelMapper.map(solicitud, SolicitudDTO.class);

        return ResponseEntity.ok(solicitudDTO);
    }


}
