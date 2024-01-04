package com.shivatalk.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SettingsOfNotifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_of_notifications);

        this.setTitle("Notifications");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.notification_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        else if(item.getItemId()==R.id.reset_notification)
        {
            Toast.makeText(this,"rset Notification ",Toast.LENGTH_SHORT).show();
        }
        return true;

    }




}