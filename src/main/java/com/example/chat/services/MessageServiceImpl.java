package com.example.chat.services;

import com.example.chat.models.Message;
import com.example.chat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Transactional
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Transactional
    public void save(Message message) {
        message.setDate(Instant.now());
        messageRepository.save(message);
    }
}
