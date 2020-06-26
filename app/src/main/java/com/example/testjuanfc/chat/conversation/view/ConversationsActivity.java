package com.example.testjuanfc.chat.conversation.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testjuanfc.R;
import com.example.testjuanfc.chat.conversation.adapter.ConversationAdapter;
import com.example.testjuanfc.chat.conversation.contract.SuccessUsersListener;
import com.example.testjuanfc.chat.conversation.viewmodel.ConversationViewModel;
import com.example.testjuanfc.chat.data.ConversationDTO;
import com.example.testjuanfc.chat.data.randomuser.ResultsDTO;
import com.example.testjuanfc.chat.data.randomuser.UserDTO;

import java.util.List;

public class ConversationsActivity extends AppCompatActivity {

    private ConversationViewModel conversationViewModel;
    private RecyclerView recyclerViewConversation;
    private ConversationAdapter conversationAdapter;
    private List<ConversationDTO> conversationDTOS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        initViewModel();
        goToUsers();
    }

    private void goToUsers() {
        conversationViewModel.getUsers(3, new SuccessUsersListener() {
            @Override
            public void retrieveUsers(ResultsDTO resultsDTO) {
                initializeAdapter(resultsDTO.getResults());
            }
        });
    }

    private void initViewModel() {
        conversationViewModel = new ViewModelProvider(this).get(ConversationViewModel.class);
    }

    private void initializeAdapter(List<UserDTO> userDTOS) {
        conversationAdapter = new ConversationAdapter(userDTOS);
        recyclerViewConversation = findViewById(R.id.recyclerViewConversation);
        recyclerViewConversation.setAdapter(conversationAdapter);
    }

}
