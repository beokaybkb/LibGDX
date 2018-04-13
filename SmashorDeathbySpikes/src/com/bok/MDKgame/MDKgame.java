package com.bok.MDKgame;

import com.badlogic.gdx.Game;
import com.bok.helpers.AssetLoaders;
import com.bok.screens.SplashScreen;

public class MDKgame extends Game 
{
	
	
	@Override
	public void create()
	{
		
		AssetLoaders.load();
		setScreen(new SplashScreen(this));
		
	}
	
}
