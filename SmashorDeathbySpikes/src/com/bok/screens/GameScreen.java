package com.bok.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bok.MDKgame.MDKgame;
import com.bok.updaters.GameRenderer;
import com.bok.updaters.GameWorld;

public class GameScreen implements Screen 
{
	//initiate GameWorld
	//initiate GameRender
	private GameWorld gw;
	private GameRenderer gr;
	private MDKgame game;
	private int number;
	
	public GameScreen(MDKgame game, int number,MenuScreen menu)
	{
		this.game = game;
		this.number = number;
		gw = new GameWorld(number,game,menu);
		gr = new GameRenderer(gw,number);
	}
	@Override
	public void render(float delta) {
		gw.update(delta);
		gr.render(delta);
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		//MDKgame.ad.showBannerAd();
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

}
