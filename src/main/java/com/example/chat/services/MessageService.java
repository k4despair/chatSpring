package com.example.chat.services;

import com.example.chat.models.Message;

import java.util.List;

public interface MessageService {

    void save(Message message);

    List<Message> getAll();
}
