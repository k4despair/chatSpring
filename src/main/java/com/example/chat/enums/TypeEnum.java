package com.example.chat.enums;

public enum TypeEnum {
    MESSAGE(0, "Message");

    final int id;
    final public String type;

    TypeEnum(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public static int getIdByType(String type) throws Exception {
        for (TypeEnum t : values()) {
            if (t.type.equals(type)) {
                return t.id;
            }
        }
        throw new Exception("Not found type");
    }

    public static String getTypeById(int id) throws Exception {
        for (TypeEnum t : values()) {
            if (t.id == id) {
                return t.type;
            }
        }
        throw new Exception("Not found id");
    }
}
