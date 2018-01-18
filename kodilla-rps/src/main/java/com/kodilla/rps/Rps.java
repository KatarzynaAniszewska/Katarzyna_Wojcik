package com.kodilla.rps;

import java.util.*;
import java.lang.*;


public class Rps {

    String playerInput;
    int computerNumber;
    int numberOfRounds;
    String playerName;
    Scanner sc = new Scanner(System.in);

//1 - rock, 2-paper, 3 - scissors
    //rock crushes scissors,scissors cuts paper, paper eats rock

    public void printResultWithNames() {
        if (playerInput.equals("1") && computerNumber == 3) {
            System.out.println("Your move rock");
            System.out.println("Computer move scissors");
            System.out.println("Rock crushes scissors, You've won the round !");
        } else if (playerInput.equals("3") && computerNumber == 2) {
            System.out.println("Your move scissors");
            System.out.println("Computer move paper");
            System.out.println("Scissors cuts paper, You've won the round !");
        } else if (playerInput.equals("2") && computerNumber == 1) {
            System.out.println("Your move paper");
            System.out.println("Computer move rock");
            System.out.println("Paper eats rock, You've won the round !");
        } else if (playerInput.equals("1") && computerNumber == 1) {
            System.out.println("Your move rock");
            System.out.println("Computer move rock");
            System.out.println("Rock vs rock. It's a tie !");
        } else if (playerInput.equals("2") && computerNumber == 2) {
            System.out.println("Your move paper");
            System.out.println("Computer move paper");
            System.out.println("Paper vs paper. It's a tie !");
        } else if (playerInput.equals("3") && computerNumber == 3) {
            System.out.println("Your move scissors");
            System.out.println("Computer move scissors");
            System.out.println("Scissors vs scissors. It's a tie !");
        } else if (playerInput.equals("1") && computerNumber == 2) {
            System.out.println("Your move rock");
            System.out.println("Computer move paper ");
            System.out.println("Paper eats rock, You've lost the round !");
        } else if (playerInput.equals("3") && computerNumber == 1) {
            System.out.println("Your move scissors");
            System.out.println("Computer move rock");
            System.out.println("Rock crushes scissors, You've lost the round !");
        } else if (playerInput.equals("2") && computerNumber == 3) {
            System.out.println("Your move paper");
            System.out.println("Computer move scissors");
            System.out.println("Scissors cuts paper, You've lost the round !");
        }
    }

    public void introduceTheGame() {
        boolean end = false;
        System.out.println("ROCK,PAPER,SCISSORS\nWelcome in the game ! \n What's Your name ?");
        playerName = sc.next();
        System.out.println("Nice to meet You " + playerName + ".");
        System.out.println("Please type how many rounds must be won to win The Game.\n You can select from 1 to 100 rounds.");
        while (!end) {
            numberOfRounds = Integer.parseInt(sc.next());
            if (numberOfRounds >= 0 && numberOfRounds <= 100) {
                System.out.println("Instruction");
                System.out.println(" key 1 - move \"rock\",\n key 2 - move \"paper\",\n key 3 - move \"scissors\",");
                System.out.println(" key x - end the game,\n key n - start new game.");

                end = true;
            } else {
                System.out.println("\"Please type how many rounds must be won to win The Game.\n Please type a number from 1 to 100");
            }
        }
    }

    public void playTheGame()
    {
        int numberOfComputerWins = 0;
        int numberOfPlayerWins = 0;
        int numberOfPlayedRounds = 1;
        boolean end = false;

        while (!end) {
            while ((numberOfComputerWins < numberOfRounds && numberOfRounds > numberOfPlayerWins)&&(!end)){
                System.out.println("Please make Your move.");
                playerInput = sc.next();
                Random rand = new Random();
                computerNumber = rand.nextInt(3) + 1;
                if ((playerInput.equals("1") && computerNumber == 1) || (playerInput.equals("2") && computerNumber == 2) ||
                        (playerInput.equals("3") && computerNumber == 3)) {
                    System.out.println("Round " + numberOfPlayedRounds);
                    printResultWithNames();
                    System.out.println(playerName + " wins: " + numberOfPlayerWins);
                    System.out.println("Computer wins: " + numberOfComputerWins);
                    numberOfPlayedRounds = numberOfPlayedRounds + 1;

                } else if ((playerInput.equals("1") && computerNumber == 2) || (playerInput.equals("2") && computerNumber == 3) ||
                        (playerInput.equals("3") && computerNumber == 1)) {
                    numberOfPlayerWins = numberOfPlayerWins + 0;
                    numberOfComputerWins = numberOfComputerWins + 1;
                    System.out.println("Round " + numberOfPlayedRounds);
                    printResultWithNames();
                    System.out.println(playerName + " wins: " + numberOfPlayerWins);
                    System.out.println("Computer wins: " + numberOfComputerWins);
                    numberOfPlayedRounds = numberOfPlayedRounds + 1;

                } else if ((playerInput.equals("1") && computerNumber == 3) || (playerInput.equals("2") && computerNumber == 1) ||
                        (playerInput.equals("3") && computerNumber == 2)) {
                    numberOfPlayerWins = numberOfPlayerWins + 1;
                    numberOfComputerWins = numberOfComputerWins + 0;
                    System.out.println("Round " + numberOfPlayedRounds);
                    printResultWithNames();
                    System.out.println(playerName + " wins: " + numberOfPlayerWins);
                    System.out.println("Computer wins: " + numberOfComputerWins);
                    numberOfPlayedRounds = numberOfPlayedRounds + 1;

                } else if (playerInput.equals("n") || playerInput.equals("N")) {
                    System.out.println("Would You like to start the new game ?");
                    System.out.println("For yes press \"y\", for no press \"n\".");
                    String startNewGame = sc.next();
                    {
                        if (startNewGame.equals("Y") || startNewGame.equals("y")) {
                            introduceTheGame();
                        }
                    }
                } else if (playerInput.equals("x") || playerInput.equals("X")) {
                    System.out.println("Would You like to quit the game ?");
                    System.out.println("For yes press \"y\", for no press \"n\".");
                    String quitGame = sc.next();
                    {
                        if (quitGame.equals("Y") || quitGame.equals("y")) {
                            System.out.println("Computer wins: " + numberOfComputerWins);
                            System.out.println(playerName + " " + numberOfPlayerWins);
                            end = true;
                        }
                    }
                }
            }
            if (numberOfComputerWins == numberOfRounds || numberOfRounds == numberOfPlayerWins) {
                if (numberOfComputerWins > numberOfPlayerWins) {
                    System.out.println("Sorry You've lost the game.");
                } else if (numberOfComputerWins < numberOfPlayerWins) {
                    System.out.println("Congratulations You've won the game !");
                }
                System.out.println("Would You like to start the new game ?");
                System.out.println("For yes press \"y\", for no press \"n\".");
                String newGameAfterEnd = sc.next();
                if (newGameAfterEnd.equals("Y") || newGameAfterEnd.equals("y")) {
                    introduceTheGame();
                } else end = true;
            }

        }
    }
}








