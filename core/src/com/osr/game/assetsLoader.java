package com.osr.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;


public class assetsLoader {
	public static TextureAtlas menuSprite,gameSprite;
	public static Texture testRoad,testCar;
	public static TextureRegion TestCarReg;
	public static Sound engineBugatti,drift,bums;
	public static BitmapFont font;
	public static void load()
	{
		menuSprite = new TextureAtlas(Gdx.files.internal("menuPack.pack"));
		engineBugatti = Gdx.audio.newSound(Gdx.files.internal("Zv8.mp3"));

        bums = Gdx.audio.newSound(Gdx.files.internal("bums.mp3"));
		font = new BitmapFont();
		gameSprite = new TextureAtlas(Gdx.files.internal("cars.pack"));
		gameSprite.findRegion("car").flip(false, true);
		
		 FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("AGENCYR.TTF"));
	     FreeTypeFontParameter param = new FreeTypeFontParameter();
	     param.size = Gdx.graphics.getHeight() / 18;
		param.flip = true;
	     font = generator.generateFont(param); // 
	     generator.dispose(); // ���������� ��� ��������� �� �������������.
		
	}
	
	public static void dispose()
	{
		
		
		menuSprite.dispose();
		font.dispose();
		engineBugatti.dispose();
	gameSprite.dispose();
	}

}
