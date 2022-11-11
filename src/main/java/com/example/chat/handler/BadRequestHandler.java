package com.example.chat.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestHandler extends RuntimeException {
    @NotNull
    private int status;
    @NotBlank
    private String title;
    @NotBlank
    private String details;

    public BadRequestHandler(String title, String details) {
        this.status = 400;
        this.title = title;
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
