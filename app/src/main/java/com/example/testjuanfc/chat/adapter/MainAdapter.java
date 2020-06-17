package com.example.testjuanfc.chat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testjuanfc.R;
import com.example.testjuanfc.chat.data.MessageDTO;
import com.example.testjuanfc.chat.data.MessageType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MessageDTO> messageList;

    public MainAdapter(List<MessageDTO> messageList) {
        this.messageList = messageList;
    }

    private static final int TYPE_RECEIVER = 1;
    private static final int TYPE_SENDER = 0;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_SENDER) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_sender, parent, false);
            return new ViewHolderSender(view);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_receiver, parent, false);
            return new ViewHolderReceiver(view);
        }
    }

    public void setMessageList(List<MessageDTO> messageDTO) {
        messageList = messageDTO;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (messageList.get(position).getType() == (MessageType.Receiver.getType())) {
            return TYPE_RECEIVER;
        } else {
            return TYPE_SENDER;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_SENDER) {
            ((ViewHolderSender) holder).bind(messageList.get(position).getMessage());
        } else {
            ((ViewHolderReceiver) holder).bind(messageList.get(position).getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    class ViewHolderSender extends RecyclerView.ViewHolder {
        private TextView tvSender;

        public ViewHolderSender(@NonNull View itemView) {
            super(itemView);
            tvSender = itemView.findViewById(R.id.tvSender);
        }

        public void bind(String messenger) {
            tvSender.setText(messenger);
        }
    }

    class ViewHolderReceiver extends RecyclerView.ViewHolder {
        @BindView(R.id.tvReceiver)
        TextView tvReceiver;

        public ViewHolderReceiver(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(String messenger) {
            tvReceiver.setText(messenger);
        }
    }
}
