package com.example.chat.models;

import com.example.chat.enums.TypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.UUID;

public class Message {
    private UUID id;
    @NotBlank
    @JsonProperty("author")
    private String author;
    @NotBlank
    @JsonProperty("text")
    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss z", timezone = "GMT")
    private OffsetDateTime date;
    private String type;

    public Message(UUID id, @NotBlank String author, @NotBlank String text, OffsetDateTime date, String type) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.date = date;
        this.type = type;
    }

    public Message(@NotBlank @JsonProperty("author") String author, @NotBlank @JsonProperty("text") String text) {
        this.id = UUID.randomUUID();
        this.author = author;
        this.text = text;
        this.date = OffsetDateTime.now();
        this.type = TypeEnum.MESSAGE.type;
    }

    public UUID getId() {
        return this.id;
    }

    public @NotBlank String getAuthor() {
        return this.author;
    }

    public @NotBlank String getText() {
        return this.text;
    }

    public OffsetDateTime getDate() {
        return this.date;
    }

    public String getType() {
        return this.type;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonProperty("author")
    public void setAuthor(@NotBlank String author) {
        this.author = author;
    }

    @JsonProperty("text")
    public void setText(@NotBlank String text) {
        this.text = text;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss z", timezone = "GMT")
    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Message)) return false;
        final Message other = (Message) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$author = this.getAuthor();
        final Object other$author = other.getAuthor();
        if (this$author == null ? other$author != null : !this$author.equals(other$author)) return false;
        final Object this$text = this.getText();
        final Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Message;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $author = this.getAuthor();
        result = result * PRIME + ($author == null ? 43 : $author.hashCode());
        final Object $text = this.getText();
        result = result * PRIME + ($text == null ? 43 : $text.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "Message(id=" + this.getId() + ", author=" + this.getAuthor() + ", text=" + this.getText() + ", date=" + this.getDate() + ", type=" + this.getType() + ")";
    }
}
