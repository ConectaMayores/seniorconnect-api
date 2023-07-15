package com.conectamayores.seniorconnectapi.config;

import com.conectamayores.seniorconnectapi.dto.ChatDTO;
import com.conectamayores.seniorconnectapi.dto.VoluntarioDTO;
import com.conectamayores.seniorconnectapi.model.Chat;
import com.conectamayores.seniorconnectapi.model.Voluntario;
import org.springframework.stereotype.Component;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ChatMapper {
    private final ModelMapper modelMapper;

    public ChatMapper() {
        this.modelMapper = new ModelMapper();
    }

    public ChatDTO convertToDTO(Chat chat) {
        return modelMapper.map(chat, ChatDTO.class);
    }

    public Chat convertToEntity(ChatDTO chatDTO) {
        return modelMapper.map(chatDTO, Chat.class);
    }
}
