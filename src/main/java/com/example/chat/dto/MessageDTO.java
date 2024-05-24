package com.example.chat.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class MessageDTO {
    private long id;
    @NotBlank
    private String author;
    @NotBlank
    private String text;
    private Instant date;
    @NotBlank
    private String type;
}
