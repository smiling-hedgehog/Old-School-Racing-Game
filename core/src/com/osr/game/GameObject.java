package com.osr.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

//��� ������ �������
public class GameObject {
	public Road road;
	public HeroCar car;
	public Hurdle truck;
	public World world;
public GameObject()
{
	world = new World(new Vector2(0,10),true);
	road = new Road();
	car = new HeroCar(world);
	truck = new Hurdle(world);
	world.setContactListener(new CheckCollision());
}
	
	
	public void update()
	{
		road.update();
		truck.update();
	}
	
public HeroCar getCar()
{
	return car;
}
	
	
}
