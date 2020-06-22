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

    private static final int TYPE_USER = 1;
    private static final int TYPE_AGENT = 0;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_AGENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_agent, parent, false);
            return new ViewHolderAgent(view);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_user, parent, false);
            return new ViewHolderUser(view);
        }
    }

    public void addMessageList(List<MessageDTO> messageDTO) {
        int initialPosition = messageList.size();
        messageList = messageDTO;
        notifyItemRangeInserted(initialPosition, messageList.size() - 1);
    }

    public void addMessageListNotifyDataChanged(List<MessageDTO> messageDTO) {
        messageList = messageDTO;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (messageList.get(position).getType() == (MessageType.User.getType())) {
            return TYPE_USER;
        } else {
            return TYPE_AGENT;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_AGENT) {
            ((ViewHolderAgent) holder).bind(messageList.get(position).getMessage());
        } else {
            ((ViewHolderUser) holder).bind(messageList.get(position).getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    class ViewHolderAgent extends RecyclerView.ViewHolder {
        private TextView tvSender;

        public ViewHolderAgent(@NonNull View itemView) {
            super(itemView);
            tvSender = itemView.findViewById(R.id.tvAgent);
        }

        public void bind(String messenger) {
            tvSender.setText(messenger);
        }
    }

    class ViewHolderUser extends RecyclerView.ViewHolder {
        @BindView(R.id.tvUser)
        TextView tvReceiver;

        public ViewHolderUser(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(String messenger) {
            tvReceiver.setText(messenger);
        }
    }
}
