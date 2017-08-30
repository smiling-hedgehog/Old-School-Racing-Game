package com.osr.screen;


        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.Screen;
        import com.badlogic.gdx.graphics.GL20;
        import com.osr.game.GameObject;
        import com.osr.game.GameRenderer;
        import com.osr.game.InputHeandler;
        import com.osr.game.Road;


public class ScreenGame implements Screen{


    public GameObject world;
    public GameRenderer rend;

    public ScreenGame()
    {

        world = new GameObject();
        rend = new GameRenderer(world);
        Gdx.input.setInputProcessor(new InputHeandler(world.getCar()));
        Gdx.app.log("SCREENSIZE ",Float.toString(Gdx.graphics.getWidth()));
        Gdx.app.log("SCREENSIZE ",Float.toString(Gdx.graphics.getHeight()));
    }
    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(1,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.update();
        rend.render();

    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
       Road.setSpeed(0);

    }

    @Override
    public void resume() {
Road.setSpeed(10);

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

}
