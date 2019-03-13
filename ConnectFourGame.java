import java.awt.Color;
import info.gridworld.grid.*;

public class ConnectFourGame
{
    private int[][] board;
    private int currentTurnNumber;
    
    public ConnectFourGame(int rows, int cols)
    {
        board = new int[rows][cols];
        // you need to fill board with 0's
        currentTurnNumber = 1;
    }

    // returns 0, 1, or 2
    public int getWinner()
    {      
        if (verticalWin()==1 || horizontalWin()==1 || diagonalRight()==1 || diagonalLeft()==1)
            return 1;
        else if (verticalWin()==2 || horizontalWin()==2 || diagonalRight()==2 || diagonalLeft()==2)
            return 2; 
        else
            return 0;
    }

    public int diagonalLeft()
    {
        int counter = 0;
        for (int c=0; c<board[0].length-3; c++)
        {
            for (int r=3; r<board.length; r++)
            {
                if (board[r][c]==1 && board[r-1][c+1]==1 && board[r-2][c+2]==1 && board[r-3][c+3]==1)
                {
                    counter = 1;
                }
                if (board[r][c]==2 && board[r-1][c+1]==2 && board[r-2][c+2]==2 && board[r-3][c+3]==2)
                {
                    counter = 2;
                }
            }
        }
        return counter;
    }
    
    public int diagonalRight()
    {
        int counter = 0;
        for (int c=0; c<board[0].length-3; c++)
        {
            for (int r=0; r<board.length-3; r++)
            {
                if (board[r][c]==1 && board[r+1][c+1]==1 && board[r+2][c+2]==1 && board[r+3][c+3]==1)
                {
                    counter = 1;
                }
                if (board[r][c]==2 && board[r+1][c+1]==2 && board[r+2][c+2]==2 && board[r+3][c+3]==2)
                {
                    counter = 2;
                }
            }
        }
        return counter;
    }
    
    public int verticalWin()
    {
        int counter = 0;
        for (int c=0; c<board[0].length; c++)
        {
            for (int r=0; r<board.length-3; r++)
            {
                if (board[r][c]==1 && board[r+1][c]==1 && board[r+2][c]==1 && board[r+3][c]==1)
                {
                    counter = 1;
                }
                if (board[r][c]==2 && board[r+1][c]==2 && board[r+2][c]==2 && board[r+3][c]==2)
                {
                    counter = 2;
                }
            }
        }
        return counter;
    }
    
    public int horizontalWin()
    {
        int counter = 0;
        for (int r=0; r<board.length; r++)
        {
            for (int c=0; c<board[0].length-3; c++)
            {
                if (board[r][c]==1 && board[r][c+1]==1 && board[r][c+2]==1 && board[r][c+3]==1)
                {
                    counter = 1;
                }
                if (board[r][c]==2 && board[r][c+1]==2 && board[r][c+2]==2 && board[r][c+3]==2)
                {
                    counter = 2;
                }
            }
        }
        return counter;
    }
    
    // updates the state of the game (board and currentTurnColor)
    // returns the row in which the checker would end up
    // returns -1 if the column col is completely full and no checker can be dropped
    public int dropChecker(int col)
    {
        for (int r=board.length-1; r>=0; r--)
        {
            if (board[r][col]==0)
            {
                board[r][col]=currentTurnNumber;
                if (currentTurnNumber==1)
                {
                    currentTurnNumber=2;
                }
                else
                {
                    currentTurnNumber=1;
                }
                return r;
            }
        }
        return -1;
    }
}













