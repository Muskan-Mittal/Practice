package com.example.muskan.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA=0;
    int scoreB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayScoreA(){
        TextView scoreView = (TextView) findViewById(R.id.teamA_score);
        scoreView.setText(String.valueOf(scoreA));
    }

    public void displayScoreB(){
        TextView scoreView = (TextView) findViewById(R.id.teamB_score);
        scoreView.setText(String.valueOf(scoreB));
    }

    public void PlusThree(View view){
        switch (view.getId())
        {
            case R.id.A3:
                scoreA+=3;
                displayScoreA();
                break;

            case R.id.B3:
                scoreB+=3;
                displayScoreB();
                break;
        }

    }

    public void PlusTwo(View view){
        switch (view.getId())
        {
            case R.id.A2:
                scoreA+=2;
                displayScoreA();
                break;

            case R.id.B2:
                scoreB+=2;
                displayScoreB();
                break;
        }
    }

    public void FreeThrow(View view){
        switch (view.getId())
        {
            case R.id.A1:
                scoreA+=1;
                displayScoreA();
                break;

            case R.id.B1:
                scoreB+=1;
                displayScoreB();
                break;
        }
    }

    public void Resetting(View view){
        scoreA=0;
        scoreB=0;
        displayScoreB();
        displayScoreA();
    }
}
