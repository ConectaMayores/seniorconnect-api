package com.conectamayores.seniorconnectapi.controller;


import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.Chat;
import com.conectamayores.seniorconnectapi.repository.ChatRepository;
import com.conectamayores.seniorconnectapi.service.impl.ChatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatServiceImpl servicey;

    @PostMapping
    public ResponseEntity<Chat> crearChat(@RequestBody Chat chat) {
        Chat chat1 = servicey.crearChat(chat);
        return new ResponseEntity<Chat>(chat, HttpStatus.CREATED);
    }
}
