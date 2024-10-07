package ticTacToe;

import java.util.Scanner;
public class TicTacToe {

	//public class TicTacToe {
	    private char[][] board;
	    private char currentPlayer;

	    // Constructor to initialize the board and set the current player
	    public TicTacToe() {
	        board = new char[3][3];
	        currentPlayer = 'X';
	        initializeBoard();
	    }

	    // Initialize the board with dashes (empty slots)
	    public void initializeBoard() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = '-';
	            }
	        }
	    }

	    // Print the current board state
	    public void printBoard() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    // Place a mark on the board at the specified position
	    public boolean placeMark(int row, int col) {
	        if (row > 0 && col > 0 && row <=3 && col <=3) {
	            if (board[row-1][col-1] == '-') {
	                board[row-1][col-1] = currentPlayer;
	                return true;
	            }
	        }
	        return false;
	    }

	    // Change the current player from X to O or O to X
	    public void changePlayer() {
	        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	    }

	    // Check if the current player has won the game
	    public boolean checkForWin() {
	        return (checkRows() || checkColumns() || checkDiagonals());
	    }
	    public boolean checkForDraw() {
	    	for(int i=0;i<3;i++) {
	    		for(int j=0;j<3;j++) {
	    			if(board[i][j]=='-')
	    				return false;
	    		}
	    	}
	    	return true;
	    }
	    // Check if any row has all the same mark
	    private boolean checkRows() {
	        for (int i = 0; i < 3; i++) {
	            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
	                return true;
	            }
	        }
	        return false;
	    }

	    // Check if any column has all the same mark
	    private boolean checkColumns() {
	        for (int i = 0; i < 3; i++) {
	            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
	                return true;
	            }
	        }
	        return false;
	    }

	    // Check if either diagonal has all the same mark
	    private boolean checkDiagonals() {
	        return ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
	                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer));
	    }

	    // Main method to run the game
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        boolean playAgain;
	        do {
	        TicTacToe game = new TicTacToe();
	        game.printBoard();
	        
	        boolean gameWon = false;
	        boolean gameDraw=false;
	        while (!gameWon && !gameDraw) {
	            System.out.println("Player " + game.currentPlayer + ", enter your move (row and column): ");
	            int row = scanner.nextInt();
	            int col = scanner.nextInt();
	            
	            if (game.placeMark(row, col)) {
	                game.printBoard();
	                if (game.checkForWin()) {
	                    System.out.println("Player " + game.currentPlayer + " wins!");
	                    gameWon = true;
	                
	                }
	                else if(game.checkForDraw()) {
	                	System.out.println("The Game is Drawn");
	                	gameDraw=true;
	                }
	                else {
	                    game.changePlayer();
	                }
	            } else {
	                System.out.println("This move is not valid. Try again.");
	            }
	        }
	        System.out.println("Do You Want To Play Again ");
	        String response=scanner.next();
	        playAgain=response.equalsIgnoreCase("yes");
	      
	        }while(playAgain);
	        scanner.close();
	    }
	}
