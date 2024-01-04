package com.shivatalk.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    RelativeLayout account,chats,notiifications,datastorage,help,invitefriend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        this.setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        account=findViewById(R.id.account_section_id);
        chats=findViewById(R.id.chat_section_id);
        notiifications=findViewById(R.id.notification_section_id);
        datastorage=findViewById(R.id.data_section_id);
        help=findViewById(R.id.help_section_id);
        invitefriend=findViewById(R.id.invite_section_id);

        account.setOnClickListener(listener);
        chats.setOnClickListener(listener);
        notiifications.setOnClickListener(listener);
        datastorage.setOnClickListener(listener);
        help.setOnClickListener(listener);
        invitefriend.setOnClickListener(listener);

    }

    RelativeLayout.OnClickListener listener=new RelativeLayout.OnClickListener(){
        @Override
        public void onClick(View v) {

            if(v==account) {
                startActivity(new Intent(SettingsActivity.this,SettingsOfAccount.class));
            }
            else if(v==chats) {
                startActivity(new Intent(SettingsActivity.this,SettingsOfChat.class));
            }
            else if(v==notiifications) {
                startActivity(new Intent(SettingsActivity.this,SettingsOfNotifications.class));
            }
            else if(v==datastorage) {
                Log.d("tag", "data storage");
            }
            else if(v==help){
                startActivity(new Intent(SettingsActivity.this,SettingsOfHelp.class));
            }
            else if(v==invitefriend) {
                Log.d("tag", "invite friends");
            }

        }
    };


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
           onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}