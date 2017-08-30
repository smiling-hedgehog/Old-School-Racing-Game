package com.osr.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer.Task;

public class StartGameTimer extends Task {

	public TextureAtlas num;
	public int i=0;
	public static TextureRegion[] index;
	public StartGameTimer(){
		num = new TextureAtlas(Gdx.files.internal("start.pack"));
		index = new TextureRegion[4];
		index[0] = num.findRegion("one");
		index[0].flip(false, true);
		index[1] = num.findRegion("two");
		index[1].flip(false, true);
		index[2] = num.findRegion("three");
		index[2].flip(false, true);
	}
	
	@Override
	public void run() {
		if(i<3)
		{
			i++;
		}
		
	}
	
	public TextureRegion getCount()
	{
		//Gdx.app.log("i ", Integer.toString(i));
		if(i>2)this.dispose();
		else return index[i];
		return null;
		}
	public void dispose()
	{
		num.dispose();
		
	}
}
