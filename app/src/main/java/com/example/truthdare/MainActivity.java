package com.example.truthdare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   ImageView bottleImage;
   Button button;
   int initialDirection=0;
   int newDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottleImage = findViewById(R.id.bottle);
        button= findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               rotateBottle();
            }
        });

    }
    private void rotateBottle() {
        Random r = new Random();
       newDirection = r.nextInt(3600) + 1;
        float pivotX = bottleImage.getWidth() / 2;
        float pivotY = bottleImage.getHeight() / 2;
        Animation rotate = new RotateAnimation(initialDirection,newDirection,pivotX,pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        bottleImage.startAnimation(rotate);
        initialDirection = newDirection;
    }
}
