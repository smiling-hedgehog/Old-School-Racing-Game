package com.osr.game;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class SpeedControl {
public float SPEED;
public TweenManager manager;
public SpeedControl()
{
	manager = new TweenManager();
	Tween.registerAccessor(SpeedControl.class, new SpeedAccessor());
	
}
	public float getSpeed() {
	
		return SPEED;
	}

	public void setSpeed(float f) {
		SPEED = f;
		
	}
public void SpeedReset(float time,int end,int begin)
{
SPEED = 0;

	Tween.to(this, SpeedAccessor.SPEED, time) .target(end, begin)//delay(0.2f).repeatYoyo(1, 0.5f)) 
	.start(manager); 

}
public void updateSpeed()
{
	manager.update(1);
	}

public void stopSpeed()
{
manager.pause();

}
public void resumeSpeed()
{
manager.resume();	
}
}
