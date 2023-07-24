package com.example.splitbill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Locale;

public class Index extends AppCompatActivity {

    TextView tv_equal, tv_custom;
    Switch modeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Typeface SFPRO = Typeface.createFromAsset(getAssets(), "fonts/SFPRO.ttf");
        Typeface SFBOLD = Typeface.createFromAsset(getAssets(), "fonts/SFPRO-Bold.ttf");

        tv_equal = (TextView) findViewById(R.id.tv_equal);
        tv_custom = (TextView) findViewById(R.id.tv_custom);
        modeSwitch = (Switch) findViewById(R.id.switch1);

        tv_custom.setTypeface(SFPRO);
        tv_equal.setTypeface(SFBOLD);

        modeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tv_equal.setTextColor(ResourcesCompat.getColor(getResources(), R.color.dark_grey, null));
                    tv_custom.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white, null));
                    tv_equal.setTypeface(SFPRO);
                    tv_custom.setTypeface(SFBOLD);
                    replaceFragment(new CustomFragment());
                } else{
                    tv_equal.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white, null));
                    tv_custom.setTextColor(ResourcesCompat.getColor(getResources(), R.color.dark_grey, null));
                    tv_equal.setTypeface(SFBOLD);
                    tv_custom.setTypeface(SFPRO);
                    replaceFragment(new EqualFragment());
                }
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //This is to close down the softkeyboard by just clicking anywhere instead of the "tick" button
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}