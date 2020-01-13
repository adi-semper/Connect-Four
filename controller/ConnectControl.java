package controller;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import model.ConnectGame;
import view.ConnectFrame;

public class ConnectControl {

    private static final int ONE = 0;
    private static final int TWO = 1;

    private ConnectGame game;
    private ConnectFrame frame;
    private JButton[][] boardBtns;
    private JButton[] inputBtns;
    private JSpinner player1Spin;
    private JSpinner player2Spin;
    private JButton startButton;
    private JButton restartButton;
    private JButton turnButton;
    private JLabel turnLabel;
    private Color[] colors;
    private Color player1Color;
    private Color player2Color;
    private Color currentColor;
    private String currentSymbol;
    private String wonHow;
    private int wonRow;
    private int wonCol;
    private int whoseTurn;
    
    private ConnectListener listener;

    public ConnectControl() {
    
        createComponents();
        setListeners();
        setColors();
        
        frame.setVisible( true );
    }
    
    public JSpinner getPlayer1Spinner() {
    
        return player1Spin;
    }
    
    public JSpinner getPlayer2Spinner() {
        
        return player2Spin;
    }
    
    public JButton getStartButton() {
    
        return startButton;
    }
   
    public void restartPressed() {
    
        frame.reset();
        startButton.setEnabled( true );
        player1Spin.setEnabled( true );
        player2Spin.setEnabled( true );
        game.getBoard().clearBoard();
    
    }
    
    public void startPressed() {
    
        startButton.setEnabled( false );
        for ( int i = 0; i < inputBtns.length; i++ ) {
            inputBtns[i].setEnabled( true );
        }
        player1Spin.setEnabled( false );
        player2Spin.setEnabled( false );
        player1Color = player1Spin.getEditor().getComponent(0).getBackground();
        player2Color = player2Spin.getEditor().getComponent(0).getBackground();
        
        activateTurnButton();
        
        nextTurn();
    
    }
    
	public void changePlayerColor( JSpinner spinner, int position ) {
    
        if ( spinner.equals( player1Spin ) ) {
        
            frame.setPlayerColor( ONE, colors[ position - 1 ] );
        } else {
        
            frame.setPlayerColor( TWO, colors[ position - 1 ] );
        }
    
    }
    
    public void inputBtnsPressed( JButton btn ) {
    
        int col = 0;
        for ( int i = 0; i < inputBtns.length; i++ ) {
            if ( btn.equals( inputBtns[i] ) ) {
            
                col = i;
            
            }
        }

        if ( whoseTurn % 2 == 1 ) {
        
            currentSymbol = game.getPlayer( ONE ).getSymbol();
            currentColor = player1Color;
        } else {
            currentSymbol = game.getPlayer( TWO ).getSymbol();
            currentColor = player2Color;
        
        }
        
        int row = game.getBoard().addToBoard( col, currentSymbol );
    
        boardBtns[row][col].setBackground( currentColor );
       
        if ( game.getBoard().hasWon( currentSymbol ) ) {
        
            gameOver();
	    whoseTurn++;
        
        } else if ( row == 0 ) { 
        
            btn.setEnabled( false );
            nextTurn();
        
        } else {
        
            nextTurn();
        
        }
        
        
    }
    
    public void buttonHover( JButton btn ) {

        btn.setBackground( currentColor );
    
    }
    
    private void gameOver() {
    
        for ( int i = 0; i < inputBtns.length; i++ ) {
            inputBtns[i].setEnabled( false );
        }
        
        turnLabel.setText( "Winner:" );
        wonHow = game.getBoard().getWonHow();
        wonRow = game.getBoard().getWonWhere()[0];
        wonCol = game.getBoard().getWonWhere()[1];
        
        highlightWinningSpot();
    
    }

    private void highlightWinningSpot() {
    
        Color lightBlue = new Color( 51, 236, 255 );
    
        if ( wonHow.equals( "horizontal" ) ) {
        
            for ( int col = 0; col < 4; col++ ) {
                boardBtns[wonRow][wonCol+col].setBorder( 
                        BorderFactory.createMatteBorder( 10, 10, 10, 10, lightBlue ) );
            }
        
        } else if ( wonHow.equals( "vertical" ) ) {
        
            for ( int row = 0; row < 4; row++ ) {
                boardBtns[wonRow+row][wonCol].setBorder( 
                        BorderFactory.createMatteBorder( 10, 10, 10, 10, lightBlue ) );
            }
        
        } else if ( wonHow.equals( "positive" ) ) {
        
            for ( int add = 0; add < 4; add++ ) {
                boardBtns[wonRow-add][wonCol+add].setBorder( 
                        BorderFactory.createMatteBorder( 10, 10, 10, 10, lightBlue ) );
            }
        
        } else {
        
            for ( int subtract = 0; subtract < 4; subtract++ ) {
                boardBtns[wonRow-subtract][wonCol-subtract].setBorder( 
                        BorderFactory.createMatteBorder( 10, 10, 10, 10, lightBlue ) );
            }
        
        }
    
    }

	private void activateTurnButton() {
    
    	turnLabel.setText( "Turn:");
        turnButton.setPreferredSize( new Dimension( 60, 60 ) );
        turnButton.setContentAreaFilled( true );
        turnButton.setBorderPainted( true );
    }
    
    private void nextTurn() {
    
        whoseTurn++;
        
        if ( whoseTurn % 2 == 1 ) {
        
            currentColor = player1Color;
        } else {
            currentColor = player2Color;
        
        }
        turnButton.setBackground( currentColor );
    
    }
    
    private void setColors() {
    
        colors[0] = Color.RED;
        colors[1] = new Color( 255, 128, 0 );
        colors[2] = Color.YELLOW;
        colors[3] = Color.GREEN;
        colors[4] = new Color( 153, 51, 255 );
        colors[5] = Color.PINK;
    }

	private void setListeners() {
    
        for ( int i = 0; i < inputBtns.length; i++ ) {
            inputBtns[i].addActionListener( listener );
            inputBtns[i].addMouseListener( listener );
        }
        startButton.addActionListener( listener );
        restartButton.addActionListener( listener );
        
        player1Spin.addChangeListener( listener );
        player2Spin.addChangeListener( listener );
    
    }

	private void createComponents() {

        game = new ConnectGame();
        frame = new ConnectFrame();
        boardBtns = frame.getBoardButtons();
        inputBtns = frame.getInputButtons();
        player1Spin = frame.getPlayer1Spinner( ONE );
        player2Spin = frame.getPlayer1Spinner( TWO );
        startButton = frame.getStartButton();
        restartButton = frame.getRestartButton();
        turnButton = frame.getTurnButton();
        turnLabel = frame.getTurnLabel();
        whoseTurn = 0;
        colors = new Color[6];
        
        listener = new ConnectListener( this );

    }
    
    
}
