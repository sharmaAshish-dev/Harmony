package mps.project.harmony.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import mps.project.harmony.Fragments.login_page;
import mps.project.harmony.Fragments.signUpPage;
import mps.project.harmony.Fragments.walkThrough1;
import mps.project.harmony.Fragments.walkThrough2;
import mps.project.harmony.Fragments.walkThrough3;

public class loginSignUpSwitchAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 2;

    public loginSignUpSwitchAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                login_page page1 = new login_page();
                return page1;
            case 1:
                signUpPage page2 = new signUpPage();
                return page2;
        }

        return null;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
