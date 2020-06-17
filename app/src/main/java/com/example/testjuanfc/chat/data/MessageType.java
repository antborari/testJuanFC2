package com.example.testjuanfc.chat.data;

import com.google.firebase.database.PropertyName;

public enum  MessageType {
    Receiver(1),
    Sender(0),
    ;

    private int type;

    MessageType(int i) {
        type = i;
    }

    public int getType() {
        return type;
    }
}
