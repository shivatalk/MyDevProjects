package com.shivatalk.whatsapp.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.shivatalk.whatsapp.Fragments.CallsFragment;
import com.shivatalk.whatsapp.Fragments.ChatFragment;
import com.shivatalk.whatsapp.Fragments.StatusFragment;
import com.shivatalk.whatsapp.R;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int totalTabs;
    private Context mcontext;

    public ViewPagerAdapter(Context ctx,@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.totalTabs=behavior;
        this.mcontext=ctx;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment samplefragment=null;
        switch (position)
        {
            case 0:samplefragment=new ChatFragment();
            break;

            case 1:samplefragment=new StatusFragment();
                break;

            case 2:samplefragment=new CallsFragment();
                break;

            default:samplefragment=new ChatFragment();
        }
        return samplefragment;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position)
        {
            case 0:return mcontext.getString(R.string.chats);
            case 1:return mcontext.getString(R.string.status);
            case 2:return mcontext.getString(R.string.calls);
            default:return "";

        }

    }
}
