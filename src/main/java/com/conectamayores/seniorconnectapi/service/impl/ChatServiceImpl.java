package com.conectamayores.seniorconnectapi.service.impl;

import com.conectamayores.seniorconnectapi.model.Chat;
import com.conectamayores.seniorconnectapi.repository.ChatRepository;
import com.conectamayores.seniorconnectapi.service.IChatService;
import com.pubnub.api.PubNub;
import com.pubnub.api.PubNubException;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.history.PNHistoryItemResult;
import com.pubnub.api.models.consumer.history.PNHistoryResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor

public class ChatServiceImpl implements IChatService<Chat, Integer> {

    private final ChatRepository chatRepository;
    private final PubNub pubNub;

    public List<Chat> listarChat(Integer solicitudId) {

        List <Chat> mensajes = new ArrayList<>();
        pubNub.history()
                .channel("chat-" + solicitudId)
                .count(100) // limita a los últimos 100 mensajes
                .async(new PNCallback<>() {
                    @Override
                    public void onResponse(PNHistoryResult result, PNStatus status) {
                        if (!status.isError()) {
                            for (PNHistoryItemResult item : result.getMessages()) {
                                Chat chat = new Chat();
                                chat.setMensaje(String.valueOf(item.getEntry()));
                                // Imprime cada mensaje
                                System.out.println(item.getEntry());
                            }
                        } else {
                            status.getErrorData().getThrowable().printStackTrace();
                        }
                    }
                });

        return mensajes;

    }


    public void enviarChat(Chat chat) throws PubNubException {

        chatRepository.save(chat);
        pubNub.publish()
                .channel("chat-" + chat.getSolicitud().getSolicitudDeAsistenciaId())
                .message(chat.getMensaje())
                .sync();

        //Usar el pubnub para notificarlos*/

    }


    public Chat crearChat(Chat chat) {

        return chatRepository.save(chat);
    }


}
