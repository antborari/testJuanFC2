package com.example.testjuanfc.chat.conversation.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testjuanfc.R;
import com.example.testjuanfc.chat.conversation.adapter.MainAdapter;
import com.example.testjuanfc.chat.conversation.contract.SuccessMessagesListener;
import com.example.testjuanfc.chat.conversation.viewmodel.MainViewModel;
import com.example.testjuanfc.chat.data.MessageDTO;
import com.example.testjuanfc.chat.data.MessageType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private MainAdapter mainAdapter;
    private List<MessageDTO> messages;
    private RecyclerView recyclerView;
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewModel();
        editText = findViewById(R.id.inputSend);
        initializeRecyclerView();
        getMessages();
        onClickArrowBack();
        sendMessage();
    }

    private void initViewModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void initializeRecyclerView() {
        messages = new ArrayList<>();
        mainAdapter = new MainAdapter(messages);
        recyclerView = findViewById(R.id.recyclerViewList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mainAdapter);
    }

    private void getMessages() {
        mainViewModel.getMessagesUser(new SuccessMessagesListener() {
            @Override
            public void getMessages(List<MessageDTO> messageDTOS) {
                messages.addAll(messageDTOS);
                mainAdapter.addMessageListNotifyDataChanged(messageDTOS);
                recyclerView.scrollToPosition(mainAdapter.getItemCount() - 1);
            }
        });
    }

    private int getReaded() {
        int readed = 0;
        for(MessageDTO messageDTO : messages) {
            if (messageDTO.getReaded() == 0) { readed++; }
        }
        return readed;
    }

    private void sendMessage() {
        Button button = findViewById(R.id.buttonSend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.sendMessage(new MessageDTO(editText.getText().toString(), 0, MessageType.Agent.getType()));
            }
        });
    }

    private void onClickArrowBack() {
        ImageView btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBack();
            }
        });
    }

    private void onBack() {
        this.onBackPressed();
    }

}
