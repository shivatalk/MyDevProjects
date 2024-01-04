package com.shivatalk.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class StatusPrivacy extends AppCompatActivity {

    RadioGroup status_updates;
    MaterialButton donebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_privacy);
        this.setTitle("Status privacy");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        status_updates=findViewById(R.id.status_updates);
        status_updates.setOnCheckedChangeListener(radiogrplistener);

        donebtn=findViewById(R.id.status_done);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    RadioGroup.OnCheckedChangeListener radiogrplistener=new RadioGroup.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId)
            {
                case R.id.my_contacts:
                    Toast.makeText(StatusPrivacy.this,"My Contact",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.my_contacts_except:
                    Toast.makeText(StatusPrivacy.this,"My Contact Except",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.only_share_with:
                    Toast.makeText(StatusPrivacy.this,"Only Share",Toast.LENGTH_SHORT).show();
                    break;


            }

        }
    };

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