package com.example.chat.services;

import com.example.chat.models.Message;

import javax.transaction.Transactional;
import java.util.List;

public interface MessageService {
    @Transactional
    void save(Message message);

    @Transactional
    List<Message> getAll();
}
