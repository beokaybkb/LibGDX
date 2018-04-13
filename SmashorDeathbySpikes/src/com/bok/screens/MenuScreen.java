package com.bok.screens;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.bok.MDKgame.MDKgame;
import com.bok.helpers.AssetLoaders;
import com.bok.helpers.InputHandlerMenu;

public class MenuScreen implements Screen 
{

	private MDKgame game;
	private SpriteBatch batcher;
	private OrthographicCamera oc;
	private Rectangle red,green,blue,yellow, playButton, highScore,homeButton;
	
	private int number;
	private float gameWidth,gameHeight;
	private Random random;
	public static MenuMode mode;
	
	//0 = red
	//1 = blue
	//2 = green
	//3 = yellow
	
	public enum MenuMode
	{
		MENU,HIGHSCORE;
	}
	public MenuScreen(MDKgame game)
	{
		this.game = game;
		gameWidth = Gdx.graphics.getWidth();
		gameHeight = Gdx.graphics.getHeight();
		
		mode = MenuMode.MENU;
		Gdx.input.setInputProcessor(new InputHandlerMenu(this));
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		

		
		if(mode == MenuMode.MENU)
		{
			batcher.begin();
			batcher.draw(AssetLoaders.menu, 0, 0);
			batcher.draw(AssetLoaders.playButton, 160, 450);
			batcher.draw(AssetLoaders.highscoreButton, 260, 450);
			AssetLoaders.smallFont.draw(batcher, "Regular", 72, 123);
			AssetLoaders.smallFont.draw(batcher, "Lightening", 287, 772);
			AssetLoaders.smallFont.draw(batcher, "Endurance", 47, 772);
			AssetLoaders.smallFont.draw(batcher, "Irregular",298, 123);
			drawSelected();
			batcher.end();
		}
		if(mode == MenuMode.HIGHSCORE)
		{
			//render the highScore screen here
			Gdx.gl20.glClearColor(0, 0, 0, 1);
			Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			batcher.begin();
			batcher.draw(AssetLoaders.colorHighScore, 0, 0);
			
			String redScore = String.valueOf(AssetLoaders.getHighScore(0));
			String blueScore = String.valueOf(AssetLoaders.getHighScore(1));
			String greenScore = String.valueOf(AssetLoaders.getHighScore(2));
			String yellowScore = String.valueOf(AssetLoaders.getHighScore(3));
			
			AssetLoaders.font.draw(batcher, "Your Best", 25, 150);
			AssetLoaders.font.draw(batcher, "Your Best", 265, 150);
			AssetLoaders.font.draw(batcher, "Your Best", 25, 500);
			AssetLoaders.font.draw(batcher, "Your Best", 265, 500);
			
			switch(redScore.length())
			{
			case 1:
				AssetLoaders.smallBigFont.draw(batcher, "000"+redScore, 40, 220);
				break;
			case 2:
				AssetLoaders.smallBigFont.draw(batcher, "00"+redScore, 40, 220);
				break;
			case 3:
				AssetLoaders.smallBigFont.draw(batcher, "0"+redScore, 40, 220);
				break;
			case 4:
				AssetLoaders.smallBigFont.draw(batcher, redScore, 40, 220);
				break;
			}
			switch(blueScore.length())
			{
			case 1:
				AssetLoaders.smallBigFont.draw(batcher, "000"+blueScore, 280, 220);
				break;
			case 2:
				AssetLoaders.smallBigFont.draw(batcher, "00"+blueScore, 280, 220);
				break;
			case 3:
				AssetLoaders.smallBigFont.draw(batcher, "0"+blueScore, 280, 220);
				break;
			case 4:
				AssetLoaders.smallBigFont.draw(batcher, blueScore, 280, 220);
				break;
			}
			switch(greenScore.length())
			{
			case 1:
				AssetLoaders.smallBigFont.draw(batcher, "000"+greenScore, 40, 570);
				break;
			case 2:
				AssetLoaders.smallBigFont.draw(batcher, "00"+greenScore, 40, 570);
				break;
			case 3:
				AssetLoaders.smallBigFont.draw(batcher, "0"+greenScore, 40, 570);
				break;
			case 4:
				AssetLoaders.smallBigFont.draw(batcher, greenScore, 40, 570);
				break;
			}
			switch(yellowScore.length())
			{
			case 1:
				AssetLoaders.smallBigFont.draw(batcher, "000"+yellowScore, 280, 570);
				break;
			case 2:
				AssetLoaders.smallBigFont.draw(batcher, "00"+yellowScore, 280, 570);
				break;
			case 3:
				AssetLoaders.smallBigFont.draw(batcher, "0"+yellowScore, 280, 570);
				break;
			case 4:
				AssetLoaders.smallBigFont.draw(batcher, yellowScore, 280, 570);
				break;
			}
			
			batcher.draw(AssetLoaders.home, 210, 720);
			batcher.end();
		}
	}

	private void drawSelected()
	{
		switch(number)
		{
		case 0:
			batcher.draw(AssetLoaders.selectedRed, 0, 0);
			break;
		case 1:
			batcher.draw(AssetLoaders.selectedBlue, 240, 0);
			break;
		case 2:
			batcher.draw(AssetLoaders.selectedGreen,0,650);
			break;
		case 3:
			batcher.draw(AssetLoaders.selectedYellow, 240, 650);
			break;
		}
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		oc = new OrthographicCamera();
		oc.setToOrtho(true, 480, 800);
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(oc.combined);
		random = new Random();
		red = new Rectangle((0f/480)*gameWidth,(0f/800)*gameHeight,(240f/480)*gameWidth,(150f/800)*gameHeight);
		blue = new Rectangle((240f/480)*gameWidth,(0f/800)*gameHeight,(240f/480)*gameWidth,(150f/800)*gameHeight);
		green = new Rectangle((0f/480)*gameWidth,(650f/800)*gameHeight,(240f/480)*gameWidth,(150f/800)*gameHeight);
		yellow = new Rectangle((240f/480)*gameWidth,(650f/800)*gameHeight,(240f/480)*gameWidth,(150f/800)*gameHeight);
		playButton = new Rectangle((160f/480)*gameWidth,(450f/800)*gameHeight,(60f/480)*gameWidth,(60f/800)*gameHeight);
		highScore = new Rectangle((260f/480)*gameWidth,(450f/800)*gameHeight,(60f/480)*gameWidth,(60f/800)*gameHeight);
		homeButton = new Rectangle((0f/480.0f)*gameWidth,(700f/800)*gameHeight,(480f/480f)*gameWidth,(100f/800)*gameHeight);
		number = random.nextInt(4);
		
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void checkForCollision(int screenX, int screenY)
	{
		
		if(mode == MenuMode.MENU)
		{
			if(red.contains(screenX, screenY))
			{
				number = 0;
			}
			if(blue.contains(screenX, screenY))
			{
				number = 1;
			}
			if(yellow.contains(screenX, screenY))
			{
				number = 3;
			}
			if(green.contains(screenX, screenY))
			{
				number = 2;	
			}
			if(playButton.contains(screenX, screenY))
			{
				game.setScreen(new GameScreen(game,number,this));
			}
			if(highScore.contains(screenX, screenY))
			{
				mode = MenuMode.HIGHSCORE;
			}
		}
		
		if(mode == MenuMode.HIGHSCORE)
		{
			if(homeButton.contains(screenX, screenY))
			{
				mode = MenuMode.MENU;
			}
		}
	}


}
