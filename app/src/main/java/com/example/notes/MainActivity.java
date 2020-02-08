package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.example.notes.Activities.NotesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.circle_Iv)
    ImageView circleIV;

    @BindView(R.id.ic_app)
    ImageView appIcon;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Log.d(TAG, "onCreate: activity is been created");

        startAnimation();

        handler = new Handler();
    }

    private Runnable runnable = () -> {
        Log.d(TAG, "run: New Activity");
        startActivity(new Intent(getApplicationContext(), NotesActivity.class));
        finish();
    };

    private void startAnimation() {
        //vars for setting up f0r the  animations
        DecelerateInterpolator DECCELERATE_INTERPOLATOR = new DecelerateInterpolator();
        BounceInterpolator BOUNCE_INTERPOLATOR = new BounceInterpolator();

        //clear all the animation
        circleIV.animate().cancel();
        appIcon.animate().cancel();
        circleIV.setScaleX(0);
        circleIV.setScaleY(0);
        appIcon.setScaleX(0);
        appIcon.setScaleY(0);

        AnimatorSet animatorSet = new AnimatorSet();

        Log.d(TAG, "startAnimation: ScaleX"+circleIV.getScaleX());
        Log.d(TAG, "startAnimation: ScaleY"+circleIV.getScaleY());

        ObjectAnimator starScaleYAnimator = ObjectAnimator.ofFloat(circleIV, ImageView.SCALE_Y, 0.1f, 1f);
        starScaleYAnimator.setDuration(1500);
        starScaleYAnimator.setStartDelay(0);
        starScaleYAnimator.setInterpolator(DECCELERATE_INTERPOLATOR);

        ObjectAnimator starScaleXAnimator = ObjectAnimator.ofFloat(circleIV, ImageView.SCALE_X, 0.1f, 1f);
        starScaleXAnimator.setDuration(1500);
        starScaleXAnimator.setStartDelay(0);
        starScaleXAnimator.setInterpolator(DECCELERATE_INTERPOLATOR);

        ObjectAnimator starScaleYAnimatorAppIcon = ObjectAnimator.ofFloat(appIcon, ImageView.SCALE_Y, 0.1f, 1f);
        starScaleYAnimator.setDuration(1000);
        starScaleYAnimator.setStartDelay(100);
        starScaleYAnimator.setInterpolator(BOUNCE_INTERPOLATOR);

        ObjectAnimator starScaleXAnimatorAppIcon = ObjectAnimator.ofFloat(appIcon, ImageView.SCALE_X, 0.1f, 1f);
        starScaleXAnimator.setDuration(1000);
        starScaleXAnimator.setStartDelay(100);
        starScaleXAnimator.setInterpolator(BOUNCE_INTERPOLATOR);

        animatorSet.playTogether(
                starScaleYAnimatorAppIcon,
                starScaleXAnimatorAppIcon,
                starScaleYAnimator,
                starScaleXAnimator
        );

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                handler.postDelayed(runnable,1500);
                super.onAnimationEnd(animation);
            }
        });

        animatorSet.start();
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable);
        super.onPause();
    }
}
