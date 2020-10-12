package TicTacToe;

import java.util.Scanner;

/**
 *
 * @author Mamona Ghaffar
 */

public class TicTacToe {
    int[][] board = new int[3][3];

    public void play() {
        System.out.println("Welcome to TicTacToe! Game");
        displayBoard();
        initializeBoard();
    }

    private void checkRowForWinner(int row) {
        int sum = board[row][0] + board[row][1] + board[row][2];
        if (sum == 3) {
            System.out.println("First Player WON!");
            System.exit(0);
        }
        if (sum == -3) {
            System.out.println("Second Player WON!");
            System.exit(0);
        }
    }
    private void checkColForWinner(int col) {
        int sum = board[0][col] + board[1][col] + board[2][col];
        if (sum == 3) {
            System.out.println("First Player WON!");
            System.exit(0);
        }
        if (sum == -3) {
            System.out.println("Second Player WON!");
            System.exit(0);
        }
    }

    private void checkDiagonal1ForWinner (int col, int row){
        int sum = board[0][0] + board [1][1] + board [2][2];
        if (sum == 3) {
            System.out.println("First Player WON!");
            System.exit(0);
        }
        if (sum == -3) {
            System.out.println("Second Player WON!");
            System.exit(0);
        }
    }

    private void checkDiagonal2ForWinner (int col, int row){
        int sum = board[2][0] + board [1][1] + board [0][2];
        if (sum == 3) {
            System.out.println("First Player WON!");
            System.exit(0);
        }
        if (sum == -3) {
            System.out.println("Second Player WON!");
            System.exit(0);
        }
    }
    private void initializeBoard() {
        Scanner scanner = new Scanner(System.in);
        boolean isPlayerOneTurn = true;
        boolean isPlayerTwoTurn = false;
        int turns = 9;
        while (turns > 0){
            if (isPlayerOneTurn){               // play
                
                System.out.println("Enter Row # First Player "
                        + "(X) => Between 1 to 3");
                int x = scanner.nextInt();      // should be 1 - 3
                System.out.println("Enter Column # First Player "
                        + "(X) => Between 1 to 3");
                int y = scanner.nextInt();      // should be 1 - 3

                while(x<1 || x>3 || y < 1 || y > 3 || this.board[x-1][y-1] != 0){
                    System.out.println("First Player (X)");
                    System.out.println("Enter Row # to play "
                            + "=> Between 1 to 3");
                    x = scanner.nextInt();      // should be 1 - 3
                    System.out.println("Enter Column # to play "
                            + "=> Between 1 to 3");
                    y = scanner.nextInt();      // should be 1 - 3
                }
                
                this.board[x-1][y-1] = 1;
                isPlayerOneTurn = false;
                isPlayerTwoTurn = true;
            }
            else {
                System.out.println("");
                System.out.println("Enter Row # Second Player (O) "
                        + "=> Between 1 to 3");
                int x = scanner.nextInt();      // should be 1 - 3
                System.out.println("Enter Column # Second Player (O)"
                        + " => Between 1 to 3");
                int y = scanner.nextInt();     // should be 1 - 3

                while(x<1 || x>3 || y < 1 || y > 3 || this.board[x-1][y-1] != 0){
                    System.out.println("Player 2 (O)");
                    System.out.println("Enter Row #  => Between 1 to 3");
                    x = scanner.nextInt();     // should be 1 - 3
                    System.out.println("Enter Column #  => Between 1 to 3");
                    y = scanner.nextInt();     // should be 1 - 3
                }

                this.board[x-1][y-1] = -1;
                isPlayerOneTurn = true;
                isPlayerTwoTurn = false;
            }
            
            displayBoard();
            
            checkRowForWinner(0);
            checkRowForWinner(1);
            checkRowForWinner(2);

            checkColForWinner(0);
            checkColForWinner(1);
            checkColForWinner(2);

            checkDiagonal1ForWinner(0, 0);
            checkDiagonal1ForWinner(1, 1);
            checkDiagonal1ForWinner(2, 2);
            checkDiagonal2ForWinner(2, 0);
            checkDiagonal2ForWinner(1, 1);
            checkDiagonal2ForWinner(0, 2);
            
            turns  = turns - 1;
        }
        System.out.println("GAME DRAW");
    }

    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int val = board[i][j];
                if (val == -1){
                    System.out.print(" O ");
                }else if(val == 1){
                    System.out.print(" X ");
                }else{
                    System.out.print("  ");
                }
                if (j < 2){
                    System.out.print("|");
                }
            }
            if (i <2){
                System.out.println();

            }else
                System.out.println();
        }
    }
}