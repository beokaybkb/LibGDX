package com.bok.objects;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bok.updaters.GameWorld;

public class PushUpBarMathProblems 
{
	//Purpose: PushUpBar will go up and when it disappears from the screen, it'll rest and go to the back of the PushUpBar at the end
	//0123
	//0 at the end of 3
	//1 at the end of 0
	//2 at the end of 1
	//3 at the end of 2
	//Generate Math problems
	// if this generated math problem is solved, then it'll tween disappear
	
	// rendering dimension
	private Vector2 position,gravityUp;
	private float width,height;
	private final float SPEEDGRAVITY = -400;
	//collision dimension synchronize with rendering dimension
	private float collisionPositionX, collisionPositionY;
	private float collisionWidth, collisionHeight;
	private float gameHeight;
	private Random random;
	private Rectangle collision;
	private boolean playPoint,smashed;
	private int hit = 0;
	private int HP;
	private int tileColor,number;
	
	public PushUpBarMathProblems(float gameWidth, float gameHeight, int number)
	{
		random = new Random();
		this.number = number;
		switch(GameWorld.gameNumber)
		{
		case 0:
			if(number == 0)
			{
				position = new Vector2(0,450);
			}
			if(number>0)
			{
				position = new Vector2(0,800+(number-1)*400+random.nextInt(200));
			}
			gravityUp = new Vector2(0, SPEEDGRAVITY);
			HP = 1+random.nextInt(9);
			if(number == 0)
			{
				HP = 1+random.nextInt(3);
			}
			break;
		case 1:
			if(number == 0)
			{
				position = new Vector2(0,450);
			}
			if(number>0)
			{
				position = new Vector2(0,800+(number-1)*400+random.nextInt(200));
			}
			gravityUp = new Vector2(0, SPEEDGRAVITY);
			HP = 1+random.nextInt(9);
			if(number == 0)
			{
				HP = 1+random.nextInt(3);
			}
			break;
		case 2:
			if(number == 0)
			{
				position = new Vector2(0,755);
			}
			if(number>0)
			{
				position = new Vector2(0,800+number*300);
			}
			gravityUp = new Vector2(0, -40);
			HP = 100;
			break;
		case 3:
			if(number == 0)
			{
				position = new Vector2(0,450);
			}
			if(number>0)
			{
				position = new Vector2(0,800+(number-1)*450);
			}
			gravityUp = new Vector2(0, -1300);
			HP = 1;
			break;
		}
		
		smashed = false;
		
		tileColor = random.nextInt(6);
		
		
		width = 480;
		height = 60.0f;
		
		
		
		
		// collision initializing
		collisionPositionX = (position.x/480)*gameWidth;
		collisionPositionY = (position.y/800)*gameHeight;
		collisionWidth = (width/480)*gameWidth;
		collisionHeight = (height/800)*gameHeight;
		playPoint = false;
		this.gameHeight = gameHeight;
		
		collision = new Rectangle(collisionPositionX, collisionPositionY, collisionWidth,collisionHeight);
		
	}
	public void changeSpeed(int factor)
	{
		switch(GameWorld.gameNumber)
		{
			
		case 0:
			gravityUp.y = SPEEDGRAVITY-factor*10;
			if(gravityUp.y<-500)
			{
				gravityUp.y = -500;
			}
			break;
		case 1:
			gravityUp.y = factor;
			break;
		}
	}
	public void update(float delta)
	{
		// update render values
		position.add(gravityUp.cpy().scl(delta));
		//update collision values
		collision.y= (position.y/800)*gameHeight;
	}
	public void retry()
	{
		switch(GameWorld.gameNumber)
		{
		case 0:
		case 1:
			if(number == 0)
			{
				position.y =450;
			}
			if(number>0)
			{
				position.y = 800+(number-1)*400+random.nextInt(200);
			}
			gravityUp.y = SPEEDGRAVITY;
			HP = 1+random.nextInt(9);
			if(number == 0)
			{
				HP = 1+random.nextInt(3);
			}
			hit = 0;
			break;
		case 2:
			if(number == 0)
			{
				position.y =760;
			}
			if(number>0)
			{
				position.y = 800+number*300;
			}
			gravityUp.y = -40;
			HP = 100;
			hit = 0;
			break;
		case 3:
			if(number == 0)
			{
				position.y =450;
			}
			if(number>0)
			{
				position.y = 800+(number-1)*400+random.nextInt(200);
			}
			gravityUp.y = -1300;
			HP = 1;
			hit = 0;
			break;
		}
		smashed = false;
		playPoint = false;
	}
	public void resetHP()
	{
		switch(GameWorld.gameNumber)
		{
		case 0:
			HP = 1+random.nextInt(9);
			break;
		case 1:
			HP = 1+random.nextInt(9);
			break;
		case 2:
			HP = 100;
			break;
		case 3:
			HP = 1;
			break;
		}
		
	}
	public void resetColor()
	{
		tileColor = random.nextInt(6);
	}
	public void changePositionY(PushUpBarMathProblems pubmpEnd)
	{
		int gap = random.nextInt(500);
		switch(GameWorld.gameNumber)
		{
		case 0:
		case 1:
		case 3:
			if(gap<250)
			{
				gap=250+random.nextInt(300);
			}
			position.y = pubmpEnd.position.y + pubmpEnd.height + gap;
			break;
		case 2:
			gap = 240;
			position.y = pubmpEnd.position.y + pubmpEnd.height + gap;
			break;
		}
	}

	public Vector2 getPosition() {
		return position;
	}


	public Rectangle getCollision() {
		return collision;
	}

	public Vector2 getGravityUp() {
		return gravityUp;
	}

	public boolean isPlayPoint() {
		return playPoint;
	}


	public void setPlayPoint(boolean playPoint) {
		this.playPoint = playPoint;
	}


	public boolean isSmashed() {
		return smashed;
	}


	public void setSmashed(boolean smashed) {
		this.smashed = smashed;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public int getHP() {
		return HP;
	}


	public void setHP(int hP) {
		HP = hP;
	}


	public int getTileColor() {
		return tileColor;
	}
	public int getNumber() {
		return number;
	}
}
