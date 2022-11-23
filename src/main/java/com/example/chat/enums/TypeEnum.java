package com.example.chat.enums;

import com.example.chat.handler.TypeEnumException;

public enum TypeEnum {
    MESSAGE(0, "Message");

    final int id;
    final public String type;

    TypeEnum(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public static int getIdByType(String type) throws TypeEnumException {
        for (TypeEnum t : values()) {
            if (t.type.equals(type)) {
                return t.id;
            }
        }
        throw new TypeEnumException("Cannot found the @type: " + type);
    }

    public static String getTypeById(int id) throws TypeEnumException {
        for (TypeEnum t : values()) {
            if (t.id == id) {
                return t.type;
            }
        }
        throw new TypeEnumException("Cannot found id: " + id);
    }
}
