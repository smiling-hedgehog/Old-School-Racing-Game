package com.osr.game;

import aurelienribon.tweenengine.TweenAccessor;

public class SpeedAccessor implements TweenAccessor<SpeedControl> {
public static final int SPEED = 1;
	@Override
	public int getValues(SpeedControl arg0, int arg1, float[] arg2) {
		switch(arg1){
		
		case SPEED:
		arg2[0] = arg0.getSpeed();
			return 1;
			default:
				return 0;
		}
	}

	@Override
	public void setValues(SpeedControl arg0, int arg1, float[] arg2) {
		switch(arg1){
		
		case SPEED:
			arg0.setSpeed(arg2[0]);
			break;
		}
		
	}

}
