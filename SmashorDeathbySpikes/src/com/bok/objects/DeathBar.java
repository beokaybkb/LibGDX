package com.bok.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

//purpose of this is to make an object that can be used for collision detection with the maincharacter
//it is in a static position so it only needs position,width, and height
// different dimensions for rendering and collision
public class DeathBar 
{
	//rendering 
	private Vector2 position;
	private float width,height;
	// collision
	private float collisionPositionX, collisionPositionY, collisionWidth, collisionHeight;
	private Rectangle collision;
	
	
	public DeathBar(float gameWidth, float gameHeight,float positionX,float positionY)
	{
		//rendering initialized
		position = new Vector2(positionX,positionY);
		width = 480;
		height = 30;
		//collision initialized
		
		collisionPositionX = (positionX/480)*gameWidth;
		collisionPositionY = (positionY/800)*gameHeight;
		
		collisionWidth =  (width/480) * gameWidth;
		collisionHeight = (height/800) * gameHeight;
		
		collision = new Rectangle(collisionPositionX, collisionPositionY, collisionWidth, collisionHeight);
		
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
}
