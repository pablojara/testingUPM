package es.upm.eacs.pruebas.tictactoe;

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

@RunWith(Parameterized.class)
public class BoardParameterizedTest {

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
}