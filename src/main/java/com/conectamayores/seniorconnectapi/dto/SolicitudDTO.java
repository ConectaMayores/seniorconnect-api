package com.conectamayores.seniorconnectapi.dto;

import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.Voluntario;

import java.sql.Time;
import java.time.LocalDateTime;

public class SolicitudDTO {

    private Integer solictudId;
    private Integer adultoMayorId;
    private String estado;
    private LocalDateTime hora;
    private String mensaje;

    public Integer getSolictudId() {
        return solictudId;
    }

    public void setSolictudId(Integer solictudId) {
        this.solictudId = solictudId;
    }

    public Integer getAdultoMayorId() {
        return adultoMayorId;
    }

    public void setAdultoMayorId(Integer adultoMayorId) {
        this.adultoMayorId = adultoMayorId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


}
