package com.example.testjuanfc.chat.conversation.contract;

import com.example.testjuanfc.chat.data.MessageDTO;
import com.example.testjuanfc.chat.data.randomuser.ResultsDTO;

import java.util.List;

public interface SuccessUsersListener {

    void retrieveUsers(ResultsDTO resultsDTO);

}
