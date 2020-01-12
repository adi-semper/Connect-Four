package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.ConnectPlayer;
import model.PlayerOne;
import model.PlayerTwo;

class ConnectPlayerTest {

    ConnectPlayer playerOne;
    PlayerTwo playerTwo;

    @Before
    void setup() {
    
    
        playerOne = new PlayerOne();
        playerTwo = new PlayerTwo();
    
    }
   
	@Test
	void getScoreTest() {
	
		assertEquals( "could not get score", playerOne.getScore(),
		        0 );
	}
	
	@Test
	void wonTest() {
	
	    playerOne.won();
	    assertEquals( "won does not increment score", playerOne.getScore(),
	            1 );
	
	}
	
	@Test
	void resetTest() {
	
	    playerOne.won();
	    playerOne.reset();
	    assertEquals( "won does not increment score", playerOne.getScore(),
	            0 );
	
	}
	
	@Test
	void getPlayerSymbol() {
	
		assertEquals( "could not get score", playerOne.getSymbol(),
		        "O" );
	}

	
}
