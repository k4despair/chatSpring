package com.example.chat.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private long id;
    private String author;
    private String text;
    private Instant date;
    private String type;
}
