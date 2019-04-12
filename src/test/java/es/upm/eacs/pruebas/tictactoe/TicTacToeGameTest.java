package es.upm.eacs.pruebas.tictactoe;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;

import es.upm.eacs.pruebas.tictactoe.TicTacToeGame.EventType;
import es.upm.eacs.pruebas.tictactoe.TicTacToeGame.WinnerValue;

import static org.mockito.Mockito.argThat;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.CoreMatchers.hasItems;
import org.hamcrest.core.*;

public class TicTacToeGameTest {

	@Test
	public void addPlayers()
	{
		ArgumentCaptor<List<Player>> argumentCaptor = ArgumentCaptor.forClass(List.class);
		
		List<Player> list =  new CopyOnWriteArrayList<>();
		
		Player player0 = new Player(0, "X", "Pikachu");
		Player player1 = new Player(1, "O", "Charmander");
		
		list.add(player0);
		
		TicTacToeGame game = new TicTacToeGame();

		Connection connection1 = mock(Connection.class);
		Connection connection2 = mock(Connection.class);

		game.addConnection(connection1);
		game.addConnection(connection2);

		reset(connection1);
		reset(connection2);

		game.addPlayer(player0);
		
		verify(connection1, times(1)).sendEvent(eq(EventType.JOIN_GAME), argumentCaptor.capture());
		verify(connection2, times(1)).sendEvent(eq(EventType.JOIN_GAME), argumentCaptor.capture());
		
		List<Player> values = argumentCaptor.getValue();
		assertEquals(values, list);
		
		reset(connection1);
		reset(connection2);
		
		game.addPlayer(player1);

		list.add(player1);

		verify(connection1, times(1)).sendEvent(eq(EventType.JOIN_GAME), argumentCaptor.capture());
		verify(connection2, times(1)).sendEvent(eq(EventType.JOIN_GAME), argumentCaptor.capture());

		values = argumentCaptor.getValue();
		assertEquals(values, list);
		
		reset(connection1);
		
		game.mark(0);		
		game.mark(1);
		game.mark(2);
		game.mark(3);
		game.mark(4);
		game.mark(5);
		game.mark(6);
		
		
		verify(connection1, times(6)).sendEvent(eq(EventType.SET_TURN), argumentCaptor.capture());

		
		
	}
		
}
