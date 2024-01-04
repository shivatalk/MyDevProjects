package com.shivatalk.whatsapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shivatalk.whatsapp.Adapters.CallsListAdapter;
import com.shivatalk.whatsapp.Adapters.ChatListAdapter;
import com.shivatalk.whatsapp.CallUserList;
import com.shivatalk.whatsapp.ChatUser;
import com.shivatalk.whatsapp.R;

import java.util.ArrayList;
import java.util.List;

public class CallsFragment extends Fragment {

    private RecyclerView listView;
    private CallsListAdapter customAdapter;
    private List<CallUserList> userlist;
    private  View v;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.calls_fragment,container,false);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        userlist=new ArrayList<CallUserList>();
        userlist.add(new CallUserList("Shubham visk","20 september","4:25 pm"));
        userlist.add(new CallUserList("Sidhhant bhai","8 september","4:45 pm"));
        userlist.add(new CallUserList("Sandeep Jbp","8 june","4:15 pm"));
        userlist.add(new CallUserList("Jaiswal clg Jio","5 july","4:45 pm"));
        userlist.add(new CallUserList("Gaurav Patel"," 12 august","4:45 pm"));
        userlist.add(new CallUserList("Ankit Patel","15 may","3:45 pm"));
        userlist.add(new CallUserList("Shailja dii","25 april","4:44 pm"));
        userlist.add(new CallUserList("Shivam Singh","20 september","1:45 pm"));
        userlist.add(new CallUserList("Khushbu Soni","28 september","4:45 pm"));
        userlist.add(new CallUserList("Ratnesh Nema","14 june","7:45 pm"));

        customAdapter=new CallsListAdapter(userlist);
        listView=v.findViewById(R.id.calls_list);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listView.setAdapter(customAdapter);

    }
}
