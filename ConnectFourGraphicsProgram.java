
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class ConnectFourGraphicsProgram extends GraphicsProgram
{
    private static final int PIECE_DIAM = 100;
    private static final int NUM_COLS = 7;
    private static final int NUM_ROWS = 6;
    public static final int APPLICATION_WIDTH = NUM_COLS * PIECE_DIAM;
    public static final int APPLICATION_HEIGHT = NUM_ROWS * PIECE_DIAM;

    /** Dimensions of game board in pixels (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;


    private ConnectFourGame game;
    private boolean gameIsBeingPlayed;
    private Color currentDrawingColor;

    
    public void run()
    {
        drawEverything();
        removeAll();
        currentDrawingColor = Color.RED;
        
        game = new ConnectFourGame(NUM_ROWS, NUM_COLS);
        gameIsBeingPlayed = true;
        addMouseListeners();
        while (game.getWinner()==0)
        {
        }
        gameIsBeingPlayed = false;
        if (game.getWinner()==1)
        {
            removeAll();
            GLabel redwin = new GLabel ("Red Wins", APPLICATION_WIDTH/2, APPLICATION_HEIGHT/2);
            redwin.setColor(Color.red);
            add(redwin);
            waitForClick();
            removeAll();
            drawEverything();
        }
        else if (game.getWinner()==2)
        {
            removeAll();
            GLabel blackwin = new GLabel ("Black Wins", APPLICATION_WIDTH/2, APPLICATION_HEIGHT/2);
            blackwin.setColor(Color.black);
            add(blackwin);
            waitForClick();
            removeAll();
            restartGame();
        }
        // add code here in version 0.4
    }

    public void restartGame()
    {
        run();
    }
    
    public void drawEverything()
    {
        GLabel startGame = new GLabel ("Do you want to play Connect Four?", APPLICATION_WIDTH/8, APPLICATION_HEIGHT/2 - 50);
        startGame.setFont("Times-Bold-24");
        GRect startBox = new GRect (APPLICATION_WIDTH/2 - 50, APPLICATION_HEIGHT/2, 100, 50);
        GLabel playButton = new GLabel ("Play", APPLICATION_WIDTH/2 - 30, 330);
        playButton.setFont("Times-Bold-30");
        add(startBox);
        add(startGame);
        add(playButton);
        waitForClick();
        
    }
    
    public void mouseClicked(MouseEvent event) 
    { 
        if (!gameIsBeingPlayed) return;
        int col = event.getX()/PIECE_DIAM;
        int row = game.dropChecker(col);
        if (row!=-1)
            drawChecker(col, row);
    }
    
    public void drawChecker(int col, int row)
    {
        GOval checker = new GOval (col*PIECE_DIAM, row*PIECE_DIAM, PIECE_DIAM, PIECE_DIAM);
        checker.setColor(currentDrawingColor);
        checker.setFilled(true);
        add(checker);
        if (currentDrawingColor.equals(Color.red))
            currentDrawingColor=Color.black;
        else
            currentDrawingColor=Color.red;
    }


}
