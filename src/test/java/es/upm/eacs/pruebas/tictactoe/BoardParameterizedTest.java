package es.upm.eacs.pruebas.tictactoe;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import es.upm.eacs.pruebas.tictactoe.TicTacToeGame.Cell;

@RunWith(Parameterized.class)
public class BoardParameterizedTest {

	private Board board;
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] values = {
				{0,1,2,4,5,6, "X", "O"},
				{0,3,6,1,2,4, "X", "O"},
				{0,2,3,6,7,8, "X", "O"},
				{0,2,3,4,1,6, "X", "O"}
		};
		return Arrays.asList(values);
	}

	@Parameter(0) public int cell0;
	@Parameter(1) public int cell1;
	@Parameter(2) public int cell2;
	@Parameter(3) public int cell3;
	@Parameter(4) public int cell4;
	@Parameter(5) public int cell5;
	@Parameter(6) public String playerValueX;
	@Parameter(7) public String playerValueO;

	@Before
	public void setUp() {
		this.board = new Board();
	}

	@Test
	public void GIVEN__WHEN__THEN(){
		board.enableAll();

		board.getCell(cell0).value = playerValueX;
		board.getCell(cell3).value = playerValueO;
		board.getCell(cell1).value = playerValueX;
		board.getCell(cell4).value = playerValueO;
		board.getCell(cell2).value = playerValueX;
		board.getCell(cell5).value = playerValueO;

		int[] posX = board.getCellsIfWinner(playerValueX);
		int[] posO = board.getCellsIfWinner(playerValueO);

		if (posX !=null) {
			assertNotNull("Win X", posX);
		}
		else if (posO !=null ) {
			assertNotNull("Win Y", posO);
		}
		else {			
			for(int i = 0; i < 9; i++){
				if(i%2 == 0){
					board.getCell(i).value = playerValueX;
				}
				else{
					board.getCell(i).value = playerValueO;
				}
			}
			boolean isDraw = board.checkDraw();
			assertTrue(isDraw);
		}
	}
}