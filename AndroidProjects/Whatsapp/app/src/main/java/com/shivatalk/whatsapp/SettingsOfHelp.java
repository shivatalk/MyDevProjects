package com.shivatalk.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SettingsOfHelp extends AppCompatActivity {

    LinearLayout faq,contactus,term_privacy_policy,appinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_of_help);

        this.setTitle("Help");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        faq=findViewById(R.id.faq);
        contactus=findViewById(R.id.contact_us);
        term_privacy_policy=findViewById(R.id.terms_privacy_policy);
        appinfo=findViewById(R.id.app_info);

        faq.setOnClickListener(layout_listener);
        contactus.setOnClickListener(layout_listener);
        term_privacy_policy.setOnClickListener(layout_listener);
        appinfo.setOnClickListener(layout_listener);


    }


    LinearLayout.OnClickListener layout_listener=new LinearLayout.OnClickListener(){
        @Override
        public void onClick(View v) {

            if(v==faq)
            {
                Toast.makeText(SettingsOfHelp.this,"FAQ",Toast.LENGTH_SHORT).show();
            }
            else if(v==contactus)
            {
                Toast.makeText(SettingsOfHelp.this,"contact",Toast.LENGTH_SHORT).show();
            }
            else if(v==term_privacy_policy)
            {
                Toast.makeText(SettingsOfHelp.this,"Privacy Policy",Toast.LENGTH_SHORT).show();
            }
            else if (v==appinfo)
            {
                Toast.makeText(SettingsOfHelp.this,"app info",Toast.LENGTH_SHORT).show();
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


