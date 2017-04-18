package com.pmovil.camiluz.cinesmagic;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Camilo on 11/04/2017.
 */

public class PrincipalAdapter extends FragmentPagerAdapter {

    // private final static int PAGE_COUNT = 4;
    // private String[] tabTitles = new String[] {"Numbers", "Family", "Colors", "Phrases"};
    private Context mContext;

    public PrincipalAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CarteleraFragment();
        } else {
            return new TusReservasFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return tabTitles[position];
        if (position == 0) {
            return "Cartelera";
        } else {
            return "Tu Reserva";
        }
    }
}
