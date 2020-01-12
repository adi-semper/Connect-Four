package model;

public class ConnectGame {

    private ConnectBoard board;
    private ConnectPlayer playerOne;
    private ConnectPlayer playerTwo;
    
    private final static int ONE = 0;
    
    public ConnectGame() {
    
        board = new ConnectBoard();
        playerOne = new PlayerOne();
        playerTwo = new PlayerTwo();
    
    }
    
    public ConnectBoard getBoard() {
    
        return board;
    
    }
    
    public ConnectPlayer getPlayer ( int which ) {
    
        return which == ONE ? playerOne : playerTwo;
    
    }
    
    public void reset() {
    
        board.clearBoard();
        playerOne.reset();
        playerTwo.reset();
    
    }

}
