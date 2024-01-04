package com.shivatalk.whatsapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shivatalk.whatsapp.Adapters.ChatListAdapter;
import com.shivatalk.whatsapp.ChatUser;
import com.shivatalk.whatsapp.MainActivity;
import com.shivatalk.whatsapp.R;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private RecyclerView listView;
    private ChatListAdapter customAdapter;
    private List<ChatUser> userlist;
    private  View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         v=inflater.inflate(R.layout.chat_fragment,container,false);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        userlist=new ArrayList<ChatUser>();
        userlist.add(new ChatUser("Shivam","hii friends","Today"));
        userlist.add(new ChatUser("Siddhant","hello guys","yesterday"));
        userlist.add(new ChatUser("Shubham","or ka ho rha h","today"));
        userlist.add(new ChatUser("Priya","hii friends","15/02/20"));
        userlist.add(new ChatUser("Pooja","hii jii","18/02/99"));
        userlist.add(new ChatUser("Khushbu Soni","hii friends","Today"));
        userlist.add(new ChatUser("Raju","hii raju kya ho rha h","Today"));
        userlist.add(new ChatUser("pratibha","hii raju kya ho rha h","Today"));
        userlist.add(new ChatUser("Jaiswal clg","hii badda kya ho rha h","Today"));
        userlist.add(new ChatUser("Gaurav Patel","hii bhai kya ho rha h","Today"));


        customAdapter=new ChatListAdapter(userlist);
        listView=v.findViewById(R.id.chat_list);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listView.setAdapter(customAdapter);
    }


}
