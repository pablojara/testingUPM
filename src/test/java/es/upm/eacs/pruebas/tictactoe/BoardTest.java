package es.upm.eacs.pruebas.tictactoe;

/*import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;*/
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

//import es.upm.eacs.pruebas.tictactoe.TicTacToeGame.Cell;

@RunWith(Parameterized.class)
public class BoardTest {

	private Board board;
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] values = {
				{0,1,2,4,5,6, "X", "O", "WINX"},
				{0,3,6,1,2,4, "X", "O", "WINX"},
				{0,2,3,4,1,6, "X", "O", "DRAW"}
				//Add more 
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
	@Parameter(8) public String result;


	@Before
	public void setUp() {
		this.board = new Board();
	}

	@Test
	public void GIVEN__WHEN__THEN()
	{
		board.enableAll();

		board.getCell(cell0).value = playerValueX;
		board.getCell(cell3).value = playerValueO;
		board.getCell(cell1).value = playerValueX;
		board.getCell(cell4).value = playerValueO;
		board.getCell(cell2).value = playerValueX;
		board.getCell(cell5).value = playerValueO;

		int[] winPos = board.getCellsIfWinner(playerValueX);
		if (result == "WINX") {
			assertNotNull("Win X", winPos);
		}
		else {
			assertNull("Draw!",winPos);
		}
	}
	/*
	@Test
	public void getCellsIfWinner_FirstLineWinner()
	{
		Board board = new Board();
		
		board.enableAll();
		
		Cell cell = board.getCell(0);
		cell.value = "X";
		
		Cell cell1 = board.getCell(1);
		cell1.value = "X";
		
		Cell cell2 = board.getCell(2);
		cell2.value = "X";
		
		int[] winPos = board.getCellsIfWinner("X");
		
		int[] winPosEquals = {0,1,2};
		
		assertArrayEquals(winPosEquals, winPos);
		
	}
	
	@Test
	public void getCellsIfWinner_FirstColumnWinner()
	{

		board.enableAll();

		cell = board.getCell(0);
		cell.value = "X";

		cell = board.getCell(3);
		cell.value = "X";

		cell = board.getCell(6);
		cell.value = "X";

		int[] winPos = board.getCellsIfWinner("X");

		int[] winPosEquals = {0,3,6};

		assertArrayEquals(winPosEquals, winPos);

	}

	@Test
	public void getCellsIfWinner_NoWinner()
	{

		board.enableAll();

		Cell cell = board.getCell(0);
		cell.value = "X";

		Cell cell1 = board.getCell(2);
		cell1.value = "X";

		Cell cell2 = board.getCell(3);
		cell2.value = "X";

		int[] winPos = board.getCellsIfWinner("X");

		int[] winPosEquals = null;

		assertEquals(winPosEquals, winPos);

	}

	@Test
	public void checkDraw_isDraw()
	{


		board.enableAll();

		Cell cell;

		for(int i = 0; i < 9; i++)
		{
			cell = board.getCell(i);
			if(i%2 == 0)
			{
				cell.value = "X";
			}
			else
			{
				cell.value = "O";
			}
		}

		boolean isDraw = board.checkDraw();

		assertTrue(isDraw);

	}


	@Test
	public void checkDraw_noDraw()
	{


		board.enableAll();

		Cell cell;

		for(int i = 0; i < 3; i++)
		{

			cell = board.getCell(i);
			cell.value = "X";
		}

		boolean isDraw = board.checkDraw();

		assertFalse(isDraw);

	}
	 */
}
