package com.illuminator.kotlintest.main;

import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.illuminator.kotlintest.R;
import com.illuminator.kotlintest.adapter.SectionStatePagerAdapter;
import com.illuminator.kotlintest.view.TestFragment;
import com.illuminator.kotlintest.view.TestFragment2;

import timber.log.Timber;

public class TestActivity extends AppCompatActivity {

    private SectionStatePagerAdapter sectionStatePagerAdapter;
    private ViewPager viewPager;
    private ImageView userAvatarImageView;

    private static final String TAG = "TestActivity";
    private int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Timber.d("This is Test Activity %d", a);

        userAvatarImageView = findViewById(R.id.userAvatarImageView);

        init();

        sectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.fragmentContainer);
        setViewPager(viewPager, sectionStatePagerAdapter);
    }

    private void init(){
        userAvatarImageView.setOnClickListener((v) -> Toast.makeText(this, "Lamdba Test", Toast.LENGTH_SHORT).show());
    }

    private void setViewPager(ViewPager viewPager, SectionStatePagerAdapter mSectionStatePagerAdapter){
        mSectionStatePagerAdapter.addFragment(new TestFragment(), "Fragment1");//No1 showing
        mSectionStatePagerAdapter.addFragment(new TestFragment2(), "Fragment2");
        viewPager.setAdapter(mSectionStatePagerAdapter);
    }

    public void showFragment(int fragmentNumber){
        if(viewPager.getCurrentItem() != fragmentNumber){
            viewPager.setCurrentItem(fragmentNumber);
        }else{
            Toast.makeText(this, "Already on the page!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void threadTest(){
        new Thread(() -> Timber.d("threadTest: %s", TAG));
    }
}
