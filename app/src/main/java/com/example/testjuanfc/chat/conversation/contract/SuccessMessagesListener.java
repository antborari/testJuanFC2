package com.example.testjuanfc.chat.conversation.contract;

import com.example.testjuanfc.chat.data.MessageDTO;

import java.util.List;

public interface SuccessMessagesListener {

    void getMessages(List<MessageDTO> messageDTOS);

}
