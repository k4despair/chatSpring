package com.example.chat.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@Entity(name = "messages")
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    @NotNull
    @Column(name = "type")
    private int type;

    public void setDate(Instant date) {
        if (date == null) {
            this.date = Instant.now();
        } else {
            this.date = date;
        }
    }
}
