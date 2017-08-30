package com.osr.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Timer;


public class GameRenderer {
	private SpriteBatch batch;
	private OrthographicCamera cam;
	private GameObject gWorld;
	private Timer time;
	private StartGameTimer st;
	Box2DDebugRenderer rend;
public GameRenderer(GameObject w)
{
	batch  = new SpriteBatch();
	cam = new OrthographicCamera();
	cam.setToOrtho(true, 250, 410);
	batch.setProjectionMatrix(cam.combined);
	gWorld = w;
	time = new Timer();
	st = new StartGameTimer();
	time.scheduleTask(st, 1,1);
	rend = new Box2DDebugRenderer();
}
	
	public void render()
	{
		cam.update();

        batch.begin();
        batch.disableBlending();
        batch.draw(assetsLoader.gameSprite.findRegion("road"),gWorld.road.getX(),gWorld.road.getY(),250,410);//Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(assetsLoader.gameSprite.findRegion("road"),gWorld.road.getX(),gWorld.road.getTailY(),250,410);//Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.enableBlending();
        batch.draw(assetsLoader.gameSprite.findRegion("car"),gWorld.car.getX(),gWorld.car.getY(),gWorld.car.getW(),gWorld.car.getH());
        batch.draw(gWorld.truck.getRegion(),gWorld.truck.getX(),gWorld.truck.getY(),gWorld.truck.getWidth(),gWorld.truck.getHeight());
		assetsLoader.font.draw(batch,Integer.toString(gWorld.truck.CountProgress),0,100,150,50,true);
        batch.end();
		gWorld.update();

		gWorld.world.step(Gdx.graphics.getDeltaTime(), 4, 4);
		rend.render(gWorld.world,cam.combined);
//		batch.begin();

	//	if(st.getCount()!=null)
	//	{
		//	world.road.setSpeed(0f);
//			batch.draw(st.getCount(),Gdx.graphics.getWidth()/6-30,Gdx.graphics.getHeight()/6-55,60,110);
//		}
//		else{ time.stop();time.clear();
////world.road.setSpeed(10f);
////Gdx.app.log("speed",Float.toString(world.road.getSpeed()));
//		}
//
//		batch.end();

    }
	
public void dispose()
{
batch.dispose();

}
}
