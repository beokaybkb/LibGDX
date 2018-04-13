package com.bok.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoaders 
{
	//texture
	public static Texture texture,logo,menuMap,playButtonMap,highscoreButtonMap,selectedCharacters,colorBackground,colorGameOver,homeAndRestart,colorHighScoreMap;
	public static TextureRegion deathBarTop,deathBarBottom,
						  mainGreen,mainBlue,mainYellow,mainRed,
						  mainGreenDead,mainBlueDead,mainYellowDead,mainRedDead,
						  plusNotPressed,minusNotPressed, multiplyNotPressed,divideNotPressed,
						  plusPressed,minusPressed,multiplyPressed,dividePressed,
						  deathSkull,
						  menu,playButton,highscoreButton,
						  selectedGreen,selectedBlue,selectedYellow,selectedRed,
						  redTiles,silverTiles,purpleTiles,greenTiles,yellowTiles,tealTiles,
						  redBackground,blueBackground,greenBackground,yellowBackground,
						  gameOverRed,gameOverGreen,gameOverBlue,gameOverYellow,
						  home, restart,
						  colorHighScore;
	public static BitmapFont font,smallFont,smallBigFont,bigFont;
	public static Sound point,death,brokenTile;
	public static Preferences highScore;
	
	public static void load()
	{
		colorHighScoreMap = new Texture(Gdx.files.internal("data/colorHighScoreMap.png"));
		colorBackground = new Texture(Gdx.files.internal("data/colorBackgroundMap.png"));
		selectedCharacters = new Texture(Gdx.files.internal("data/menu/SelectedCharacter.png"));
		playButtonMap = new Texture(Gdx.files.internal("data/menu/playButton.png"));
		highscoreButtonMap = new Texture(Gdx.files.internal("data/menu/highscoreButton.png"));
		menuMap = new Texture(Gdx.files.internal("data/menu/Menu.png"));
		colorGameOver = new Texture(Gdx.files.internal("data/colorGameOver.png"));
		
		homeAndRestart = new Texture(Gdx.files.internal("data/homeAndRestart.png"));
		colorHighScore = new TextureRegion(colorHighScoreMap,0,0,480,700);
		colorHighScore.flip(false, true);
		home = new TextureRegion(homeAndRestart,0,0,60,60);
		restart = new TextureRegion(homeAndRestart, 60, 0, 60, 60);
		gameOverRed = new TextureRegion(colorGameOver,0,0,400,270);
		gameOverGreen = new TextureRegion(colorGameOver,0,400,400,270);
		gameOverYellow = new TextureRegion(colorGameOver,400,400,400,270);
		gameOverBlue = new TextureRegion(colorGameOver,400,0,400,270);
		gameOverRed.flip(false, true);
		gameOverGreen.flip(false, true);
		gameOverYellow.flip(false, true);
		gameOverBlue.flip(false, true);
		home.flip(false, true);
		restart.flip(false, true);
		
		redBackground = new TextureRegion(colorBackground,0,800,480,800);
		blueBackground = new TextureRegion(colorBackground,480,800,480,800);
		greenBackground = new TextureRegion(colorBackground,480,0,480,800);
		yellowBackground = new TextureRegion(colorBackground,0,0,480,800);
		menu = new TextureRegion(menuMap,0,0,480,800);
		menu.flip(false, true);
		playButton = new TextureRegion(playButtonMap,0,0,60,60);
		playButton.flip(false, true);
		highscoreButton = new TextureRegion(highscoreButtonMap,0,0,60,60);
		highscoreButton.flip(false, true);
		selectedRed = new TextureRegion(selectedCharacters,0,0,240,150);
		selectedRed.flip(false, true);
		selectedBlue = new TextureRegion(selectedCharacters,240,0,240,150);
		selectedBlue.flip(false, true);
		selectedGreen = new TextureRegion(selectedCharacters,0,150,240,150);
		selectedGreen.flip(false, true);
		selectedYellow = new TextureRegion(selectedCharacters,240,150,240,150);
		selectedYellow.flip(false, true);
		
		
		logo = new Texture(Gdx.files.internal("data/logoForGame.png"));
		
		
		font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        font.setScale(0.55f, -0.55f);
        smallFont = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        smallFont.setScale(0.4f, -0.4f);
        smallBigFont = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        smallBigFont.setScale(1f, -1f);
        bigFont = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        bigFont.setScale(2f, -2f);
        
		texture = new Texture(Gdx.files.internal("data/texturemap.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		
		
		mainRed = new TextureRegion(texture,0,0,50,50);
		mainRed.flip(false, true);
		
		mainBlue = new TextureRegion(texture,50,0,50,50);
		mainBlue.flip(false, true);
		
		mainGreen = new TextureRegion(texture,0,50,50,50);
		mainGreen.flip(false, true);
		
		mainYellow = new TextureRegion(texture,50,50,50,50);
		mainYellow.flip(false, true);
		
		
		mainRedDead = new TextureRegion(texture,150,0,50,50);
		mainRedDead.flip(false, true);
		
		mainBlueDead = new TextureRegion(texture,201,0,50,50);
		mainBlueDead.flip(false, true);
		
		mainGreenDead = new TextureRegion(texture,150,50,50,50);
		mainGreenDead.flip(false, true);
		
		mainYellowDead = new TextureRegion(texture,200,50,50,50);
		mainYellowDead.flip(false, true);
		
		deathSkull = new TextureRegion(texture,100,0,50,50);
		deathSkull.flip(false, true);
		
		silverTiles= new TextureRegion(texture,0,100,480,64);
		silverTiles.flip(false, true);
		
		tealTiles = new TextureRegion(texture,0,228,480,64);
		tealTiles.flip(false, true);
		
		redTiles = new TextureRegion(texture,0,356,480,64);
		redTiles.flip(false, true);
		
		purpleTiles = new TextureRegion(texture,0,484,480,64);
		purpleTiles.flip(false,true);
		
		greenTiles = new TextureRegion(texture, 0,612,480,64);
		greenTiles.flip(false, true);
		
		yellowTiles = new TextureRegion(texture,0,740,480,64);
		yellowTiles.flip(false, true);
		
		deathBarTop = new TextureRegion(texture,0,868,480,30);
		deathBarTop.flip(false, true);
		
		deathBarBottom = new TextureRegion(texture,0,868,480,30);
		deathBarBottom.flip(false, false);
		
		point = Gdx.audio.newSound(Gdx.files.internal("data/point.mp3"));
		brokenTile = Gdx.audio.newSound(Gdx.files.internal("data/tiledestruction.wav"));
		death = Gdx.audio.newSound(Gdx.files.internal("data/death.wav"));
		
		
		highScore = Gdx.app.getPreferences("Smash Or Death");
		if(!highScore.contains("highScoreRed"))
		{
			highScore.putInteger("highScoreRed",0);
		}
		if(!highScore.contains("highScoreGreen"))
		{
			highScore.putInteger("highScoreGreen",0);
		}
		if(!highScore.contains("highScoreBlue"))
		{
			highScore.putInteger("highScoreBlue",0);
		}
		if(!highScore.contains("highScoreYellow"))
		{
			highScore.putInteger("highScoreYellow",0);
		}
	}
	
	public static void setHighScore(int val, int mode)
	{
		switch(mode)
		{
		
		case 0:
			highScore.putInteger("highScoreRed", val);
			break;
		case 1:
			highScore.putInteger("highScoreBlue", val);
			break;
		case 2:
			highScore.putInteger("highScoreGreen", val);
			break;
		case 3:
			highScore.putInteger("highScoreYellow", val);
			break;
		}
		highScore.flush();
		
	}
	public static int getHighScore(int mode)
	{
		int score = 0;
		switch(mode)
		{
			case 0:
				score = highScore.getInteger("highScoreRed");
				break;
			case 1:
				score =  highScore.getInteger("highScoreBlue");
				break;
			case 2:
				score =highScore.getInteger("highScoreGreen");
				break;
			case 3:
				score = highScore.getInteger("highScoreYellow");
				break;
		}
		return score;
	}
	
	public static void dispose()
	{
		texture.dispose();
	}
}
