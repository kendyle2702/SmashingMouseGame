package com.mygdx.game.MainGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameArea extends Actor {
    private Texture gameArea;
    private float gameAreaX, gameAreaY;

    public GameArea() {
        gameArea = new Texture(Gdx.files.internal("game_area.png"));
        gameAreaX = Gdx.graphics.getWidth() / 2 - gameArea.getWidth() / 2;
        gameAreaY = Gdx.graphics.getHeight() / 2 - gameArea.getHeight() / 2 - 50;
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(gameArea, gameAreaX, gameAreaY);
    }
}
