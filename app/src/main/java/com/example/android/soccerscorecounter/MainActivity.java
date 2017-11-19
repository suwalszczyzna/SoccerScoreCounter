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
    String TeamA = "Your Team A";
    String TeamB = "Your Team B";

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
        displayTeams(TeamA,TeamB);
        displayCards(TeamAYellowCard,TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }

    public void goalA(View view) {
        TeamAScore += 1;
        displayScore(TeamAScore, TeamBScore);
    }

    public void goalB(View view) {
        TeamBScore += 1;
        displayScore(TeamAScore, TeamBScore);

    }

    public void yellowCardA(View view){
        TeamAYellowCard += 1;
        displayCards(TeamAYellowCard,TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }

    public void yellowCardB(View view){
        TeamBYellowCard += 1;
        displayCards(TeamAYellowCard,TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }

    public void redCardA(View view){
        TeamARedCard += 1;
        displayCards(TeamAYellowCard,TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }
    public void redCardB(View view){
        TeamBRedCard += 1;
        displayCards(TeamAYellowCard,TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }


    public void displayScore(int scoreA, int scoreB) {
        TextView scoreView = (TextView) findViewById(R.id.ScoreSummary);
        scoreView.setText(String.format("%s : %s", String.valueOf(scoreA), String.valueOf(scoreB)));
    }

    public void displayTeams(String teamA, String teamB) {
        TextView team_A = (TextView) findViewById(R.id.TeamA);
        team_A.setText(teamA);
        TextView team_B = (TextView) findViewById(R.id.TeamB);
        team_B.setText(teamB);
    }

    public void displayCards(int yellowCardA, int yellowCardB, int redCardA, int redCardB) {
        TextView yelCardA = (TextView) findViewById(R.id.teamAYellowCardCounter);
        yelCardA.setText(String.valueOf(yellowCardA));

        TextView yelCardB = (TextView) findViewById(R.id.teamBYellowCardCounter);
        yelCardB.setText(String.valueOf(yellowCardB));

        TextView reCardA = (TextView) findViewById(R.id.teamARedCardCounter);
        reCardA.setText(String.valueOf(redCardA));

        TextView reCardB = (TextView) findViewById(R.id.teamBRedCardCounter);
        reCardB.setText(String.valueOf(redCardB));
    }

    public void resetButton(View view){
        TeamAScore = 0;
        TeamBScore = 0;
        TeamAYellowCard = 0;
        TeamARedCard = 0;
        TeamBYellowCard = 0;
        TeamBRedCard = 0;
        displayScore(TeamAScore,TeamBScore);
        displayCards(TeamAYellowCard,TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }
}
