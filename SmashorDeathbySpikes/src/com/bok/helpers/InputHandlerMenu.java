package com.bok.helpers;

import com.badlogic.gdx.InputProcessor;
import com.bok.screens.MenuScreen;
import com.bok.screens.MenuScreen.MenuMode;

public class InputHandlerMenu implements InputProcessor{

	private MenuScreen ms;
	
	public InputHandlerMenu(MenuScreen ms)
	{
		this.ms = ms;
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
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		if(MenuScreen.mode == MenuMode.MENU)
		{
			ms.checkForCollision(screenX, screenY);
		}
		if(MenuScreen.mode == MenuMode.HIGHSCORE)
		{
			ms.checkForCollision(screenX,screenY);
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
