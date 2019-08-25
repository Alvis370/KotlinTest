package com.illuminator.kotlintest.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.illuminator.kotlintest.R;
import com.illuminator.kotlintest.main.KotlinTestActivity;
import com.illuminator.kotlintest.main.TestActivity;

public class TestFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_test_2, container, false);

        Button BtnOne = view.findViewById(R.id.fragmentOneBtn);
        Button BtnTwo = view.findViewById(R.id.fragmentTwoBtn);
        Button BtnThree = view.findViewById(R.id.goToActivityBtn);

        BtnOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (TestActivity)getActivity();
                if(activity != null){
                    ((TestActivity)activity).showFragment(0);
                }
            }
        });

        BtnTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (TestActivity)getActivity();
                if(activity != null){
                    ((TestActivity)activity).showFragment(1);
                }
            }
        });

        BtnThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KotlinTestActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
