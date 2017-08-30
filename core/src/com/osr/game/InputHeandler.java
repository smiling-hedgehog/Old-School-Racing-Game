package com.osr.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputHeandler implements InputProcessor  {
	public HeroCar car;
public InputHeandler(HeroCar car)
{
	this.car = car;
}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {


		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub

		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		car.onClick(screenX,screenY);

		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
