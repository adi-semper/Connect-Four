package model;

public abstract class ConnectPlayer {

    private int score;
    
    public ConnectPlayer() {
    
        score = 0;
    
    }
    
    public int getScore() {
    
        return score;
    
    }

    public void won() {
    
        score++;
    
    }
    
    public void reset() {
    
        score = 0;
    
    }
    
    public abstract String getSymbol();
    
}
