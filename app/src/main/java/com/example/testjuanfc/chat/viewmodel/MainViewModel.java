package com.example.testjuanfc.chat.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.testjuanfc.chat.contract.SuccessMessagesListener;
import com.example.testjuanfc.chat.data.MessageDTO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("chat");

    public void getMessagesUser(SuccessMessagesListener successMessagesListener) {
        List<MessageDTO> messageDTOS = new ArrayList<>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    MessageDTO messageDTO = snapshot.getValue(MessageDTO.class);
                    messageDTOS.add(messageDTO);
                }
                successMessagesListener.getMessages(messageDTOS);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


//    private List<MessageDTO> toPatient(DataSnapshot dataSnapshot) {
//        for (:
//             ) {
//
//        }
//        return dataSnapshot.getChildren().forEach() map { children ->
//                children.getValue(PacientDTO::class.java)!!.setKeyPatient(children.key)
//        }.filter { value -> !value.PatientNo.isNullOrEmpty() }
//    }

}
