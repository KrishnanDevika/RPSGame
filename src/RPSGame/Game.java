package RPSGame;


import Panes.ResultPane;
import Panes.ScorePane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Game {
        /*
        0 -> Rock
        1 -> Paper
        2 -> Scissor
        3 -> Hunter
        4 -> Bird
        5 -> Water
    */

    public static int computer;
    public static int user;
    public static int userScore = 0;
    public static int computerScore = 0;
    public static String player1;
    public static String player2;


    public Game() {

        switch (computer) {

            case 0:
                ResultPane.computerChosenText.setText("Rock");
                if (user == 0) {
                    ResultPane.resultDialogue.setText("Both Choose Rock. It is Draw");
                } else if (user == 1) {
                    ResultPane.resultDialogue.setText(player1 + " is Paper, " + player2 + " is Rock. " + player1 + " Win. Paper Covers Rock");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 2) {
                    ResultPane.resultDialogue.setText(player1 + " is Scissor, " + player2 + " is Rock. " + player1 + " Lost. Rock Smashes Scissor");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else if (user == 3) {
                    ResultPane.resultDialogue.setText(player1 + " is Hunter, " + player2 + " is Rock. " + player1 + " Lost. Rock Beats Hunter");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else if (user == 4) {
                    ResultPane.resultDialogue.setText(player1 + " is Bird, " + player2 + " is Rock. " + player1 + " Lost. Rock Beats Bird");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else {
                    ResultPane.resultDialogue.setText(player1 + " is Water, " + player2 + " is Rock. " + player1 + " Win. Water Erodes rock");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                }

                break;
            case 1:
                ResultPane.computerChosenText.setText("Paper");
                if (user == 0) {
                    ResultPane.resultDialogue.setText(player1 + " is Rock, " + player2 + " is Paper. " + player1 + " Lost. Paper Covers Rock");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else if (user == 1) {
                    ResultPane.resultDialogue.setText("Both are Paper. It is Draw");
                } else if (user == 2) {
                    ResultPane.resultDialogue.setText(player1 + " is Scissor, " + player2 + " is Paper. " + player1 + " Win. Scissor Cuts Paper");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 3) {
                    ResultPane.resultDialogue.setText(player1 + " is Hunter, " + player2 + " is Paper. " + player1 + " Win. Hunter Tear Paper");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 4) {
                    ResultPane.resultDialogue.setText(player1 + " is Bird, " + player2 + " is Paper. " + player1 + " Win. Bird Tear Paper");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else {
                    ResultPane.resultDialogue.setText(player1 + " is Water, " + player2 + " is Paper. " + player1 + " Lost. Paper Floats on Water");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                }

                break;
            case 2:
                ResultPane.computerChosenText.setText("Scissor");
                if (user == 0) {
                    ResultPane.resultDialogue.setText(player1 + " is Rock, " + player2 + " is Scissor. " + player1 + " Win. Rock Smashes Scissor");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 1) {
                    ResultPane.resultDialogue.setText(player1 + " is Paper, " + player2 + " is Scissor. " + player1 + " Lost. Scissor Cuts Paper");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else if (user == 2) {
                    ResultPane.resultDialogue.setText("Both are Scissor. It is Draw");
                } else if (user == 3) {
                    ResultPane.resultDialogue.setText(player1 + " is Hunter, " + player2 + " is Scissor. " + player1 + " Lost. Scissor Cuts Hunter");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else if (user == 4) {
                    ResultPane.resultDialogue.setText(player1 + " is Bird, " + player2 + " is Scissor. " + player1 + " Lost. Scissor Cuts Bird");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else {
                    ResultPane.resultDialogue.setText(player1 + " is Water, " + player2 + " is Scissor. " + player1 + " Win. Water Rusts Scissor ");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                }

                break;
            case 3:
                ResultPane.computerChosenText.setText("Hunter");
                if (user == 0) {
                    ResultPane.resultDialogue.setText(player1 + " is Rock, " + player2 + " is Hunter. " + player1 + " Win. Rock Beats Hunter");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 1) {
                    ResultPane.resultDialogue.setText(player1 + " is Paper, " + player2 + " is Hunter. " + player1 + " Lost. Hunter tear Paper");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else if (user == 2) {
                    ResultPane.resultDialogue.setText(player1 + " is Scissor, " + player2 + " is Hunter. " + player1 + " Win. Scissor Cuts Hunter");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 3) {
                    ResultPane.resultDialogue.setText("Both are Hunter. It is Draw");
                } else if (user == 4) {
                    ResultPane.resultDialogue.setText(player1 + " is Bird, " + player2 + " is Hunter. " + player1 + " Lost. Hunter Shoots Bird");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else {
                    ResultPane.resultDialogue.setText(player1 + " is Water, " + player2 + " is Hunter. " + player1 + " Lost. Hunter Drinks Water");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                }

                break;
            case 4:
                ResultPane.computerChosenText.setText("Bird");
                if (user == 0) {
                    ResultPane.resultDialogue.setText(player1 + " is Rock, " + player2 + " is Bird. " + player1 + " Win. Rock Beats Bird");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 1) {
                    ResultPane.resultDialogue.setText(player1 + " is Paper, " + player2 + " is Bird. " + player1 + " Lost. Bird Tear Paper");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else if (user == 2) {
                    ResultPane.resultDialogue.setText(player1 + " is Scissor, " + player2 + " is Bird. " + player1 + " Win. Scissor Cuts Bird");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 3) {
                    ResultPane.resultDialogue.setText(player1 + " is Hunter, " + player2 + " is Bird. " + player1 + " Win. Hunter Shoots Bird");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 4) {
                    ResultPane.resultDialogue.setText("Both are Bird. It is Draw");
                } else {
                    ResultPane.resultDialogue.setText(player1 + " is Water, " + player2 + " is Bird. " + player1 + " Lost. Bird Drinks Water");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                }

                break;
            case 5:
                ResultPane.computerChosenText.setText("Water");
                if (user == 0) {
                    ResultPane.resultDialogue.setText(player1 + " is Rock, " + player2 + " is Water. " + player1 + " Lost. Water Erodes Rock");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else if (user == 1) {
                    ResultPane.resultDialogue.setText(player1 + " is Paper, " + player2 + " is Water. " + player1 + " Win. Paper Floats On Water");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 2) {
                    ResultPane.resultDialogue.setText(player1 + " is Scissor, " + player2 + " is Water. " + player1 + " Lost. Water Rusts Scissor");
                    computerScore++;
                    ScorePane.computerScore.setText(Integer.toString(computerScore));
                } else if (user == 3) {
                    ResultPane.resultDialogue.setText(player1 + " is Hunter, " + player2 + " is Water. " + player1 + " Win. Hunter Drinks Water");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else if (user == 4) {
                    ResultPane.resultDialogue.setText(player1 + " is Bird, " + player2 + " is Water. " + player1 + " Win. Bird Drinks Water");
                    userScore++;
                    ScorePane.playerScore.setText(Integer.toString(userScore));
                } else {
                    ResultPane.resultDialogue.setText("Both are Water. It is Draw");
                }

                break;

        }
    }
}
