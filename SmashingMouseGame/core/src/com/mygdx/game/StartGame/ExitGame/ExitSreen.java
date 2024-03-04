package com.mygdx.game.StartGame.ExitGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.MyGame;
import com.mygdx.game.StartGame.ButtonActor;
import com.mygdx.game.StartGame.Detail.DetailBackground;

public class ExitSreen implements Screen{
    private MyGame myGame;
    private Stage stage;
    private DetailBackground exitBackground;
    private ButtonActor backButton;
    private ButtonActor yesButton;

    public ExitSreen(MyGame myGame){
        this.myGame = myGame;
    }
    @Override
    public void show() {
        stage = new Stage();
        // stage.setDebugAll(true);
        exitBackground = new DetailBackground("exit-background.png");
        exitBackground.setTouchable(Touchable.enabled);

        backButton = new ButtonActor("but_exit_game1.png","but_exit_game2.png",400, 50);
        backButton.setTouchable(Touchable.enabled);
        
        yesButton = new ButtonActor("but_yes1.png","but_yes2.png",240, 50);
        yesButton.setTouchable(Touchable.enabled);

        stage.addActor(exitBackground);
        stage.addActor(backButton);
        stage.addActor(yesButton);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        stage.act();
        if(backButton.isClick()){
            myGame.showStartScreen();
        }
        if(yesButton.isClick()){
            myGame.dispose();
            Gdx.app.exit();
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
