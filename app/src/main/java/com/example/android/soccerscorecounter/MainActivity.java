package com.example.android.soccerscorecounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int TeamAScore = 0;
    int TeamBScore = 0;
    int TeamAYellowCard = 0;
    int TeamARedCard = 0;
    int TeamBYellowCard = 0;
    int TeamBRedCard = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textv = (TextView) findViewById(R.id.ScoreSummary);
        textv.setShadowLayer(50, 10, 10, Color.rgb(7, 115, 108));

        TextView textv1 = (TextView) findViewById(R.id.TeamA);
        textv1.setShadowLayer(10, 3, 2, Color.rgb(7, 93, 87));

        TextView textv2 = (TextView) findViewById(R.id.TeamB);
        textv2.setShadowLayer(10, 3, 2, Color.rgb(7, 93, 87));

        TextView textv3 = (TextView) findViewById(R.id.TeamA_label);
        textv3.setShadowLayer(15, 3, 2, Color.rgb(7, 93, 87));

        TextView textv4 = (TextView) findViewById(R.id.TeamB_label);
        textv4.setShadowLayer(15, 3, 2, Color.rgb(7, 93, 87));

        displayScore(TeamAScore, TeamBScore);
    }

    public void goalA(View view) {
        TeamAScore += 1;
        displayScore(TeamAScore, TeamBScore);
    }

    public void goalB(View view) {
        TeamBScore += 1;
        displayScore(TeamAScore, TeamBScore);

    }


    public void displayScore(int scoreA, int scoreB) {
        TextView scoreView = (TextView) findViewById(R.id.ScoreSummary);
        scoreView.setText(String.format("%s : %s", String.valueOf(scoreA), String.valueOf(scoreB)));
    }
}
