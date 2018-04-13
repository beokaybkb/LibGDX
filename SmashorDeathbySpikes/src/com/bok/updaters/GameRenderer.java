package com.bok.updaters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bok.helpers.AssetLoaders;
import com.bok.objects.PushUpBarMathProblems;
import com.bok.updaters.GameWorld.GameState;

public class GameRenderer
{
	// use the info from GameWorld to update the GameRenderer Class
	private GameWorld gw;
	private OrthographicCamera oc;
	private ShapeRenderer sr;
	private SpriteBatch sb;
	private ArrayList<PushUpBarMathProblems> barArray;
	private int number;
	
	public GameRenderer(GameWorld gw, int number)
	{
		this.number = number;
		this.gw = gw;
		oc = new OrthographicCamera();
		oc.setToOrtho(true, 480, 800);
		
		sr = new ShapeRenderer();
		sr.setProjectionMatrix(oc.combined);
		
		sb = new SpriteBatch();
		sb.setProjectionMatrix(oc.combined);
		
		barArray = gw.getPushBarArrayList();
	}
	
	public void render(float delta)
	{
		
		if(GameWorld.currentState == GameState.READY)
		{
			
			sb.begin();
			renderBackGround();
			renderMainCharacter();
			renderPushBar();
			renderDeathBar();
			renderInstructions();
			sb.end();
		}
		if(GameWorld.currentState == GameState.RUNNING)
		{
			sb.begin();
			renderBackGround();
			renderScore();
			renderMainCharacter();
			renderPushBar();
			renderDeathBar();
			sb.end();
		}
		if(GameWorld.currentState == GameState.GAMEOVER)
		{
			sb.begin();
			renderBackGround();
			renderPushBar();
			renderMainCharacter();
			renderDeathBar();
			renderHighScore();
			sb.end();
		}
		
	}

	private void renderHighScore()
	{
		if(gw.getMc().isHitGround() == true)
		{
			//show highscore
			switch(number)
			{
			case 0:
				sb.draw(AssetLoaders.gameOverRed, 40, 200);
				break;
			case 1:
				sb.draw(AssetLoaders.gameOverBlue, 40, 200);
				break;
			case 2:
				sb.draw(AssetLoaders.gameOverGreen, 40, 200);
				break;
			case 3:
				sb.draw(AssetLoaders.gameOverYellow, 40, 200);
				break;
			}
			
			AssetLoaders.font.draw(sb, "Your", 65, 320);
			AssetLoaders.font.draw(sb, "Score", 80, 350);
			
			AssetLoaders.font.draw(sb, "Best", 300, 320);
			AssetLoaders.font.draw(sb, "Score", 315, 350);
			
			//current score
			String score = String.valueOf(gw.getGh().getScore());
			if(score.length() == 1)
			{
				AssetLoaders.font.draw(sb, "000"+score, 87, 410);
			}
			if(score.length() == 2)
			{
				AssetLoaders.font.draw(sb, "00"+score, 87, 410);
			}
			if(score.length() == 3)
			{
				AssetLoaders.font.draw(sb, "0"+score, 87, 410);
			}
			if(score.length() == 4)
			{
				AssetLoaders.font.draw(sb, score, 87, 410);
			}
			
			
			String highScore = String.valueOf(AssetLoaders.getHighScore(gw.getGameNumber()));
			if(highScore.length() == 1)
			{
				AssetLoaders.font.draw(sb, "000"+highScore, 322, 410);
			}
			if(highScore.length() == 2)
			{
				AssetLoaders.font.draw(sb, "00"+highScore, 322, 410);
			}
			if(highScore.length() == 3)
			{
				AssetLoaders.font.draw(sb, "0"+highScore, 322, 410);
			}
			if(highScore.length() == 4)
			{
				AssetLoaders.font.draw(sb, highScore, 322, 410);
			}
			
			sb.draw(AssetLoaders.home, 213, 400);
			sb.draw(AssetLoaders.restart, 213, 320);
		}
	}
	private void renderDeathBar()
	{
		sb.draw(AssetLoaders.deathBarTop, gw.getDbTop().getPosition().x, gw.getDbTop().getPosition().y);
		sb.draw(AssetLoaders.deathBarBottom, gw.getDbBottom().getPosition().x, gw.getDbBottom().getPosition().y);
	}
	private void renderMainCharacter()
	{
		TextureRegion mainCharacter = null;
		TextureRegion mainCharacterDead = null;
		switch(number)
		{
		case 0:
			mainCharacter = AssetLoaders.mainRed;
			mainCharacterDead = AssetLoaders.mainRedDead;
			break;
		case 1:
			mainCharacter = AssetLoaders.mainBlue;
			mainCharacterDead = AssetLoaders.mainBlueDead;
			break;
		case 2:
			mainCharacter = AssetLoaders.mainGreen;
			mainCharacterDead = AssetLoaders.mainGreenDead;
			break;
		case 3:
			mainCharacter = AssetLoaders.mainYellow;
			mainCharacterDead = AssetLoaders.mainYellowDead;
			break;
		}
		
		
		if(gw.getMc().isDead())
		{
			sb.draw(mainCharacterDead, gw.getMc().getPosition().x, gw.getMc().getPosition().y, gw.getMc().getWidth()/2,gw.getMc().getHeight()/2 , gw.getMc().getWidth(), gw.getMc().getHeight(), 1, 1, gw.getMc().getRotation());
		}else
		{
			sb.draw(mainCharacter, gw.getMc().getPosition().x, gw.getMc().getPosition().y);
		}	
		
		
	}
	
	private void renderPushBar()
	{
		for(int i = 0;i<gw.getPushBarArrayList().size();i++)
		{
			TextureRegion tr = null;
			PushUpBarMathProblems pubmp = gw.getPushBarArrayList().get(i);
			switch(pubmp.getTileColor())
			{
			case 0:
				tr = AssetLoaders.silverTiles;
				break;
			case 1:
				tr = AssetLoaders.redTiles;
				break;
			case 2:
				tr = AssetLoaders.purpleTiles;
				break;
			case 3:
				tr = AssetLoaders.greenTiles;
				break;
			case 4:
				tr = AssetLoaders.yellowTiles;
				break;
			case 5:
				tr = AssetLoaders.tealTiles;
				break;
			}
			sb.draw(tr, pubmp.getPosition().x, pubmp.getPosition().y);
			
			AssetLoaders.font.draw(sb, String.valueOf(pubmp.getHP()-pubmp.getHit()), 220, pubmp.getPosition().y+9);
		}
	}
	private void renderBackGround()
	{
		//tweening
		switch(gw.getGameNumber())
		{
		case 0:
			sb.draw(AssetLoaders.redBackground, 0, 0);
			break;
		case 1:
			sb.draw(AssetLoaders.blueBackground, 0, 0);
			break;
		case 2:
			sb.draw(AssetLoaders.greenBackground, 0, 0);
			break;
		case 3:
			sb.draw(AssetLoaders.yellowBackground, 0, 0);
			break;
		}
	}
	private void renderInstructions()
	{
		AssetLoaders.smallFont.draw(sb,"SPIKES WILL KILL YOU",105,40);
		AssetLoaders.font.draw(sb,"TAP TO SMASH",110,400);
		AssetLoaders.smallFont.draw(sb,"SPIKES WILL KILL YOU",105,730);
	}
	private void renderScore()
	{
		String score = String.valueOf(gw.getGh().getScore());
		if(score.length() == 1)
		{
			AssetLoaders.bigFont.draw(sb,"000"+score, 83, 40);
		}
		if(score.length() == 2)
		{
			AssetLoaders.bigFont.draw(sb,"00"+score, 83, 40);
		}
		if(score.length() == 3)
		{
			AssetLoaders.bigFont.draw(sb,"0"+score, 83, 40);
		}
		if(score.length() == 4)
		{
			AssetLoaders.bigFont.draw(sb,score, 83, 40);
		}
		
	}
}
