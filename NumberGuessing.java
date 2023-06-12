// Task-2 (Oasis Infobyte)
// the number guessing system

import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGuessing {
    public static void main(String[] args) {
        int totalAttempts = 0;
        int totalWins = 0;
        int totalLosses = 0;

        do{
            int numAttempts = 0;
            int maxAttempts = 10;
            Random rand = new Random();
            int secretNumber = rand.nextInt(100) + 1;

            //Welcome Message
            JOptionPane.showMessageDialog(null,"\t\tWelcome to the Game\nGuess the Number Game!\n\nNote: You have to enter number between 1 to 100.");

            while (numAttempts < maxAttempts){
                String guessString = JOptionPane.showInputDialog(null, "Enter a number between 1 to 100: ");
                int guess = Integer.parseInt(guessString);

                if(guess < 1 || guess > 100){
                    JOptionPane.showMessageDialog(null,"Invalid Input!!Please enter number between 1 to 100");
                    continue;
                }

                //If Win
                if(guess == secretNumber){
                    JOptionPane.showMessageDialog(null, "Hurray!!Congratulations!You have guessed the number in " + (numAttempts + 1) + "attempts.");
                    totalAttempts += (numAttempts + 1);
                    totalWins++;
                    break;
                }
                else if(guess < secretNumber){
                    JOptionPane.showMessageDialog(null,"Too Low!!Try again.");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Too High!!Try again.");
                }
                numAttempts++;

            }

            //If Loss
            if(numAttempts == maxAttempts){
                JOptionPane.showMessageDialog(null, "Oops!!Game Over!You have used all " +maxAttempts+
                        "attempts.The secret number was " +secretNumber+ ".");
                totalAttempts += maxAttempts;
                totalLosses++;
            }

            //Next Game
            int playAgain = JOptionPane.showConfirmDialog(null,"Would you like to play again?");
            if(playAgain == JOptionPane.NO_OPTION){
                break;
            }
        }
        while(true);

        //score card
        int totalGames = totalWins + totalLosses;
        double avgAttempts = (int) ((double) totalAttempts / totalGames);
        int score = 12 - (int) avgAttempts;
        JOptionPane.showMessageDialog(null,"Here's your Score Card\nTotal games played: " +totalGames+ 
                "\nTotal Wins: " +totalWins+ "\nTotal Losses: " +totalLosses+ "\nAverage Attempts: " +avgAttempts+ 
                "\nScore: " +score);
        }
}