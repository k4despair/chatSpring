package com.example.chat.controllers;

import com.example.chat.dto.MessageDTO;
import com.example.chat.dto.mappers.MessageMapper;
import com.example.chat.handler.TypeEnumException;
import com.example.chat.models.Message;
import com.example.chat.services.ErrorsService;
import com.example.chat.services.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class RestMessageController {
    @Autowired
    protected MessageService messageService;
    @Autowired
    protected ErrorsService errorsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MessageDTO>> getChat() {
        return new ResponseEntity<>(MessageMapper.INSTANCE.toListDTO(messageService.getAll()), HttpStatus.CREATED);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDTO> postChat(@Valid @RequestBody MessageDTO messageDTO) {
        System.out.println(messageDTO.toString());
        Message message = MessageMapper.INSTANCE.fromDTO(messageDTO);
        System.out.println(message.toString());
        messageService.save(message);
        return new ResponseEntity<>(MessageMapper.INSTANCE.toDTO(message), HttpStatus.CREATED);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class, TypeMismatchException.class, TypeEnumException.class})
    public ResponseEntity<String> emptyField(Exception exception) throws JsonProcessingException {
        String resp = JsonMapper.builder().addModules(new JavaTimeModule()).build().writeValueAsString(errorsService.empty(exception.getMessage()));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(resp, responseHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public ResponseEntity<String> serverProblem(Exception exception) throws JsonProcessingException {
        String resp = JsonMapper.builder().addModules(new JavaTimeModule()).build().writeValueAsString(errorsService.serverError(exception.getMessage()));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(resp, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
