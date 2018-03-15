package com.example.barath.cricketscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamscoreA = 0;
    int teamscoreB = 0;
    int teamwktA = 0;
    int teamwktB = 0;
    int overA = 0;
    int ballA = 0;
    int overB = 0;
    int ballB = 0;
    int res = 0;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Handling the screen rotation
    @Override
    protected void onSaveInstanceState(Bundle outState) { //Save all variables to outState
        super.onSaveInstanceState(outState);
        outState.putInt("team_a_score", teamscoreA);
        outState.putInt("team_b_score", teamscoreB);
        outState.putInt("team_a_wkt", teamwktA);
        outState.putInt("team_b_wkt", teamwktB);
        outState.putInt("team_a_over", overA);
        outState.putInt("team_b_over", overB);
        outState.putInt("team_a_ball", ballA);
        outState.putInt("team_b_ball", ballB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) { //Restore all variables
        super.onRestoreInstanceState(savedInstanceState);
        teamscoreA = savedInstanceState.getInt("team_a_score");
        teamscoreB = savedInstanceState.getInt("team_b_score");
        teamwktA = savedInstanceState.getInt("team_a_wkt");
        teamwktB = savedInstanceState.getInt("team_b_wkt");
        overA = savedInstanceState.getInt("team_a_over");
        overB = savedInstanceState.getInt("team_b_over");
        ballA = savedInstanceState.getInt("team_a_ball");
        ballB = savedInstanceState.getInt("team_b_ball");
        updateDisplay(); //Update display once variables are restored
    }

    private void updateDisplay() {
        displayForTeamA(teamscoreA);
        displayForTeamB(teamscoreB);
        displayWktTeamA(teamwktA);
        displayWktTeamB(teamwktB);
        displayOverTeamA(overA, ballA);
        displayOverTeamB(overB, ballB);
    }

    /**
     * Displays the score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void plusSixA(View view) {
        teamscoreA += 6;
        displayForTeamA(teamscoreA);
        overballA();
    }

    public void plusFourA(View view) {
        teamscoreA += 4;
        displayForTeamA(teamscoreA);
        overballA();
    }

    public void plusThreeA(View view) {
        teamscoreA += 3;
        displayForTeamA(teamscoreA);
        overballA();
    }

    public void plusTwoA(View view) {
        teamscoreA += 2;
        displayForTeamA(teamscoreA);
        overballA();
    }

    public void plusOneA(View view) {
        teamscoreA += 1;
        displayForTeamA(teamscoreA);
        overballA();
    }

    public void plusWideA(View view) {
        teamscoreA += 1;
        displayForTeamA(teamscoreA);
    }

    public void displayWktTeamA(int wkt) {
        TextView wktView = findViewById(R.id.team_a_wkt);
        wktView.setText(String.valueOf(wkt));
    }

    public void wktA(View view) {

        if (teamwktA < 10) {
            teamwktA += 1;
            displayWktTeamA(teamwktA);
            overballA();
        }
        if (teamwktA == 10) {
            if (overA != 2) {
                changeA(1);
            }
        }
    }

    public void dot_ballA(View view) {
        overballA();
    }

    /*
     * Displays the over for Team A
     */
    public void displayOverTeamA(int over, int ball) {
        TextView overView = findViewById(R.id.team_a_over);
        TextView ballView = findViewById(R.id.team_a_ball);
        overView.setText(String.valueOf(over));
        ballView.setText(String.valueOf(ball));
    }

    public void overballA() {
        if (ballA < 5) {
            ballA += 1;
        } else {
            overA += 1;
            ballA = 0;
        }
        displayOverTeamA(overA, ballA);
        if (overA == 2) {
            changeA(1);
        }
    }

    /**
     * Displays the score for Team B
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void plusSixB(View view) {
        teamscoreB += 6;
        displayForTeamB(teamscoreB);
        overballB();
    }

    public void plusFourB(View view) {
        teamscoreB += 4;
        displayForTeamB(teamscoreB);
        overballB();
    }

    public void plusThreeB(View view) {
        teamscoreB += 3;
        displayForTeamB(teamscoreB);
        overballB();
    }

    public void plusTwoB(View view) {
        teamscoreB += 2;
        displayForTeamB(teamscoreB);
        overballB();
    }

    public void plusOneB(View view) {
        teamscoreB += 1;
        displayForTeamB(teamscoreB);
        overballB();
    }

    public void plusWideB(View view) {
        teamscoreB += 1;
        displayForTeamB(teamscoreB);
    }

    public void displayWktTeamB(int wkt) {
        TextView wktView = findViewById(R.id.team_b_wkt);
        wktView.setText(String.valueOf(wkt));
    }

    public void wktB(View view) {
        if (teamwktB < 10) {
            teamwktB += 1;
            displayWktTeamB(teamwktB);
            overballB();
        }
        if (teamwktB == 10) {
            if (overB != 2) {
                changeB(1);
            }
        }
    }

    public void dot_ballB(View view) {
        overballB();
    }

    /*
     * Displays the over for Team B
     */
    public void displayOverTeamB(int over, int ball) {
        TextView overView = findViewById(R.id.team_b_over);
        TextView ballView = findViewById(R.id.team_b_ball);
        overView.setText(String.valueOf(over));
        ballView.setText(String.valueOf(ball));
    }

    public void overballB() {
        if (ballB < 5) {
            ballB += 1;
        } else {
            overB += 1;
            ballB = 0;
        }
        displayOverTeamB(overB, ballB);
        if (overB == 2 || teamscoreA < teamscoreB) {
            changeB(1);
        }
    }

    /*
    *To change the layout after team A is all out and back to normal when reset
     */
    public void changeA(int temp) {
        LinearLayout butsA = findViewById(R.id.team_a_buts);

        if (temp == 1) {
            butsA.setVisibility(View.GONE);
            res += 1;
            displayResult(res);
        } else if (temp == 0) {
            butsA.setVisibility(View.VISIBLE);
        }
    }

    /*
    *To change the layout after team B is all out and back to normal when reset
     */
    public void changeB(int temp) {
        LinearLayout butsB = findViewById(R.id.team_b_buts);

        if (temp == 1) {
            butsB.setVisibility(View.GONE);
            res += 1;
            displayResult(res);
        } else if (temp == 0) {
            butsB.setVisibility(View.VISIBLE);
        }
    }

    public void displayResult(int reslt) {
        TextView result = findViewById(R.id.result);
        if (reslt >= 2) {
            setResult();
            result.setVisibility(View.VISIBLE);

        } else if (reslt == 0) {
            result.setVisibility(View.GONE);

        }
    }

    private void setResult() {
        if (teamscoreA > teamscoreB) {
            int temp = teamscoreA - teamscoreB;
            result = "Team A has won by " + temp + " Run(s).";
        } else if (teamscoreB > teamscoreA) {
            int temp = 10 - teamwktB;
            result = "Team B has won by " + temp + " Wicket(s)";
        } else {
            result = "Its a Draw";
        }
        TextView resText = findViewById(R.id.result);
        resText.setText(result);
    }

    /**
     * Reset
     **/
    public void reset(View view) {
        teamscoreA = 0;
        teamscoreB = 0;
        teamwktA = 0;
        teamwktB = 0;
        overA = 0;
        ballA = 0;
        overB = 0;
        ballB = 0;
        res = 0;
        displayForTeamA(teamscoreA);
        displayForTeamB(teamscoreB);
        displayOverTeamA(overA, ballA);
        displayOverTeamB(overB, ballB);
        displayWktTeamA(teamwktA);
        displayWktTeamB(teamwktB);
        changeA(0);
        changeB(0);
        displayResult(res);
    }
}