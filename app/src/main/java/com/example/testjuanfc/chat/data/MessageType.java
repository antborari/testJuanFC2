package com.example.testjuanfc.chat.data;

import com.google.firebase.database.PropertyName;

public enum  MessageType {
    Caller(1),
    Agent(0),
    ;

    private int type;

    MessageType(int i) {
        type = i;
    }

    public int getType() {
        return type;
    }
}
