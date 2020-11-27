package mps.project.harmony.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import mps.project.harmony.Fragments.walkThrough1;
import mps.project.harmony.Fragments.walkThrough2;
import mps.project.harmony.Fragments.walkThrough3;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 3;

    public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                walkThrough1 page1 = new walkThrough1();
                return page1;
            case 1:
                walkThrough2 page2 = new walkThrough2();
                return page2;
            case 2:
                walkThrough3 page3 = new walkThrough3();
                return page3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}