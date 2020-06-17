package com.example.testjuanfc.chat.contract;

import com.example.testjuanfc.chat.data.MessageDTO;

import java.util.List;

public interface SuccessMessagesListener {

    void getMessages(List<MessageDTO> messageDTOS);

}
