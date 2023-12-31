package org.example.notes2_0;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.example.notes2_0.fragments.FragmentAdd;
import org.example.notes2_0.fragments.FragmentList;
import org.example.notes2_0.fragments.FragmentWelcome;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentWelcome();
            case 1:
                return new FragmentList();
            case 2:
                return new FragmentAdd();
            default:
                return new FragmentWelcome();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
