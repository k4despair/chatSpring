package com.example.chat.services;

import com.example.chat.enums.TypeEnum;
import com.example.chat.models.Message;
import com.example.chat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public void save(Message message) {
        message.setDate(Instant.now());
        message.setType(TypeEnum.MESSAGE.getId());
        messageRepository.save(message);
    }
}
