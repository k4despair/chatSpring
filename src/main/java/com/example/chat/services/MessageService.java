package com.example.chat.services;

import com.example.chat.enums.TypeEnum;
import com.example.chat.models.Message;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class MessageService {
    private final Set<Message> chat = new LinkedHashSet<>();

    {
        chat.add(new Message(UUID.randomUUID(), "user", "test message", OffsetDateTime.now(), TypeEnum.MESSAGE.type));
        chat.add(new Message(UUID.randomUUID(), "userNew", "test message kek", OffsetDateTime.now(), TypeEnum.MESSAGE.type));
    }

    public Set<Message> listMessages() {
        return chat;
    }

    public void save(Message message) {
        this.chat.add(message);
    }
}
