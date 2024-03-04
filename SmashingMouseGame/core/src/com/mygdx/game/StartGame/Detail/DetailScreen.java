package com.mygdx.game.StartGame.Detail;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.MyGame;
import com.mygdx.game.StartGame.ButtonActor;

public class DetailScreen implements Screen{
    private MyGame myGame;
    private Stage stage;
    private DetailBackground detailBackground;
    private ButtonActor backButton;

    public DetailScreen(MyGame myGame){
        this.myGame = myGame;
    }


    @Override
    public void show() {
        stage = new Stage();
        // stage.setDebugAll(true);

        detailBackground = new DetailBackground("detail_about2.png");
        detailBackground.setTouchable(Touchable.enabled);

        backButton = new ButtonActor("but_restart1.png","but_restart2.png",310, 50);
        backButton.setTouchable(Touchable.enabled);

        stage.addActor(detailBackground);
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
        stage.dispose();
    }
}
