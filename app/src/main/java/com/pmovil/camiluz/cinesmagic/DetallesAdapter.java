package com.pmovil.camiluz.cinesmagic;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Camilo on 11/04/2017.
 */

public class DetallesAdapter extends FragmentPagerAdapter {

    // private final static int PAGE_COUNT = 4;
    // private String[] tabTitles = new String[] {"Numbers", "Family", "Colors", "Phrases"};
    private Context mContext;

    public DetallesAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SinopsisFragment();
        } else if (position == 1) {
            return new TrailerFragment();
        } else {
            return new ReservasFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return tabTitles[position];
        if (position == 0) {
            return "Sinopsis";
        } else if (position == 1) {
            return "Trailer";
        } else {
            return "Reservas";
        }
    }
}
