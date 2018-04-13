package com.bok.updaters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.bok.MDKgame.MDKgame;
import com.bok.helpers.InputHandlerMenu;
import com.bok.helpers.InputHandlers;
import com.bok.objects.DeathBar;
import com.bok.objects.MainCharacter;
import com.bok.objects.PushUpBarMathProblems;
import com.bok.screens.MenuScreen;

public class GameWorld 
{
	// purpose of GameWorld class is to initialize objects here so it can used in GameHandler and GameRenderer
	private GameHandler gh;
	// the main character
	// 4 pushUps in an ArrayList
	// 3 mathproblems in a different ArrayList
	// 1 death Bar
	private MainCharacter mc;
	private DeathBar dbTop,dbBottom;
	private PushUpBarMathProblems first,second, third, fourth;
	private float gameWidth, gameHeight;
	private ArrayList<PushUpBarMathProblems> pushBarArrayList;
	public static GameState currentState;
	public static GameMode currentMode;
	public static int gameNumber;
	private MDKgame game;
	private MenuScreen menu;
	
	public enum GameState
	{
		READY,RUNNING,GAMEOVER;
	}
	public enum GameMode
	{
		REGULAR,IRREGULAR,ENDURANCE,LIGHTENING;
	}
	
	public GameWorld(int number,MDKgame game,MenuScreen menu)
	{
		gameNumber = number;
		this.game = game;
		this.menu = menu;
		currentState = GameState.READY;
		switch(number)
		{
		case 0:
			currentMode = GameMode.REGULAR;
			break;
		case 1:
			currentMode = GameMode.IRREGULAR;
			break;
		case 2:
			currentMode = GameMode.ENDURANCE;
			break;
		case 3:
			currentMode = GameMode.LIGHTENING;
			break;
		}
		gameWidth = Gdx.graphics.getWidth();
		gameHeight = Gdx.graphics.getHeight();
		
		pushBarArrayList = new ArrayList();

		
		
		
		//initialize MainCharacter
		mc = new MainCharacter(gameWidth,gameHeight);
		//initialize other objects
		dbTop = new DeathBar(gameWidth, gameHeight,0,0);
		dbBottom = new DeathBar(gameWidth,gameHeight,0,770);
		first = new PushUpBarMathProblems(gameWidth,gameHeight,0);
		second = new PushUpBarMathProblems(gameWidth,gameHeight,1);
		third = new PushUpBarMathProblems(gameWidth,gameHeight,2);
		fourth = new PushUpBarMathProblems(gameWidth,gameHeight,3);
		
		
		
		pushBarArrayList.add(first);
		pushBarArrayList.add(second);
		pushBarArrayList.add(third);
		pushBarArrayList.add(fourth);
		
		
		
		
		Gdx.input.setInputProcessor(new InputHandlers(this,mc));
		
		// this will do the dirty work
		gh = new GameHandler(this,gameWidth, gameHeight);
	}
	
	public void goToMenu()
	{
		
		game.setScreen(menu);
		Gdx.input.setInputProcessor(new InputHandlerMenu(menu));
	}
	public void update(float delta)
	{
		if(currentMode == GameMode.REGULAR)
		{
			if(currentState == GameState.READY)
			{
				gh.readyUpdate(delta);
			}
		
			if(currentState == GameState.RUNNING)
			{
				gh.runningUpdate(delta);
			}
			if(currentState == GameState.GAMEOVER)
			{
				gh.gameoverUpdate(delta);
			}
		}
		
		if(currentMode == GameMode.IRREGULAR)
		{
			if(currentState == GameState.READY)
			{
				gh.irregularReadyUpdate(delta);
			}
			if(currentState == GameState.RUNNING)
			{
				gh.irregularRunningUpdate(delta);
			}
			if(currentState == GameState.GAMEOVER)
			{
				gh.irregularGameOverUpdate(delta);
			}
		}
		if(currentMode == GameMode.ENDURANCE)
		{
			if(currentState == GameState.READY)
			{
				gh.enduranceReadyUpdate(delta);
			}
			if(currentState == GameState.RUNNING)
			{
				gh.enduranceRunningUpdate(delta);
			}
			if(currentState == GameState.GAMEOVER)
			{
				gh.enduranceGameOverUpdate(delta);
			}
		}
		if(currentMode == GameMode.LIGHTENING)
		{
			if(currentState == GameState.READY)
			{
				gh.lighteningReadyUpdate(delta);
			}
			if(currentState == GameState.RUNNING)
			{
				gh.lighteningRunningUpdate(delta);
			}
			if(currentState == GameState.GAMEOVER)
			{
				gh.lighteningGameOverUpdate(delta);
			}
		}
	}

	public MainCharacter getMc() {
		return mc;
	}



	public ArrayList<PushUpBarMathProblems> getPushBarArrayList() {
		return pushBarArrayList;
	}


	public GameHandler getGh() {
		return gh;
	}

	public DeathBar getDbTop() {
		return dbTop;
	}

	public DeathBar getDbBottom() {
		return dbBottom;
	}

	public int getGameNumber() {
		return gameNumber;
	}
}
