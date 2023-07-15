package com.conectamayores.seniorconnectapi.controller;


import com.conectamayores.seniorconnectapi.config.SolicitudMapper;
import com.conectamayores.seniorconnectapi.dto.SolicitudDTO;
import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import com.conectamayores.seniorconnectapi.service.impl.AdultoMayorServiceImpl;
import com.conectamayores.seniorconnectapi.service.impl.SolicitudDeAsistenciaServiceImpl;

import com.pubnub.api.PubNubException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/solicitud")
@RequiredArgsConstructor
public class SolicitudDeAsistenciaController {

    private final SolicitudDeAsistenciaServiceImpl solicitudDeAsistenciaService;
    private final AdultoMayorServiceImpl adultoMayorService;


    /*@PostMapping
    public ResponseEntity<SolicitudDeAsistencia> crearSolicitudDeAsistencia(@RequestBody SolicitudDeAsistencia solicitudDeAsistencia) {
        SolicitudDeAsistencia nuevaSolicitud = solicitudDeAsistenciaService.crearSolicitud(solicitudDeAsistencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSolicitud);
    }*/

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarSolicitud(@RequestBody SolicitudDTO solicitudDTO) throws PubNubException {

        try {
            // Verificar si solicitudDTO o solicitudDTO.getAdultoMayorId() es nulo
            if (solicitudDTO == null || solicitudDTO.getAdultoMayorId() == null) {
                return ResponseEntity.badRequest().body("Datos de solicitud incompletos");
            }

            // Convertir el DTO a un objeto de tipo SolicitudDeAsistencia
            SolicitudDeAsistencia solicitud = convertirSolicitudDTO(solicitudDTO);

            // Obtener el Adulto Mayor correspondiente a la solicitud
            AdultoMayor adultoMayor = adultoMayorService.obtenerPorId(solicitudDTO.getAdultoMayorId());

            // Verificar si adultoMayor es nulo
            if (adultoMayor == null) {
                return ResponseEntity.badRequest().body("No se encontró el adulto mayor asociado a la solicitud");
            }

            solicitud.setAdultoMayor(adultoMayor);

            // Enviar la solicitud a través del Adulto Mayor
            boolean enviado = solicitudDeAsistenciaService.enviarSolicitud(solicitud, solicitudDTO.getMensaje());

            if (enviado) {
                return ResponseEntity.ok("Solicitud enviada con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Ocurrió un error al enviar la solicitud");
            }
        } catch (PubNubException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al enviar la solicitud a través de PubNub");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al procesar la solicitud");
        }
    }


    @PostMapping("/solicitudes")
    private SolicitudDeAsistencia convertirSolicitudDTO(@RequestBody SolicitudDTO solicitudDTO) {

        SolicitudDeAsistencia solicitud = SolicitudMapper.dtoToEntity(solicitudDTO);

        // Utilizar el servicio para obtener la entidad AdultoMayor correspondiente al ID del DTO
        AdultoMayor adultoMayor = adultoMayorService.obtenerPorId(solicitudDTO.getAdultoMayorId());
        // Establecer la entidad AdultoMayor en la SolicitudDeAsistencia
        solicitud.setAdultoMayor(adultoMayor);

        // Supongamos que el DTO también incluye el estado y la hora
        solicitud.setEstado(solicitudDTO.getEstado());

        LocalDateTime now = LocalDateTime.now();
        solicitud.setHora(now);

        // Devolver la SolicitudDeAsistencia
        return solicitud;
    }


    /*private SolicitudDeAsistencia convertirSolicitudDTO(SolicitudDTO solicitudDTO) {
        SolicitudDeAsistencia solicitud = new SolicitudDeAsistencia();
        solicitud.setVoluntario(solicitudDTO.getVoluntarioId());
        solicitud.setAdultoMayor(solicitudDTO.getAdultoMayorId());
        return solicitud;
    }*/



    
    /*@GetMapping("/{solicitudId}")
    public ResponseEntity<SolicitudDeAsistencia> obtenerSolicitudDeAsistencia(@PathVariable int solicitudId) {
        SolicitudDeAsistencia solicitud = solicitudDeAsistenciaService.obtenerSolicitud(solicitudId);
        return ResponseEntity.ok(solicitud);
    }*/

        @PutMapping("/{solicitudId}/estado")
        public ResponseEntity<String> actualizarEstadoSolicitudDeAsistencia ( @PathVariable int solicitudId,
        @RequestParam String nuevoEstado){
            SolicitudDeAsistencia solicitud = solicitudDeAsistenciaService.obtenerSolicitud(solicitudId);
            solicitudDeAsistenciaService.actualizarSolicitud(solicitud, nuevoEstado);
            return ResponseEntity.ok("Estado de la solicitud actualizado exitosamente.");
        }

        @GetMapping("/{solicitudId}")
        public ResponseEntity<SolicitudDTO> obtenerSolicitudDeAsistencia (@PathVariable Integer solicitudId){
            SolicitudDeAsistencia solicitud = solicitudDeAsistenciaService.obtenerSolicitud(solicitudId);
            solicitud.getVoluntario();
            solicitud.getChat();

            ModelMapper modelMapper = new ModelMapper();
            SolicitudDTO solicitudDTO = modelMapper.map(solicitud, SolicitudDTO.class);

            return ResponseEntity.ok(solicitudDTO);
        }
    }





