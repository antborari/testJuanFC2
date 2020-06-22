package com.example.testjuanfc.chat.viewmodel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

import com.example.testjuanfc.chat.contract.SuccessMessagesListener;
import com.example.testjuanfc.chat.data.MessageDTO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference().child ("listChats");

    public void getMessagesUser(SuccessMessagesListener successMessagesListener) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<MessageDTO> messageDTOS = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    try {
                        MessageDTO messageDTO = snapshot.getValue(MessageDTO.class);
                        messageDTOS.add(messageDTO);
                    }catch (DatabaseException ex) {
                    }
                }
                successMessagesListener.getMessages(messageDTOS);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void sendMessage(MessageDTO messageDTO) {
        ref.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                ref.push().setValue(messageDTO);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {

            }
        });
    }

}
