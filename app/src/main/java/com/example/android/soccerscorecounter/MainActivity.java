package com.example.android.soccerscorecounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Dialog.DialogListener {

    int TeamAScore = 0;
    int TeamBScore = 0;
    int TeamAYellowCard = 0;
    int TeamARedCard = 0;
    int TeamBYellowCard = 0;
    int TeamBRedCard = 0;
    String TeamA = "Your Team A";
    String TeamB = "Your Team B";

    TextView textViewTeamA, textViewTeamB;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textv = findViewById(R.id.ScoreSummary);
        textv.setShadowLayer(50, 10, 10, Color.rgb(7, 115, 108));

        textViewTeamA = findViewById(R.id.TeamA);
        textViewTeamA.setShadowLayer(10, 3, 2, Color.rgb(7, 93, 87));

        textViewTeamB = findViewById(R.id.TeamB);
        textViewTeamB.setShadowLayer(10, 3, 2, Color.rgb(7, 93, 87));

        TextView textv3 = findViewById(R.id.TeamA_label);
        textv3.setShadowLayer(15, 3, 2, Color.rgb(7, 93, 87));

        TextView textv4 = findViewById(R.id.TeamB_label);
        textv4.setShadowLayer(15, 3, 2, Color.rgb(7, 93, 87));

        button = findViewById(R.id.change_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });


        openDialog();

        displayScore(TeamAScore, TeamBScore);
        displayTeams(TeamA, TeamB);
        displayCards(TeamAYellowCard, TeamBYellowCard, TeamARedCard, TeamBRedCard);


    }


    public void openDialog() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void applyTexts(String teamA, String teamB) {
        textViewTeamA.setText(teamA);
        textViewTeamB.setText(teamB);
    }

    public void goalA(View view) {
        TeamAScore += 1;
        displayScore(TeamAScore, TeamBScore);
    }

    public void goalB(View view) {
        TeamBScore += 1;
        displayScore(TeamAScore, TeamBScore);

    }

    public void yellowCardA(View view) {
        TeamAYellowCard += 1;
        displayCards(TeamAYellowCard, TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }

    public void yellowCardB(View view) {
        TeamBYellowCard += 1;
        displayCards(TeamAYellowCard, TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }

    public void redCardA(View view) {
        TeamARedCard += 1;
        displayCards(TeamAYellowCard, TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }

    public void redCardB(View view) {
        TeamBRedCard += 1;
        displayCards(TeamAYellowCard, TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }


    public void displayScore(int scoreA, int scoreB) {
        TextView scoreView = findViewById(R.id.ScoreSummary);
        scoreView.setText(String.format("%s : %s", String.valueOf(scoreA), String.valueOf(scoreB)));
    }

    public void displayTeams(String teamA, String teamB) {
        TextView team_A = findViewById(R.id.TeamA);
        team_A.setText(teamA);
        TextView team_B = findViewById(R.id.TeamB);
        team_B.setText(teamB);
    }

    public void displayCards(int yellowCardA, int yellowCardB, int redCardA, int redCardB) {
        TextView yelCardA = findViewById(R.id.teamAYellowCardCounter);
        yelCardA.setText(String.valueOf(yellowCardA));

        TextView yelCardB = findViewById(R.id.teamBYellowCardCounter);
        yelCardB.setText(String.valueOf(yellowCardB));

        TextView reCardA = findViewById(R.id.teamARedCardCounter);
        reCardA.setText(String.valueOf(redCardA));

        TextView reCardB = findViewById(R.id.teamBRedCardCounter);
        reCardB.setText(String.valueOf(redCardB));
    }

    public void resetButton(View view) {
        TeamAScore = 0;
        TeamBScore = 0;
        TeamAYellowCard = 0;
        TeamARedCard = 0;
        TeamBYellowCard = 0;
        TeamBRedCard = 0;
        displayScore(TeamAScore, TeamBScore);
        displayCards(TeamAYellowCard, TeamBYellowCard, TeamARedCard, TeamBRedCard);
    }
}
