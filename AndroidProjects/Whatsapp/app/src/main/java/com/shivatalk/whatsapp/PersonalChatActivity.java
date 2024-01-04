package com.shivatalk.whatsapp;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public class PersonalChatActivity extends AppCompatActivity {

    private MaterialToolbar topappbarchat;
    private MaterialButton backArrow,chat_camara,voice_record,send;
    private EditText chat_msg;
    int text_width;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_chat);
        this.setTitle("User Name");
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        ll=findViewById(R.id.ll);
        voice_record=findViewById(R.id.voice_record);
        send=findViewById(R.id.send);
        chat_camara=findViewById(R.id.chat_camara);
        chat_msg=findViewById(R.id.chat_msg);
        text_width=chat_msg.getLayoutParams().width;
        chat_msg.addTextChangedListener(textWatcher);
        topappbarchat=findViewById(R.id.topAppBarChat);
        topappbarchat.setOnMenuItemClickListener(topappbarchatlistener);

        backArrow=findViewById(R.id.backArrow);
        backArrow.setOnClickListener(backlistener);

    }



    TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


            if(s.length()>0)
            {
                chat_camara.setVisibility(View.GONE);
                voice_record.setVisibility(View.GONE);
                send.setVisibility(View.VISIBLE);

                chat_msg.getLayoutParams().width=text_width+60;

            }
            else
            {
                chat_camara.setVisibility(View.VISIBLE);
                voice_record.setVisibility(View.VISIBLE);
                send.setVisibility(View.GONE);
                chat_msg.getLayoutParams().width=text_width;

            }


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    MaterialButton.OnClickListener backlistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private MaterialToolbar.OnMenuItemClickListener topappbarchatlistener=new MaterialToolbar.OnMenuItemClickListener(){
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch(item.getItemId())
            {
                default:Toast.makeText(PersonalChatActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
        }
    };



}