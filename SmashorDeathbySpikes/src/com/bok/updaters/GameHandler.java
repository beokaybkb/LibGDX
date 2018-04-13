package com.bok.updaters;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bok.MDKgame.MDKgame;
import com.bok.helpers.AssetLoaders;
import com.bok.objects.DeathBar;
import com.bok.objects.MainCharacter;
import com.bok.objects.PushUpBarMathProblems;
import com.bok.updaters.GameWorld.GameState;

public class GameHandler 
{
	private GameWorld gw;
	private float gameWidth, gameHeight;
	private MainCharacter mc;
	private DeathBar dbTop,dbBottom;
	private ArrayList barArrayList,buttonArray;
	private Vector2 gravityDown,stop;
	private Rectangle collisionRetry, collisionHome;
	private float collisionRetryY,collisionHomeY,collisionRetryAndHomeX,collisionRetryAndHomeWidth,collisionRetryAndHomeHeight;
	private int score;
	private Random random;
	
	public GameHandler(GameWorld gw,float gameWidth, float gameHeight)
	{
		this.gw = gw;
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		score = 0;
		random = new Random();
		dbTop = gw.getDbTop();
		dbBottom = gw.getDbBottom();
		mc = gw.getMc();
		barArrayList = gw.getPushBarArrayList();
		gravityDown = new Vector2(0,1300);
		stop = new Vector2(0,0);
		collisionRetryY = (320.0f/800.0f) *gameHeight;
		collisionHomeY = (400.0f/800.0f) *gameHeight;
		collisionRetryAndHomeX = (213.0f/480.0f) *gameWidth;
		collisionRetryAndHomeWidth = (60.0f/480.0f)*gameWidth;
		collisionRetryAndHomeHeight = (60.0f/800.0f)*gameHeight;
		collisionRetry = new Rectangle(collisionRetryAndHomeX,collisionRetryY,collisionRetryAndHomeWidth,collisionRetryAndHomeHeight);
		collisionHome = new Rectangle(collisionRetryAndHomeX,collisionHomeY,collisionRetryAndHomeWidth,collisionRetryAndHomeHeight);
		
	}
	
	//Regular Update
	public void readyUpdate(float delta)
	{
		//reset
	}
	public void runningUpdate(float delta)
	{
		mc.update(delta);
		//update pushBars here
		
		for(int i = 0; i<barArrayList.size();i++)
		{
			PushUpBarMathProblems pubmp = (PushUpBarMathProblems)barArrayList.get(i);
			pubmp.update(delta);
		}
		//stopAtBottom();
		// collision between Main character and Bar
		collisionMainAndBar();
		resetPositionForPushBar();
		checkForDeath();
		
		if(mc.isDead())
		{
			GameWorld.currentState = GameState.GAMEOVER;
			
		}
		changeSpeedOfPushBars();
	}
	public void gameoverUpdate(float delta)
	{
		
		mc.update(delta);
		
	}
	
	
	//Irregular Update
	public void irregularReadyUpdate(float delta)
	{
		
	}
	public void irregularRunningUpdate(float delta)
	{
		mc.update(delta);
		for(int i = 0; i<barArrayList.size();i++)
		{
			PushUpBarMathProblems pubmp = (PushUpBarMathProblems)barArrayList.get(i);
			pubmp.update(delta);
			//change pubmp's speed depending on the time
		}
		collisionMainAndBar();
		resetPositionForPushBar();
		checkForDeath();
		if(mc.isDead())
		{
			
			GameWorld.currentState = GameState.GAMEOVER;
		}
	}
	public void irregularGameOverUpdate(float delta)
	{
		mc.update(delta);
	}
	// Endurance Update
	public void enduranceReadyUpdate(float delta)
	{
		
	}
	public void enduranceRunningUpdate(float delta)
	{
		mc.update(delta);
		for(int i = 0; i<barArrayList.size();i++)
		{
			PushUpBarMathProblems pubmp = (PushUpBarMathProblems)barArrayList.get(i);
			pubmp.update(delta);
		}
		collisionMainAndBar();
		resetPositionForPushBar();
		checkForDeath();
		if(mc.isDead())
		{
			
			GameWorld.currentState = GameState.GAMEOVER;
		}
	}
	public void enduranceGameOverUpdate(float delta)
	{
		mc.update(delta);
	}
	//Lightening Update
	public void lighteningReadyUpdate(float delta)
	{
		for(int i = 0; i<1;i++)
		{
			PushUpBarMathProblems pubmp = (PushUpBarMathProblems)barArrayList.get(i);
		}
	}
	public void lighteningRunningUpdate(float delta)
	{
		for(int i = 0; i<1;i++)
		{
			PushUpBarMathProblems pubmp = (PushUpBarMathProblems)barArrayList.get(i);
		}
		mc.update(delta);
		for(int i = 0; i<barArrayList.size();i++)
		{
			PushUpBarMathProblems pubmp = (PushUpBarMathProblems)barArrayList.get(i);
			pubmp.update(delta);
		}
		collisionMainAndBar();
		resetPositionForPushBar();
		checkForDeath();
		if(mc.isDead())
		{
			
			GameWorld.currentState = GameState.GAMEOVER;
		}
		
		
	}
	public void lighteningGameOverUpdate(float delta)
	{
		mc.update(delta);
	}
	
	
	
	
	private void changeSpeedOfPushBars()
	{
		int speed = 0-random.nextInt(500);
		for(int i = 0; i<barArrayList.size();i++)
		{
			PushUpBarMathProblems pubmp = (PushUpBarMathProblems)barArrayList.get(i);
			switch(GameWorld.gameNumber)
			{
			case 0:
				if(score%100 == 0)
				{
					pubmp.changeSpeed(score/100);
				}
				break;
			case 1:
				if(speed>-200)
				{
					speed = -200;
				}
				pubmp.changeSpeed(speed);
				break;
			case 2:
				break;
			case 3:
				break;
			}
			
			
		}
	}
	
	
	
	private void checkForDeath()
	{
		if(Intersector.overlaps(mc.getCollision(),dbTop.getCollision())||Intersector.overlaps(mc.getCollision(),dbBottom.getCollision()))
		{
			
			mc.dead();
			
			if(score>AssetLoaders.getHighScore(gw.getGameNumber()))
			{
				AssetLoaders.setHighScore(score,gw.getGameNumber());
			}
		}
	}
	public void checkHomeAndRetryButton(int screenX, int screenY)
	{
		if(collisionRetry.contains(screenX, screenY))
		{
			//retry 
			retry();
			GameWorld.currentState = GameState.READY;
			
		}
		if(collisionHome.contains(screenX, screenY))
		{
			//go to home
			gw.goToMenu();
		}
	}
	
	private void retry()
	{
		score = 0;
		mc.retry();
		for(int i = 0; i<barArrayList.size();i++)
		{
			PushUpBarMathProblems pubmp = (PushUpBarMathProblems) barArrayList.get(i);
			pubmp.retry();
		}
	}
	
	private void resetPositionForPushBar()
	{
		
		for(int i = 0; i<barArrayList.size();i++)
		{
			PushUpBarMathProblems pubmp = (PushUpBarMathProblems)barArrayList.get(i);
			
			
			
			if(pubmp.isSmashed() == true)
			{
				if(i == 0)
				{
					pubmp.changePositionY((PushUpBarMathProblems)barArrayList.get(barArrayList.size()-1));
				}
				if(i>0)
				{
					pubmp.changePositionY((PushUpBarMathProblems)barArrayList.get(i-1));
				}
				pubmp.setSmashed(false);
				pubmp.setPlayPoint(false);
				pubmp.setHit(0);
				pubmp.resetHP();
				pubmp.resetColor();
				changeSpeedOfPushBars();
				//reset HP with random value
				//depending on the color, choose the rendering of the tile
			}
		}
	}
	
	private void collisionMainAndBar()
	{
		for(int i = 0; i<barArrayList.size();i++)
		{
			PushUpBarMathProblems pubmp = (PushUpBarMathProblems)barArrayList.get(i);
			
			if(Intersector.overlaps(mc.getCollision(), pubmp.getCollision()))
			{
				if(pubmp.getHP() <= pubmp.getHit())
				{
					pubmp.setSmashed(true);
				}
				
				if(pubmp.isSmashed() == false)
				{
					mc.changeSpeed(pubmp.getGravityUp());
					mc.setPositionY(pubmp.getPosition().y-mc.getHeight()+1);
				}
				if(pubmp.isSmashed() == true)
				{
					mc.changeSpeed(gravityDown);
					if(pubmp.isPlayPoint() == false)
					{
					AssetLoaders.brokenTile.play(.03f,2f,0);
					pubmp.setPlayPoint(true);
					//reset this later when the tiles repositions
					}
						
				
				}
			}
		}
		
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	//answer checker betweeen arraylist of mathproblems and signbutton
	//collision between mathproblem bar and maincharacter
	// collision between maincharacter and deathbar
}
