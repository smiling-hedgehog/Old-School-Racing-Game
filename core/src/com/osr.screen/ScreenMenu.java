package com.osr.screen;


        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.Screen;
        import com.badlogic.gdx.audio.Sound;
        import com.badlogic.gdx.graphics.GL20;
        import com.badlogic.gdx.graphics.g2d.TextureAtlas;
        import com.badlogic.gdx.scenes.scene2d.InputEvent;
        import com.badlogic.gdx.scenes.scene2d.Stage;
        import com.badlogic.gdx.scenes.scene2d.ui.Image;
        import com.badlogic.gdx.scenes.scene2d.ui.Label;
        import com.badlogic.gdx.scenes.scene2d.ui.Skin;
        import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
        import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
        import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
        import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
        import com.badlogic.gdx.utils.viewport.ScreenViewport;
        import com.osr.game.Arrow;
        import com.osr.game.SelectScreen;
        import com.osr.game.assetsLoader;


public class ScreenMenu implements Screen{

    private SelectScreen game;
    private Skin skin;
    private Stage stage;
    private TextButtonStyle txtBtnStyle,sound_btn_style,score_btn_style;;
    private TextButton start,score_btn,sound_btn;

    private Image bg,board;
    private Arrow ar;
   // private Label lbl;
    private LabelStyle lblStyle;

    public ScreenMenu(final SelectScreen game)
    {
        this.game = game;
        skin = new Skin();
        stage = new Stage(new ScreenViewport());

        skin.addRegions(assetsLoader.menuSprite);
        ar = new Arrow(skin.getSprite("arrow"));

        ////Label/////
       // lblStyle = new LabelStyle();
        //lblStyle.font = assetsLoader.font;
        //lbl = new Label("OLD SCHOOL RACING GAMES",lblStyle);
        //lbl.setPosition((Gdx.graphics.getWidth()/2-lbl.getWidth()/2),(Gdx.graphics.getHeight()/1.2f));


        ///backgroung//
        bg = new Image(skin.getDrawable("bg"));
        bg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //SpeedBoard
        board = new Image(skin.getDrawable("speedboard"));
        board.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()-80);
        ///Button
        txtBtnStyle = new TextButtonStyle();
        txtBtnStyle.font = assetsLoader.font;
        txtBtnStyle.up = skin.getDrawable("es_up");
        txtBtnStyle.down = skin.getDrawable("es_down");
        txtBtnStyle.checked = skin.getDrawable("es_up");
        Gdx.input.setInputProcessor(stage);
        start = new TextButton("",txtBtnStyle);
        start.setSize(140, 140);
        start.setPosition(Gdx.graphics.getWidth()-start.getWidth(),start.getWidth()-(Gdx.graphics.getHeight()/2)+start.getHeight()/2);

        //Button Score
        score_btn_style = new TextButtonStyle();
        score_btn_style.font = assetsLoader.font;
        score_btn_style.up = skin.getDrawable("score_up");
        score_btn_style.down = skin.getDrawable("score_down");
        score_btn_style.checked = skin.getDrawable("score_up");
        score_btn = new TextButton("",score_btn_style);
        score_btn.setSize(150,150);
        score_btn.setPosition(30, 82);//to do fix


        //Button Sound
        sound_btn_style = new TextButtonStyle();
        sound_btn_style.font = assetsLoader.font;
        sound_btn_style.up = skin.getDrawable("sound_on");
        sound_btn_style.down = skin.getDrawable("sound_off");
        sound_btn_style.checked = skin.getDrawable("sound_on");
        sound_btn = new TextButton("",sound_btn_style);
        sound_btn.setSize(150,150);
        sound_btn.setPosition(214, 6);//to do fix


        ///Add Actor
        stage.addActor(bg);
       // stage.addActor(lbl);
        stage.addActor(board);
        stage.addActor(ar);
        stage.addActor(start);
        stage.addActor(score_btn);
        stage.addActor(sound_btn);
        ///Click Event
        start.addListener(new ClickListener(){

            public void touchUp(InputEvent event, float x, float y,int pointer, int button){

                ar.SPEED = true;
               assetsLoader.engineBugatti.play();
                dispose();
            }
        });

    }
    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(1,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(ar.isSpeedAnim())//if is end animation
        {
            stage.dispose();


            game.setScreen(new ScreenGame());
           assetsLoader.engineBugatti.stop();

        }
        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {


    }

    @Override
    public void dispose() {
       // EngineSound.dispose();

    }

}

