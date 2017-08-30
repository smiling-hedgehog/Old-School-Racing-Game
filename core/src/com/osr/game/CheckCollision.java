package com.osr.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class CheckCollision implements ContactListener {
public static boolean isOverlap = true;
	public static int CountCollision = 0;
	@Override
	public void beginContact(Contact contact) {

		Gdx.app.log("overlap","collision detected");
		//Road.setSpeed(0);
		CountCollision++;

		isOverlap = false;
		Road.speed.SpeedReset(280.2f,10,0);
		if(CountCollision>=3)
		{
			//Road.speed.stopSpeed();
		}
	}

	@Override
	public void endContact(Contact contact) {
		Gdx.app.log("overlap","end collision");
		//Road.setSpeed(10);
		assetsLoader.bums.stop();

		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {

		assetsLoader.bums.play();
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {

	}
public static boolean getOverlap()
{
return isOverlap;	
}
public static void setOverlap(boolean flag)
{ isOverlap = flag;}

}
