package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.EndGame.EndScreen;
import com.mygdx.game.MainGame.MainScreen;
import com.mygdx.game.StartGame.StartScreen;

public class MyGame extends Game {
    private Screen startScreen;
    private Screen mainScreen;
    private Screen endScreen;
    private Music music;
    
    @Override
    public void create() {
        startScreen = new StartScreen(this);
        mainScreen = new MainScreen(this);
        endScreen = new EndScreen(this);
        music = Gdx.audio.newMusic(Gdx.files.internal("soundtrack.mp3"));
        music.setLooping(true);
        music.play();
        setScreen(startScreen);
    }

    public void showMainScreen() {
        setScreen(mainScreen);
    }
    
    public void showEndScreen(int point) {
        ((EndScreen) endScreen).setPoint(point);
        setScreen(endScreen);
    }

    public void showStartScreen() {
        setScreen(startScreen);
    }
}
