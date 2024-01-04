package com.shivatalk.whatsapp;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.shivatalk.whatsapp.Adapters.ChatListAdapter;
import com.shivatalk.whatsapp.Adapters.ViewPagerAdapter;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton chat,edit,camara,calls;
    private Button camarabutton;
    private TabLayout tabLayout;
    private MaterialToolbar topappbar;
    private static ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        this.intialization();

    }

    private void intialization()
    {

        chat=findViewById(R.id.floating_chat_button);
        edit=findViewById(R.id.floating_edit_button);
        camara=findViewById(R.id.floating_camara_button);
        calls=findViewById(R.id.floating_calls_button);
        edit.hide();camara.hide();calls.hide();


        camarabutton=findViewById(R.id.camarabtn);
        camarabutton.setOnClickListener(camaralisener);
        viewPager=findViewById(R.id.fragment_container);

        tabLayout=findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(tablistener);

        viewPagerAdapter=new ViewPagerAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);

        topappbar=findViewById(R.id.topAppBar);
        topappbar.setOnMenuItemClickListener(topappbarlistener);

        viewPager.addOnPageChangeListener(pagelistener);
    }

  private ViewPager.OnPageChangeListener pagelistener=new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            topappbar.getMenu().clear();
            switch (position) {
                case 0:topappbar.inflateMenu(R.menu.overflow_main);
                    chat.setVisibility(View.VISIBLE);edit.setVisibility(View.GONE);calls.setVisibility(View.GONE);camara.setVisibility(View.GONE);break;
                case 1:topappbar.inflateMenu(R.menu.status_overflow_menu);
                    chat.setVisibility(View.GONE);edit.setVisibility(View.VISIBLE);calls.setVisibility(View.GONE);camara.setVisibility(View.VISIBLE);break;
                case 2:topappbar.inflateMenu(R.menu.calls_overflow_menu);
                    chat.setVisibility(View.GONE);edit.setVisibility(View.GONE);calls.setVisibility(View.VISIBLE);camara.setVisibility(View.GONE);break;
                default:topappbar.inflateMenu(R.menu.overflow_main);
                    chat.setVisibility(View.VISIBLE);edit.setVisibility(View.GONE);calls.setVisibility(View.GONE);camara.setVisibility(View.GONE);break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    };

    private View.OnClickListener camaralisener=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent =new Intent(MainActivity.this,PersonalChatActivity.class);
            startActivity(intent);
        }
    };

    private MaterialToolbar.OnMenuItemClickListener topappbarlistener=new MaterialToolbar.OnMenuItemClickListener(){
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch(item.getItemId())
            {
                case R.id.search:
                    Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.new_group:
                    Toast.makeText(MainActivity.this,item.getTitle()+"menu",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.new_broadcast:
                    Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.whatsapp_web:
                    Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.starred_messages:
                    Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.settings:
                    startActivity(new Intent(MainActivity.this,SettingsActivity.class));
                    return true;

                case R.id.status_privacy:
                    startActivity(new Intent(MainActivity.this,StatusPrivacy.class));
                    return true;
                case R.id.status_setting:
                    startActivity(new Intent(MainActivity.this,SettingsActivity.class));
                    return true;
                case R.id.status_search:
                    Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.clear_call_logs:
                    clearCallLogs();
                    return true;
                case R.id.calls_setting:
                    startActivity(new Intent(MainActivity.this,SettingsActivity.class));
                    return true;
                case R.id.calls_search:
                    Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
                    return true;

                default:return true;
            }
        }
    };

    private void clearCallLogs()
    {

        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(this);
        builder.setMessage("Do you want to clear your entire call logs ?");
        builder.setCancelable(true);
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();
            }
        });


        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }


    private TabLayout.OnTabSelectedListener tablistener=new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            MainActivity.viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

}