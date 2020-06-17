package com.example.testjuanfc.chat.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testjuanfc.R;
import com.example.testjuanfc.chat.adapter.MainAdapter;
import com.example.testjuanfc.chat.contract.SuccessMessagesListener;
import com.example.testjuanfc.chat.data.MessageDTO;
import com.example.testjuanfc.chat.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private MainAdapter mainAdapter;
    private List<MessageDTO> messages;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewModel();
        initializeRecyclerView();
        getMessages();
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
                mainAdapter.setMessageList(messageDTOS);
            }
        });
    }

}
