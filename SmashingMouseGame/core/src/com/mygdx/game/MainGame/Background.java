package com.mygdx.game.MainGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor {
    private Texture backGround;
    private float backGroundX, backGroundY;

    public Background() {
        backGround = new Texture(Gdx.files.internal("main.jpg"));
        backGroundX = Gdx.graphics.getWidth() / 2 - backGround.getWidth() / 2;
        backGroundY = Gdx.graphics.getHeight() / 2 - backGround.getHeight() / 2;
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(backGround, backGroundX, backGroundY);
    }
}
