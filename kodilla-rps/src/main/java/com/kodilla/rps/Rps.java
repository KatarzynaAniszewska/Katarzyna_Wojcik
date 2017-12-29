package com.kodilla.rps;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.lang.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.*;

public class Rps {


    int numberOfRounds;
    String playerName;
    Scanner sc = new Scanner(System.in);

//1 - rock, 2-paper, 3 - scissors
    //rock crushes scissors,scissors cuts paper, paper eats rock

    public void printResultWithNames(int player1number, int player2number) {
        String movesNames[]={"rock","paper","scissors"};
        if (player1number == 1 && player2number == 3) {
            System.out.println("Your move " +movesNames[player1number-1]);
            System.out.println("Computer move " +movesNames[player2number-1]);
            System.out.println("Rock crushes scissors");
        } else if (player1number == 3 && player2number == 2) {
            System.out.println("Your move " +movesNames[player1number-1]);
            System.out.println("Computer move " +movesNames[player2number-1]);
            System.out.println("Scissors cuts paper");
        } else if (player1number == 2 && player2number == 1) {
            System.out.println("Your move " +movesNames[player1number-1]);
            System.out.println("Computer move " +movesNames[player2number-1]);
            System.out.println("Paper eats rock");
        } else if (player1number == 1 && player2number == 1) {
            System.out.println("Your move " +movesNames[player1number-1]);
            System.out.println("Computer move " +movesNames[player2number-1]);
            System.out.println("Rock vs rock. It's a tie !");
        } else if (player1number == 2 && player2number == 2) {
            System.out.println("Your move " +movesNames[player1number-1]);
            System.out.println("Computer move " +movesNames[player2number-1]);
            System.out.println("Paper vs paper. It's a tie !");
        } else if (player1number == 3 && player2number == 3) {
            System.out.println("Your move " +movesNames[player1number-1]);
            System.out.println("Computer move " +movesNames[player2number-1]);
            System.out.println("Scissors vs scissors. It's a tie !");
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

    public void playTheGame() {
        int numberOfComputerWins = 0;
        int numberOfPlayerWins = 0;
        int numberOfPlayedRounds=1;

        while ( numberOfComputerWins <= numberOfRounds-1 && numberOfRounds-1 >= numberOfPlayerWins) {


                System.out.println("Please make Your move.");

                String playerInput = sc.next();
                int playerNumber = Integer.parseInt(playerInput);

                Random rand = new Random();
                int computerNumber = rand.nextInt(3) + 1;

                if ((playerNumber == 1 && computerNumber == 1) || (playerNumber == 2 && computerNumber == 2) ||
                        (playerNumber == 3 && computerNumber == 3)) {

                    System.out.println("Round "+numberOfPlayedRounds);
                    printResultWithNames(playerNumber,computerNumber);
                    System.out.println(playerName+" wins: "+numberOfPlayerWins);
                    System.out.println("Computer wins: "+numberOfComputerWins);
                    System.out.println(playerNumber+" "+computerNumber);
                }
                else if ((playerNumber == 1 && computerNumber == 2) || (playerNumber == 2 && computerNumber == 3) ||
                        (playerNumber == 3 && computerNumber == 1)) {



                    numberOfPlayerWins=numberOfPlayerWins+0;
                    numberOfComputerWins = numberOfComputerWins+1;
                    System.out.println("Round "+numberOfPlayedRounds);
                    printResultWithNames(computerNumber,playerNumber);
                    System.out.println(playerName+" wins: "+numberOfPlayerWins);
                    System.out.println("Computer wins: "+numberOfComputerWins);
                    System.out.println(playerNumber+" "+computerNumber);
                }
                else if ((playerNumber == 1 && computerNumber == 3) || (playerNumber == 2 && computerNumber == 1) ||
                        (playerNumber == 3 && computerNumber == 2)) {

                    numberOfPlayerWins = numberOfPlayerWins+1;
                    numberOfComputerWins=numberOfComputerWins+0;
                    System.out.println("Round "+numberOfPlayedRounds);
                    printResultWithNames(playerNumber,computerNumber);
                    System.out.println(playerName+" wins: "+numberOfPlayerWins);
                    System.out.println("Computer wins: "+numberOfComputerWins);
                    System.out.println(playerNumber+" "+computerNumber);
                }
            numberOfPlayedRounds = numberOfPlayedRounds + 1;
            }
        System.out.println("The game is over");
        if (numberOfComputerWins>numberOfPlayerWins){System.out.println("Sorry You've lost the game.");}
        else{System.out.println("Congratulations You've won the game !");}
        }
    }
