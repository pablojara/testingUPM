package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;

import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;

import static org.mockito.Mockito.argThat;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.CoreMatchers.hasItems;


public class TicTacToeGameTest {

	@Test
	public void addPlayer()
	{
		
		TicTacToeGame game = new TicTacToeGame();
		
		Connection connection1 = mock(Connection.class);
		Connection connection2 = mock(Connection.class);
		
		game.addConnection(connection1);
		game.addConnection(connection2);
		
		Player player0 = new Player(0, "X", "Pikachu");
		Player player1 = new Player(1, "O", "Charmander");
		
		game.addPlayer(player0);
		game.addPlayer(player1);
		
		List<Player> players = new CopyOnWriteArrayList<>();
		players.add(player0);
		players.add(player1);
		
		//verify(connection1).sendEvent(eq(EventType.JOIN_GAME), assertArrayEquals(players));
	
		
	}

	
	
	
}
