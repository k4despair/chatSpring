package com.example.chat.controllers;


import com.example.chat.models.Message;
import com.example.chat.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/")
    public String chat(Model model) {
        model.addAttribute("chat", messageService.listMessages());
        return "chat";
    }

    @PostMapping("/new")
    public String createMessage(Message message) {
        messageService.save(message.getUserName(), message.getMessage());
        return "redirect:/";
    }
}
