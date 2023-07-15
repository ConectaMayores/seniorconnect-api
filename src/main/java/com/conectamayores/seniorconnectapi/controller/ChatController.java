package com.conectamayores.seniorconnectapi.controller;



import com.conectamayores.seniorconnectapi.config.ChatMapper;
import com.conectamayores.seniorconnectapi.dto.ChatDTO;

import com.conectamayores.seniorconnectapi.dto.SolicitudDTO;
import com.conectamayores.seniorconnectapi.model.Chat;

import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import com.conectamayores.seniorconnectapi.service.impl.ChatServiceImpl;

import com.conectamayores.seniorconnectapi.service.impl.SolicitudDeAsistenciaServiceImpl;
import com.pubnub.api.PubNubException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatServiceImpl chatService;
    private final ChatMapper chatMapper;
    private  final SolicitudDeAsistenciaServiceImpl solicitudService;
    @PostMapping
    public ResponseEntity<ChatDTO> enviarChat(@RequestBody ChatDTO chatDTO) throws PubNubException {

        Chat chat = chatMapper.convertToEntity(chatDTO);
        chatService.enviarChat(chat);
        ChatDTO createdChatDTO = chatMapper.convertToDTO(chat);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdChatDTO);
    }

    @PostMapping("/chats")
    public ResponseEntity<ChatDTO> crearChat(@RequestBody ChatDTO chatDTO) {


        Chat chat = chatMapper.convertToEntity(chatDTO);


        SolicitudDTO solicitudDTO = chatDTO.getSolicitud();
        SolicitudDeAsistencia solicitud = solicitudService.obtenerSolicitud(solicitudDTO.getAdultoMayorId());


        chat.setSolicitud(solicitud);


        Chat nuevoChat = chatService.crearChat(chat);


        ChatDTO nuevoChatDTO = chatMapper.convertToDTO(nuevoChat);


        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoChatDTO);
    }


    @GetMapping("/chats/{id}")
    public ResponseEntity<List<Chat>> listarChat (@PathVariable("id") Integer id) {

        List<Chat> chats = chatService.listarChat(id);

        return new ResponseEntity<>(chats, HttpStatus.OK);

    }



}
