package tictactoe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    public static void main(String[] args) {
        boolean playNewGame, isInputInvalid, isPlayingGame;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher;
        Logic logic = new Logic();
        int size = -1, row = -1, col = -1;
        Scanner scanner = new Scanner(System.in);
        
        playNewGame = true;
        
        while (playNewGame) {
            isInputInvalid = true;
            
            while (isInputInvalid) {
                System.out.print("Choose a board size: ");
                matcher = pattern.matcher(scanner.nextLine());
                
                if (matcher.find()) {
                    size = Integer.parseInt(matcher.group());
                }
                
                System.out.println();
                isInputInvalid = !logic.resetBoard(size);
                
                if (isInputInvalid) {
                    System.out.println("Invalid input.");
                }
            }
            
            isPlayingGame = true;
            
            while (isPlayingGame) {
                logic.displayBoard();
                isInputInvalid = true;
                
                while (isInputInvalid) {
                    System.out.print("Where do you want to mark? (x, y): ");
                    matcher = pattern.matcher(scanner.nextLine());
                    
                    if (matcher.find()) {
                        col = Integer.parseInt(matcher.group()) - 1;
                    }
                    
                    if (matcher.find()) {
                        row = size - Integer.parseInt(matcher.group());
                    }
                    
                    System.out.println();
                    isInputInvalid = !logic.markSquare(row, col);
                    
                    if (isInputInvalid) {
                        System.out.println("Invalid input.");
                    }
                }
                
                logic.switchPlayer();
            }
        }
        
        scanner.close();
    }
}
