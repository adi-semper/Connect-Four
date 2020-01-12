package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.ConnectGame;

class ConnectGameTest {

    private ConnectGame game;

	@Before
	public void GameTest() {
	
	    game = new ConnectGame();
	
	}
	
	@Test
	public void getBoardTest() {

        assertNotNull( "game board is null", game.getBoard() );

	}
	
	@Test
	public void getPlayerOne() {
	
	    assertNotNull( "player one is null", game.getPlayer( 1 ) );
	
	}
	
	@Test
	public void getPlayerTwo() {
	
	    assertNotNull( "player two is null", game.getPlayer( 2 ) );
	
	}
	
	@Test
	public void resetTest() {
	
	    game.getPlayer( 1 ).won();
	    game.getBoard().addToBoard( 1, "X" );
	    game.getBoard().addToBoard( 6, "O" );
	    game.reset();
	    
	    assertEquals( "player1 did not reset", game.getPlayer( 1 ).getScore(),
	            0 );
	    assertEquals( "board did not clear", game.getBoard().getSymbol( 6, 1 ),
	            game.getBoard().getSymbol( 6, 6 ) );
	
	}

}
