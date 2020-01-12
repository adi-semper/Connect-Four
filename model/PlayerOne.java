package model;

public class PlayerOne extends ConnectPlayer {

    private final static String SYMBOL = "O";
    
    public PlayerOne() {
    
        super();
    
    }

    @Override
    public String getSymbol() {

        return SYMBOL;
    
    }

}
