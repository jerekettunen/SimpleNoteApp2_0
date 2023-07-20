package org.example.notes2_0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import org.example.notes2_0.fragments.FragmentImportant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoteStorage.getInstance().addNote(new Note("Test", "testiä", 555, true));
        Button importantNotes = findViewById(R.id.btnImportant);
        importantNotes.setOnClickListener(listener);

        TabLayout tabLayout = findViewById(R.id.tabArea);
        ViewPager2 fragmentArea = findViewById(R.id.fragmentArea);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(this);
        fragmentArea.setAdapter(tabPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentArea.setCurrentItem(tab.getPosition());
                if (fragmentArea.getAlpha() != 1){
                    findViewById(R.id.frame).setAlpha(0);
                    fragmentArea.setAlpha(1);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (fragmentArea.getAlpha() != 1) {
                    findViewById(R.id.frame).setAlpha(0);
                    fragmentArea.setAlpha(1);
                }
            }
        });

        fragmentArea.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });


    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;
            fragment = new FragmentImportant();
            getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment)
                        .commit();
            findViewById(R.id.frame).setAlpha(1);
            findViewById(R.id.fragmentArea).setAlpha(0);

        }
    };
}