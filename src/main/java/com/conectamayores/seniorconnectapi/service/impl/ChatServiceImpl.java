package com.conectamayores.seniorconnectapi.service.impl;

import com.conectamayores.seniorconnectapi.model.Chat;
import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import com.conectamayores.seniorconnectapi.model.Usuario;
import com.conectamayores.seniorconnectapi.repository.ChatRepository;
import com.conectamayores.seniorconnectapi.repository.SolicitudDeAsistenciaRepository;
import com.conectamayores.seniorconnectapi.service.IChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements IChatService<Chat, Integer> {

    private final SolicitudDeAsistenciaRepository solicitudDeAsistenciaRepository;
    private final ChatRepository chatRepository;


    @Override
    public Chat save(Chat chat) throws Exception {
        return null;
    }

    @Override
    public Chat update(Chat chat, Integer integer) throws Exception {
        return null;
    }

    @Override
    public List<Chat> readAll() throws Exception {
        return null;
    }

    @Override
    public Chat readById(Integer integer) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer integer) throws Exception {

    }

    @Override
    public Chat crearChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public Chat obtenerChatPorId(Integer id) {
        return null;
    }

    @Override
    public List<Chat> obtenerTodosLosChats() {
        return null;
    }

    @Override
    public void actualizarChat(Chat chat) {

    }

    @Override
    public void eliminarChat(Integer id) {

    }
}
