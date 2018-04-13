package com.bok.helpers;

import java.util.ArrayList;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Intersector;
import com.bok.objects.MainCharacter;
import com.bok.objects.PushUpBarMathProblems;
import com.bok.updaters.GameWorld;
import com.bok.updaters.GameWorld.GameState;



public class InputHandlers implements InputProcessor 
{
	private GameWorld gw;
	private ArrayList<PushUpBarMathProblems> arrayBar;
	private MainCharacter mc;
	public InputHandlers(GameWorld gw, MainCharacter mc)
	{
		this.gw = gw;
		this.mc = mc;
		arrayBar = gw.getPushBarArrayList();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) 
	{
		// TODO Auto-generated method stub
		
		if(GameWorld.currentState == GameState.RUNNING)
		{
			//GameHandler input checker
			//AssetLoaders.point.play(.5f, 2, 0);
			for(int i = 0; i<arrayBar.size();i++)
			{
				PushUpBarMathProblems pubmp = arrayBar.get(i);
				if(Intersector.overlaps(pubmp.getCollision(), mc.getCollision()))
				{
					AssetLoaders.point.play(.05f, 2, 0);
					pubmp.setHit(pubmp.getHit()+1);
					gw.getGh().setScore(gw.getGh().getScore()+1);
				}
			}
		}
		if(GameWorld.currentState == GameState.READY)
		{
			GameWorld.currentState = GameState.RUNNING;
			
		}
	
	
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) 
	{
		if(GameWorld.currentState == GameState.GAMEOVER && mc.isHitGround())
		{
			gw.getGh().checkHomeAndRetryButton(screenX, screenY);
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
