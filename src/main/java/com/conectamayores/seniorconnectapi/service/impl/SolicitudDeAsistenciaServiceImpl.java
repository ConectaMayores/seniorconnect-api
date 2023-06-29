package com.conectamayores.seniorconnectapi.service.impl;

import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import com.conectamayores.seniorconnectapi.repository.SolicitudDeAsistenciaRepository;
import com.conectamayores.seniorconnectapi.service.ISolicitudDeAsistencia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SolicitudDeAsistenciaServiceImpl implements ISolicitudDeAsistencia {

    private final SolicitudDeAsistenciaRepository solicitudDeAsistenciaRepository;


    @Override
    public Object save(Object o) throws Exception {
        return null;
    }

    @Override
    public Object update(Object o, Object o2) throws Exception {
        return null;
    }

    @Override
    public List readAll() throws Exception {
        return null;
    }

    @Override
    public Object readById(Object o) throws Exception {
        return null;
    }

    @Override
    public void delete(Object o) throws Exception {

    }

    @Override
    public SolicitudDeAsistencia crearSolicitud(SolicitudDeAsistencia solicitud) {
        return solicitudDeAsistenciaRepository.save(solicitud);
    }

    @Override
    public SolicitudDeAsistencia obtenerSolicitud(int id) {
        return solicitudDeAsistenciaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la solicitud de asistencia con el ID: " + id));
    }

    @Override
    public List<SolicitudDeAsistencia> obtenerTodasLasSolicitudes() {
        return solicitudDeAsistenciaRepository.findAll();
    }

    @Override
    public List<SolicitudDeAsistencia> obtenerSolicitudesPorEstado(String estado) {
        return null;
    }

    @Override
    public void actualizarSolicitud(SolicitudDeAsistencia solicitud, String nuevoEstado) {
        solicitud.setEstado(nuevoEstado);
        solicitudDeAsistenciaRepository.save(solicitud);
    }

    @Override
    public void eliminarSolicitud(int id) {
        solicitudDeAsistenciaRepository.deleteById(id);
    }
}
