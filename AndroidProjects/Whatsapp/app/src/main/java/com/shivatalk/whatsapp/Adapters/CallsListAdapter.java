package com.shivatalk.whatsapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shivatalk.whatsapp.CallUserList;
import com.shivatalk.whatsapp.R;

import java.util.List;

public class CallsListAdapter extends RecyclerView.Adapter<CallsListAdapter.Holder> {
    private LayoutInflater inflater;
    private List<CallUserList> mlist;

    public CallsListAdapter(List<CallUserList> mlist) {
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(parent.getContext());
        View chatviews=inflater.inflate(R.layout.custom_calls_list,null);
        return new Holder(chatviews);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {


        if(position%2==0)
        { holder.dp.setImageResource(R.drawable.ic_user_24);
        }
        else {
            holder.dp.setImageResource(R.drawable.shiva);
        }


        holder.name.setText(mlist.get(position).getName());
        holder.incoming.setImageResource(R.drawable.ic_call_received_24);
        if(mlist.get(position).getCount()<=1)
            holder.date.setText(""+mlist.get(position).getDate()+" "+mlist.get(position).getTime());
        else
            holder.date.setText("("+mlist.get(position).getCount()+") "+mlist.get(position).getDate()+" "+mlist.get(position).getTime());


        holder.voice_icon.setImageResource(R.drawable.ic_voice_call_24);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class Holder extends RecyclerView.ViewHolder
    {
        ImageView dp;
        TextView name;
        ImageView incoming;
        ImageView outging;
        TextView date;
        ImageView video_icon;
        ImageView voice_icon;

        public Holder(@NonNull View ItemView) {
            super(ItemView);
            this.dp=ItemView.findViewById(R.id.last_dp_call);
            this.name=ItemView.findViewById(R.id.name_of_user);
            this.incoming=ItemView.findViewById(R.id.incoming_icon);
            this.outging=ItemView.findViewById(R.id.outgoing_icon);
            this.date=ItemView.findViewById(R.id.date_time);
            this.video_icon=ItemView.findViewById(R.id.video_inc_call);
            this.voice_icon=ItemView.findViewById(R.id.voice_inc_call);

        }
    }
}
