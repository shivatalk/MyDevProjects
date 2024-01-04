package com.shivatalk.whatsapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shivatalk.whatsapp.ChatUser;
import com.shivatalk.whatsapp.R;

import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.Holder> {
    private LayoutInflater inflater;
    private List<ChatUser> mlist;

    public ChatListAdapter(List<ChatUser> list) {
        this.mlist=list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        inflater=LayoutInflater.from(parent.getContext());
        View chatviews=inflater.inflate(R.layout.custom_chat_list,null);
        return new Holder(chatviews);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.profile.setImageResource(R.drawable.shiva);
        holder.name.setText(mlist.get(position).getName());
        holder.msg.setText(mlist.get(position).getLast_msg());
        holder.date.setText(mlist.get(position).getDate());
        if(position%2==0) {
            holder.badge.setImageResource(R.drawable.ic_badge_24);
            holder.profile.setImageResource(R.drawable.ic_user_24);
        }
    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }


    class Holder extends RecyclerView.ViewHolder
    {
        ImageView profile;
        TextView name;
        TextView msg;
        TextView date;
        ImageView badge;

        public Holder(@NonNull View ItemView) {
            super(ItemView);
            this.profile=ItemView.findViewById(R.id.profile_picture);
            this.name=ItemView.findViewById(R.id.user_name);
            this.msg=ItemView.findViewById(R.id.sub_msg);
            this.date=ItemView.findViewById(R.id.user_date);
            this.badge=ItemView.findViewById(R.id.count);
        }
    }
}
