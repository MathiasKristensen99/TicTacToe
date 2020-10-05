/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import java.util.Arrays;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
    /**
     * @int rowsPlayed[row][column]
     * Describes the rows x columns played, with player number (0 or 1)
     */
    private int[][] rowsPlayed;
    private int currentPlayer;
    private int amtRowsPlayed;

    public GameBoard() {
        resetGame();
    }

    public void resetGame() {
        currentPlayer = 0;
        rowsPlayed = new int[3][3];
        for(int[] row : rowsPlayed) {
            Arrays.fill(row, -1);
        }
    }


    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        return (currentPlayer == 0 ? 0 : 1);
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        int v = rowsPlayed[row][col];
        if(v == -1) {
            rowsPlayed[row][col] = currentPlayer;

            System.out.println("Field " + row + "x" + col + " was played by Player #" + rowsPlayed[row][col]);

            if(currentPlayer == 0) { currentPlayer = 1; }
            else { currentPlayer = 0; }

            amtRowsPlayed++;

            return true;
        }
        else {
            return false;
        }
    }

    public boolean isGameOver()
    {
        /*
        Diagonal 1: 0x0, 1x1, 2x2
        Diagonal 2: 2x0, 1x1, 0x2
        Else:
        All of row 0, all of row 1, all of row 2
        All of col 0, all of col 1, all of col 2
         */

        if(amtRowsPlayed < 9) {
            return false;
        }
        else {
            System.out.println("game over");
            return true;
        }
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        //TODO Implement this method
        return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        //TODO Implement this method
    }

}
