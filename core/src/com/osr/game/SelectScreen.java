package com.osr.game;


        import com.badlogic.gdx.Game;

        import com.osr.screen.ScreenMenu;


public class SelectScreen extends Game{

    @Override
    public void create() {
        assetsLoader.load();
        this.setScreen(new ScreenMenu(this));

    }
    public void render(){
        super.render();
    }

    public void dispose()
    {
        assetsLoader.dispose();
    }
}
