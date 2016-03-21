package com.example.tune.snap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;

import static com.example.tune.snap.SampleSlide.newInstance;

/**
 * Created by tune on 21/03/16.
 */
public class intro extends AppIntro {
    @Override
    public void init(Bundle savedInstanceState) {

        // Add your slide's fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        addSlide(newInstance(R.layout.first_fragment));
        addSlide(newInstance(R.layout.second_fragment));
        addSlide(newInstance(R.layout.third_fragment));

        // SHOW or HIDE the statusbar
        showStatusBar(true);
        // Hide Skip/Done button
        showSkipButton(true);
        showDoneButton(true);


        // Animations -- use only one of the below. Using both could cause errors.
        setFadeAnimation();
    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, snap.class);
        startActivity(intent);
    }
    @Override
    public void onSkipPressed() {
        // Do something when users tap on Skip button.
        loadMainActivity();
        Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNextPressed() {
        // Do something when users tap on Next button.
    }

    @Override
    public void onDonePressed() {
        // Do something when users tap on Done button.
        loadMainActivity();

    }

    @Override
    public void onSlideChanged() {
        // Do something when slide is changed
    }
}
