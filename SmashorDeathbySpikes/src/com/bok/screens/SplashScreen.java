package com.bok.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bok.MDKgame.MDKgame;
import com.bok.helpers.AssetLoaders;
import com.bok.tween.SpriteAccessor;

public class SplashScreen implements Screen {

	private TweenManager manager;
	private SpriteBatch batcher;
	private Sprite sprite;
	private MDKgame game;
	private OrthographicCamera oc;
	
	public SplashScreen(MDKgame game)
	{
		this.game = game;	
		
	}
	
	public void render(float delta) {
		manager.update(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batcher.begin();
        sprite.draw(batcher);
        batcher.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		sprite = new Sprite(AssetLoaders.logo);
		sprite.setColor(1,1, 1, 0);
		sprite.setPosition(0, 0);
		setupTween();
		batcher = new SpriteBatch();
		oc = new OrthographicCamera();
		oc.setToOrtho(false, 480, 800);
		batcher.setProjectionMatrix(oc.combined);
	}

	private void setupTween()
	{
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		manager = new TweenManager();
		
		TweenCallback cb = new TweenCallback()
		{
			public void onEvent(int type, BaseTween<?> source)
			{
				game.setScreen(new MenuScreen(game));
			}
		};
		
		Tween.to(sprite, SpriteAccessor.ALPHA, 1.6f).target(1)
		.ease(TweenEquations.easeInQuad).repeatYoyo(1, .4f)
		.setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE)
		.start(manager);
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
