package com.osr.game;


        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.graphics.g2d.Batch;
        import com.badlogic.gdx.graphics.g2d.TextureRegion;
        import com.badlogic.gdx.scenes.scene2d.Actor;

public class Arrow extends Actor {
    TextureRegion arrowRegion;
    public boolean SPEED = false;
    public static float Pos = 140f;

    public Arrow(TextureRegion x){

        arrowRegion  = new TextureRegion();
        arrowRegion = x;
    }
    @Override
    public void draw(Batch batch,float beta)
    {
        batch.draw(arrowRegion,Gdx.graphics.getWidth()/2-22,Gdx.graphics.getWidth()/2+24,22f,22f,44f,102f,1.0f,1.0f,Pos);
    }
    @Override
    public void act(float time)
    {
        if(SPEED){
            Pos-=1f;

            if(Pos<-65f)
            {Pos =-65f;
            }
        }
    }
    public boolean isSpeedAnim()
    {
        if(Pos<-60f)
        {
            return true;
        }
        else return false;

    }
    public void dispose()
    {


    }
}