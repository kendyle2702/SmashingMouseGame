package com.mygdx.game.StartGame.HowToPlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.MyGame;
import com.mygdx.game.StartGame.ButtonActor;
import com.mygdx.game.StartGame.Detail.DetailBackground;

public class HowToPlayScreen implements Screen{
    private MyGame myGame;
    private Stage stage;
    private DetailBackground howToPlayBackground;
    private ButtonActor backButton;

    public HowToPlayScreen(MyGame myGame){
        this.myGame = myGame;
    }

    @Override
    public void show() {
        stage = new Stage();
        // stage.setDebugAll(true);
        howToPlayBackground = new DetailBackground("howtoplay1.png");
        howToPlayBackground.setTouchable(Touchable.enabled);

        backButton = new ButtonActor("but_restart1.png","but_restart2.png",310, 50);
        backButton.setTouchable(Touchable.enabled);
       
        stage.addActor(howToPlayBackground);
        stage.addActor(backButton);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        stage.act();
        if(backButton.isClick()){
            myGame.showStartScreen();
        }
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
    
}
