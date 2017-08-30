package com.osr.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Road {
public Vector2 RoadPosition;
	public static float SPEED = 10;
	public static SpeedControl speed;
public Road()
{
	RoadPosition = new Vector2(0,0);
	speed = new SpeedControl();
	speed.SpeedReset(280.2f,10,0);
}
	public void update(){

		speed.updateSpeed();
		RoadPosition.add(0,speed.getSpeed());
		if(RoadPosition.y>410)
		{
			RoadPosition.y = 0;
		}
	
		
	}
	
public float getX(){return RoadPosition.x;}
public float getY(){return RoadPosition.y;}
public float getTailY(){return RoadPosition.y-410;}
	public static float getSpeed()
	{
		return SPEED;
	}
	public static void setSpeed(float s)
	{
		SPEED = s;
	}
}
