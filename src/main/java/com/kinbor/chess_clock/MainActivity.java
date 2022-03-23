package com.kinbor.chess_clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private  static final long Start_TIME_IN_MILLIS=600000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = Start_TIME_IN_MILLIS;

    private  static final long Start_TIME_IN_MILLIS_2=600000;
    private TextView mTextViewCountDown_2;
    private Button mButtonStartPause_2;
    private Button mButtonReset_2;
    private CountDownTimer mCountDownTimer_2;
    private boolean mTimerRunning_2;
    private long mTimeLeftInMillis_2 = Start_TIME_IN_MILLIS_2;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        mTextViewCountDown_2 = findViewById(R.id.text_view_countdown_2);
        mButtonStartPause_2 = findViewById(R.id.button_start_pause_2);
        mButtonReset_2 = findViewById(R.id.button_reset_2);






        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimerRunning) {
                    pauseTimer();
                }
                else{
                        startTimer();
                     }
                }

        });
        mButtonStartPause_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimerRunning_2) {
                    pauseTimer_2();
                }
                else{
                    startTimer_2();
                }
            }

        });



        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();

        mButtonReset_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer_2();
            }
        });
        updateCountDownText_2();


    }


    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long milisUntilFinished) {
                mTimeLeftInMillis = milisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);


            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);

    }


    private void startTimer_2(){
        mCountDownTimer_2 = new CountDownTimer(mTimeLeftInMillis_2,1000) {
            @Override
            public void onTick(long milisUntilFinished_2) {
                mTimeLeftInMillis_2 = milisUntilFinished_2;

                updateCountDownText_2();
            }

            @Override
            public void onFinish() {
                mTimerRunning_2 = false;
                mButtonStartPause_2.setText("Start");
                mButtonStartPause_2.setVisibility(View.INVISIBLE);
                mButtonReset_2.setVisibility(View.VISIBLE);


            }
        }.start();

        mTimerRunning_2 = true;
        mButtonStartPause_2.setText("pause");
        mButtonReset_2.setVisibility(View.INVISIBLE);

    }

    private void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning=false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);


    }

    private void pauseTimer_2(){
        mCountDownTimer_2.cancel();
        mTimerRunning_2=false;
        mButtonStartPause_2.setText("Start");
        mButtonReset_2.setVisibility(View.VISIBLE);

    }

    private void resetTimer(){
        mTimeLeftInMillis = Start_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);


    }
    private void resetTimer_2(){
        mTimeLeftInMillis_2 = Start_TIME_IN_MILLIS_2;
        updateCountDownText_2();
        mButtonReset_2.setVisibility(View.INVISIBLE);
        mButtonStartPause_2.setVisibility(View.VISIBLE);


    }


    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d",minutes,seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    private void updateCountDownText_2(){
        int minutes_2 = (int) (mTimeLeftInMillis_2 / 1000) / 60;
        int seconds_2 = (int) (mTimeLeftInMillis_2 / 1000) % 60;

        String timeLeftFormatted_2 = String.format(Locale.getDefault(), "%02d:%02d",minutes_2,seconds_2);

        mTextViewCountDown_2.setText(timeLeftFormatted_2);
    }


}