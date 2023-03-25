package com.mygdx.game.StartGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.MyGame;

public class StartScreen implements Screen {
    private MyGame myGame;
    private StartScreenBackground screenBackground;
    private Stage stage;

    public StartScreen(MyGame myGame) {
        this.myGame = myGame;
    }

    @Override
    public void show() {
        stage = new Stage();
        // stage.setDebugAll(true);
        screenBackground = new StartScreenBackground();
        screenBackground.setTouchable(Touchable.enabled);
        stage.addActor(screenBackground);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        stage.act();
        if (screenBackground.isClick()) {
            myGame.showMainScreen();
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
        screenBackground.setTouchable(Touchable.disabled);
        stage.clear();
        Gdx.input.setInputProcessor(null);
    }
}
