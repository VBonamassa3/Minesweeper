import java.util.Scanner;
public class Main {
    // Main method to start the game
    public static void main(String[] args) {
        // Create a Minesweeper game with specific dimensions and number of mines
        Minesweeper game = new Minesweeper(10, 10, 10);
        Scanner input = new Scanner(System.in);

        // Game loop
        while (!game.getGameOver()) {
            game.displayBoard();
            // Get player input for row, col, and action (reveal or flag)
            System.out.println("Which row is the cell you want to take action on in?");
            int row = input.nextInt();
            System.out.println("Which column is the cell you want to take action on in?");
            int col = input.nextInt();
            System.out.println("Would you like to reveal or flag this spot? (type reveal or flag)");
            String action = input.next();
            //game.playerMove(4, 6, "reveal");

            if (row<0 || row>=10 || col<0 || col>=10 || action!="reveal" || action!="flag"){
                System.out.println("Invalid input, try again");
                //supposed to loop back to the beginning of the while loop
            }
            // Check for win or loss conditions
            if (game.checkWin()) {
                System.out.println("Congratulations! You've won the game.");
                break;
            }
            if (game.checkLoss(0, 0)) {
                System.out.println("Game Over! You hit a mine.");
                game.setGameOver(true);
            }
        }
    }
}