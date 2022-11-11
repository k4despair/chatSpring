package com.example.chat.enums;

public enum TypeEnum {
    MESSAGE(1, "Message");

    final int id;
    final public String type;

    TypeEnum(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
