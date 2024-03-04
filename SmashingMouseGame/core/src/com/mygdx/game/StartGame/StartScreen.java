package com.mygdx.game.StartGame;


import java.util.Collections;
import java.util.Comparator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.MyGame;
import com.mygdx.game.User;

public class StartScreen implements Screen {
    private MyGame myGame;
    private Rank rank;
    private StartScreenBackground screenBackground;
    private ButtonActor detailActor;
    private ButtonActor howToPlayActor;
    private ButtonActor startActor;
    private ButtonActor exitActor;
    private Stage stage;
    private User userTop1,userTop2,userTop3;

    public StartScreen(MyGame myGame) {
        this.myGame = myGame;
    }

    public void findRank(){
        Collections.sort(myGame.getUserList(), new Comparator<User>(){
            @Override
            public int compare(User o1, User o2) {
                if(o1.getPoint() < o2.getPoint()){
                    return 1;
                }
                else if(o1.getPoint() > o2.getPoint()){
                    return -1;
                }
                else{
                    if(o1.getUsername().compareToIgnoreCase(o2.getUsername()) > 0){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
            }
        });
        userTop1 = myGame.getUserList().get(0);
        userTop2 = myGame.getUserList().get(1);
        userTop3 = myGame.getUserList().get(2);
    }

    @Override
    public void show() {
        stage = new Stage();
        // stage.setDebugAll(true);

        rank = new Rank();

        findRank();

        rank.setTopUser(userTop1, userTop2, userTop3);

        screenBackground = new StartScreenBackground();

        detailActor = new ButtonActor("but_detail1.png", "but_detail2.png",Gdx.graphics.getWidth() / 2 - 150, 120);
        detailActor.setTouchable(Touchable.enabled);

        howToPlayActor = new ButtonActor("but_home1.png", "but_home2.png", Gdx.graphics.getWidth() / 2 + 150, 120);
        howToPlayActor.setTouchable(Touchable.enabled);

        startActor = new ButtonActor("but_start_game1.png", "but_start_game2.png",Gdx.graphics.getWidth() / 2, 120);
        startActor.setTouchable(Touchable.enabled);

        exitActor = new ButtonActor("but_exit_game1.png", "but_exit_game2.png", Gdx.graphics.getWidth() / 2, 10);
        exitActor.setTouchable(Touchable.enabled);

        stage.addActor(screenBackground);
        stage.addActor(startActor);
        stage.addActor(exitActor);
        stage.addActor(detailActor);
        stage.addActor(howToPlayActor);
        stage.addActor(rank);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        stage.act();
        if (startActor.isClick()) {
            if(myGame.getUsername() != null){
                myGame.showMainScreen();
            }
            else{
                myGame.showInputScreen();
            }
        }
        if(detailActor.isClick()){
            myGame.showDetailScreen();
        }
        if(howToPlayActor.isClick()){
            myGame.showHowToPlayScreen();
        }
        if(exitActor.isClick()){
            myGame.showExitScreen();
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
        detailActor.setTouchable(Touchable.disabled);
        stage.dispose();
        Gdx.input.setInputProcessor(null);
    }
}
