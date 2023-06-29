package com.conectamayores.seniorconnectapi.dto;

import java.sql.Time;

public class SolicitudDTO {

    private Long solicitudId;
    private String estado;
    private Time hora;
    private VoluntarioDTO voluntario;
    private ChatDTO chat;

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public VoluntarioDTO getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(VoluntarioDTO voluntario) {
        this.voluntario = voluntario;
    }

    public ChatDTO getChat() {
        return chat;
    }

    public void setChat(ChatDTO chat) {
        this.chat = chat;
    }
}
