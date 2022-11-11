package com.example.chat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "messages")
@Table
public class Message {
    @Id
    @JsonIgnore
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
}
