package com.bok.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bok.helpers.AssetLoaders;

public class MainCharacter 
{
	//What does the Main Character need?
	// It needs position, width, is it alive
	// update it's position
	// need seperate values for collision detection
	
	private Vector2 position, gravity,gravityDeath,stop;
	private float gameWidth, gameHeight;
	private float width,height;
	private float collisionX, collisionY, collisionWidth, collisionHeight;
	private Rectangle collision;
	// TO DO
	//this deals with Death
	private boolean dead,hitGround;
	private float rotation;
	
	
	public MainCharacter(float gameWidth, float gameHeight)
	{
		hitGround = false;
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		rotation = 0;
		width = 50;
		height = 50;
		stop = new Vector2(0,0);
		position = new Vector2(206,200);
		gravity = new Vector2(0,1300);
		gravityDeath = new Vector2(0,600);
		
		// seperate values for collision
		collisionX = (position.x/480) * gameWidth;
		collisionY = (position.y/800) * gameHeight;
		collisionWidth = (width/480) * gameWidth;
		collisionHeight = (height/800) * gameHeight;
		
		collision = new Rectangle(collisionX, collisionY, collisionWidth, collisionHeight);
		
		// it's not dead at first
		dead = false; 
		
		
	}
	
	public void update(float delta)
	{
		if(dead == false)
		{
		// this is gravity
		position.add(gravity.cpy().scl(delta));
		
		// updating collisionY
		collision.y =(position.y/800) * gameHeight;
		}else
		{
			if(position.y + height <800)
			{
			changeSpeed(gravityDeath);
			position.add(gravity.cpy().scl(delta));
			rotation += 1000 *delta;
			}
			else
			{
				hitGround = true;
			}
		}
		
	}
	public void retry()
	{
		dead = false;
		hitGround = false;
		rotation = 0;
		position.y = 200;
		gravity.y = 1300;
	}
	public void dead()
	{
		AssetLoaders.death.play();
		dead = true;
	}
	
	public void changeSpeed(Vector2 pushBarSpeed)
	{
		gravity.set(pushBarSpeed);
	}
	public Vector2 getPosition() {
		return position;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public Rectangle getCollision() {
		return collision;
	}

	public Vector2 getGravity() {
		return gravity;
	}

	public boolean isDead() {
		return dead;
	}

	public float getRotation() {
		return rotation;
	}

	public void setPositionY(float newPositionY) {
		position.y = newPositionY;
	}

	public boolean isHitGround() {
		return hitGround;
	}

	public void setHitGround(boolean hitGround) {
		this.hitGround = hitGround;
	}
	
	
}
