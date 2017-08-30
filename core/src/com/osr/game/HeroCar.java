package com.osr.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class HeroCar {
	World world;
	Body bodyCar;
	BodyDef def;
	FixtureDef fDef;
	PolygonShape shape;
	public Vector2 posXY;
	float width,height;
	public HeroCar(World w)
	{
		world = w;
		posXY = new Vector2();
		posXY.y = 130;
		posXY.x = 125;
		width = 34;
		height = 57;
		shape = new PolygonShape();
		shape.setAsBox(width/2,height/2);

		def = new BodyDef();
		def.position.set(posXY.x+width/2,posXY.y+height/2);
		def.type = BodyType.DynamicBody;
		bodyCar = world.createBody(def);

		fDef = new FixtureDef();


		fDef.shape = shape;
		bodyCar.createFixture(fDef);
	}

	public void onClick(int x,int y)
	{

		bodyCar.setTransform(x, 160, 0);

		if(bodyCar.getPosition().x>195)
		{
			bodyCar.setTransform(195, 130, 0);

		}else if(bodyCar.getPosition().x<48)
		{

			bodyCar.setTransform(48, 130, 10);
		}
		bodyCar.setTransform(bodyCar.getPosition().x,130,0);

	}
	public float getX(){return bodyCar.getPosition().x-width/2;} //posXY.x;}
	public float getY(){
		bodyCar.setTransform(bodyCar.getPosition().x, 340,0);
		return bodyCar.getPosition().y-height/2;}//posXY.y;}
	public float getW(){return width;}
	public float getH(){return height;}

}
