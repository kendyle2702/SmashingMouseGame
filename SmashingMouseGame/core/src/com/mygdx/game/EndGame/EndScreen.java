package com.mygdx.game.EndGame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.MyGame;
import com.mygdx.game.StartGame.ButtonActor;

public class EndScreen implements Screen {
    private MyGame myGame;
    private Stage stage;
    private EndScreenBackground endScreenBackground;
    private ButtonActor buttonHome;
    private int point;

    public EndScreen(MyGame myGame) {
        this.myGame = myGame;
    }
  
   
    @Override
    public void show() {
        stage = new Stage();
        // stage.setDebugAll(true);
        if(myGame.getMaxPoint() < point){
            myGame.setMaxPoint(point);
        }
        Music gameOver = Gdx.audio.newMusic(Gdx.files.internal("game_over.mp3"));
        gameOver.play();
        
        endScreenBackground = new EndScreenBackground(point);
        endScreenBackground.setTouchable(Touchable.enabled);
        
        buttonHome = new ButtonActor("but_home1.png","but_home2.png",Gdx.graphics.getWidth() / 2 - 100, 150);
        buttonHome.setTouchable(Touchable.enabled);

        stage.addActor(endScreenBackground);
        stage.addActor(buttonHome);
        Gdx.input.setInputProcessor(stage);
        
        System.out.println(myGame.getUsername() + " " + point);
    }

    public void setPoint(int point) {
        System.out.println("So diem: " + point);
        this.point = point;
    }

    @Override
    public void render(float delta) {
        stage.act();
        if (endScreenBackground.isClick()) {
            myGame.showMainScreen();
        }
        if (buttonHome.isClick()) {
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
