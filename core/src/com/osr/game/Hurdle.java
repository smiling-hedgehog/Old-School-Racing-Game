package com.osr.game;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Hurdle {

    HashMap<Integer,TextureRegion> truck;
    World world;
    Body bodyTruck;
    BodyDef def;
    FixtureDef fdef;
    PolygonShape virtTruck;
    TextureAtlas img_truck;

    Vector2 posTruck;
    int NumTruck;
    public int CountProgress = 0;
    public Hurdle(World w){
        NumTruck = 2;

        world = w;
        virtTruck = new PolygonShape();
        def = new BodyDef();
        fdef = new FixtureDef();
        posTruck = new Vector2(0,0);
        truck = new HashMap<Integer,TextureRegion>();
        truck.put(0,assetsLoader.gameSprite.findRegion("track1"));
        truck.put(1,assetsLoader.gameSprite.findRegion("track2"));
        truck.put(2,assetsLoader.gameSprite.findRegion("track3"));
        truck.put(3,assetsLoader.gameSprite.findRegion("track4"));
        truck.put(4,assetsLoader.gameSprite.findRegion("track5"));
        truck.put(5,assetsLoader.gameSprite.findRegion("track6"));
        truck.put(6,assetsLoader.gameSprite.findRegion("track7"));
        CreateBody();
    }


    public void CreateBody()
    {
        NumTruck = MathUtils.random(0,6);

        def.position.set(posTruck.x, posTruck.y);
        def.type = BodyType.KinematicBody;
        bodyTruck = world.createBody(def);
        virtTruck.setAsBox(truck.get(NumTruck).getRegionWidth()/2,truck.get(NumTruck).getRegionHeight()/2);
        fdef.shape=virtTruck;
        bodyTruck.createFixture(fdef);
        bodyTruck.setGravityScale(20);
        CheckCollision.setOverlap(true);

    }

    public void update()
    {
//Gdx.app.log("posY ",Float.toString(posTruck.y));
        if(posTruck.y>700)
        {
          if(CheckCollision.getOverlap())
         {

               CountProgress++;
           }

            posTruck.y = -200;
            posTruck.x = MathUtils.random(33,181);
            CreateBody();
        }
        else{
            posTruck.add(0, Road.getSpeed());
            bodyTruck.setTransform(posTruck.x, posTruck.y,0);

        }

    }
    public float getX(){return bodyTruck.getPosition().x - truck.get(NumTruck).getRegionWidth()/2;}
    public float getY(){return bodyTruck.getPosition().y - truck.get(NumTruck).getRegionHeight()/2;}
    public float getWidth(){return truck.get(NumTruck).getRegionWidth();}
    public float getHeight(){return truck.get(NumTruck).getRegionHeight();}
    public TextureRegion getRegion(){
        return truck.get(NumTruck);}
    public int getProgress()
    {
        return CountProgress;
    }
}

