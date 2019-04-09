package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;

public class BoardTest {
	
	

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
		Board board = new Board();
		
		board.enableAll();
		
		Cell cell = board.getCell(0);
		cell.value = "X";
		
		Cell cell1 = board.getCell(3);
		cell1.value = "X";
		
		Cell cell2 = board.getCell(6);
		cell2.value = "X";
		
		int[] winPos = board.getCellsIfWinner("X");
		
		int[] winPosEquals = {0,3,6};
		
		assertArrayEquals(winPosEquals, winPos);
		
	}
	
	@Test
	public void getCellsIfWinner_NoWinner()
	{
		Board board = new Board();
		
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
		
		Board board = new Board();
		
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
		
		Board board = new Board();
		
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
	
}
