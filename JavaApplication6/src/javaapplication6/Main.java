package javaapplication6;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize variables
        String[] choices = {"rock", "paper", "scissors"};
        int playerScore = 0;
        int computerScore = 0;
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        while (playerScore < 3 && computerScore < 3) {
            // Get player's choice
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String player = scanner.next();
            
            // Validate player's choice
            boolean validChoice = false;
            for (String choice : choices) {
                if (choice.equals(player)) {
                    validChoice = true;
                    break;
                }
            }
            
            if (!validChoice) {
                System.out.println("Invalid choice");
                continue;
            }
            
            // Generate computer's choice
            int index = random.nextInt(choices.length);
            String computer = choices[index];
            
            // Determine the winner
            if (player.equals(computer)) {
                System.out.println("It's a tie");
            } else if ((player.equals("rock") && computer.equals("scissors"))
                    || (player.equals("paper") && computer.equals("rock"))
                    || (player.equals("scissors") && computer.equals("paper"))) {
                System.out.println("Player wins");
                playerScore++;
            } else {
                System.out.println("Computer wins");
                computerScore++;
            }
        }
        
        // Determine the overall winner
        if (playerScore > computerScore) {
            System.out.println("Player wins the game");
        } else {
            System.out.println("Computer wins the game");
        }
        
        scanner.close();
    }
}