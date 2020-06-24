package com.example.testjuanfc.chat.conversation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testjuanfc.R;
import com.example.testjuanfc.chat.data.ConversationDTO;
import com.example.testjuanfc.chat.data.randomuser.ResultsDTO;
import com.example.testjuanfc.chat.data.randomuser.UserDTO;

import java.util.List;

public class ConversationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<UserDTO> conversationList;

    public ConversationAdapter(List<UserDTO> conversationList) {
        this.conversationList = conversationList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_conversation, parent, false);
        return new ViewHolderConversation(view);
    }

    public void refreshConversationListNotifyDataChanged(List<UserDTO> conversationDTOS) {
        conversationList = conversationDTOS;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolderConversation) holder).bind(conversationList.get(position));
    }

    @Override
    public int getItemCount() {
        return conversationList.size();
    }

    class ViewHolderConversation extends RecyclerView.ViewHolder {
        private TextView cnvTitle;
        private TextView cnvSubtitle;
        private LinearLayout removeItem;

        public ViewHolderConversation(@NonNull View itemView) {
            super(itemView);
            cnvTitle = itemView.findViewById(R.id.cnvTitle);
            cnvSubtitle = itemView.findViewById(R.id.cnvSubtitle);
            removeItem = itemView.findViewById(R.id.removeItem);
        }

        public void bind(UserDTO conversationDTO) {
            cnvTitle.setText(conversationDTO.getPhone());
            cnvSubtitle.setText(conversationDTO.getEmail());
            removeItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
