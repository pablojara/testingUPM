package es.codeurjc.ais.tictactoe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TicTacToeSystemTest{

	private WebDriver driverO;
	private WebDriver driverX;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
		WebApp.start();
	}
	@AfterClass
	public static void teardownClass() {
		WebApp.stop();
	}
	@Before
	public void setupTest() {
		driverO = new ChromeDriver();
		driverX = new ChromeDriver();
	}
	@After
	public void teardown() {
		if (driverO != null) {
			driverO.quit();
		}
		if (driverX != null) {
			driverX.quit();
		}
	}
	
	@Test
	public void GIVEN_twoPlayers_WHEN_firstOneStarts_THEN_Win() { 
		driverO.get("http://localhost:8080/");
		driverX.get("http://localhost:8080/");

		driverO.findElement(By.id("nickname")).sendKeys("Pablo");
		driverO.findElement(By.id("startBtn")).click();
		driverX.findElement(By.id("nickname")).sendKeys("Maria");
		driverX.findElement(By.id("startBtn")).click();

		driverO.findElement(By.id("cell-0")).click();
		driverX.findElement(By.id("cell-3")).click();
		
		driverO.findElement(By.id("cell-1")).click();
		driverX.findElement(By.id("cell-5")).click();
		
		driverO.findElement(By.id("cell-2")).click();

		String body = driverX.switchTo().alert().getText();
		String newBody = "Pablo wins! Maria looses.";
		Assert.assertEquals(body, newBody);
	}
	
	@Test
	public void GIVEN_twoPlayers_WHEN_firstOneStarts_THEN_Lose() { 
		driverO.get("http://localhost:8080/");
		driverX.get("http://localhost:8080/");

		driverO.findElement(By.id("nickname")).sendKeys("Pablo");
		driverO.findElement(By.id("startBtn")).click();
		driverX.findElement(By.id("nickname")).sendKeys("Maria");
		driverX.findElement(By.id("startBtn")).click();

		driverO.findElement(By.id("cell-0")).click();
		driverX.findElement(By.id("cell-3")).click();
		
		driverO.findElement(By.id("cell-7")).click();
		driverX.findElement(By.id("cell-4")).click();
		
		driverO.findElement(By.id("cell-2")).click();
		driverX.findElement(By.id("cell-5")).click();


		String body = driverX.switchTo().alert().getText();
		String newBody = "Maria wins! Pablo looses.";
		Assert.assertEquals(body, newBody);
	}
	
	@Test
	public void GIVEN_twoPlayers_WHEN_firstOneStarts_THEN_NobodyWin() { 
		driverO.get("http://localhost:8080/");
		driverX.get("http://localhost:8080/");

		driverO.findElement(By.id("nickname")).sendKeys("Pablo");
		driverO.findElement(By.id("startBtn")).click();
		driverX.findElement(By.id("nickname")).sendKeys("Maria");
		driverX.findElement(By.id("startBtn")).click();

		driverO.findElement(By.id("cell-0")).click();
		driverX.findElement(By.id("cell-1")).click();
		
		driverO.findElement(By.id("cell-2")).click();
		driverX.findElement(By.id("cell-5")).click();
		
		driverO.findElement(By.id("cell-3")).click();
		driverX.findElement(By.id("cell-6")).click();
		
		driverO.findElement(By.id("cell-4")).click();
		driverX.findElement(By.id("cell-8")).click();
		
		driverO.findElement(By.id("cell-7")).click();

		String body = driverX.switchTo().alert().getText();
		String newBody = "Draw!";
		Assert.assertEquals(body, newBody);
	}
}
