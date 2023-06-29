package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.Chat;
import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import com.conectamayores.seniorconnectapi.model.Usuario;
import com.conectamayores.seniorconnectapi.repository.ChatRepository;

import java.util.List;
import java.util.Optional;

public interface IChatService <A, I extends Number> extends ICRUD<Chat,Integer>{


    Chat crearChat(Chat chat);

    Chat obtenerChatPorId(Integer id);

    List<Chat> obtenerTodosLosChats();

    void actualizarChat(Chat chat);

    void eliminarChat(Integer id);

}
