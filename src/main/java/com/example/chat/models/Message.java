package com.example.chat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Getter
@Setter
@Entity(name = "messages")
@Table
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "author")
    @NotBlank
    private String author;
    @Column(name = "text")
    @NotBlank
    private String text;
    @Column(name = "date")
    private Instant date;
    @Column(name = "type")
    private int type;

    public Message(long id, @NotBlank String author, @NotBlank String text, Instant date, int type) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.date = date;
        this.type = type;
    }

    public Message() {
    }
}
