package com.mygdx.game.StartGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class StartScreenBackground extends Actor {
    private Texture background;

    public StartScreenBackground() {
        background = new Texture(Gdx.files.internal("start.jpg"));
        setBounds(500 , 500, 1, 1);
        
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(background, Gdx.graphics.getWidth() / 2 - background.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - background.getHeight() / 2);
    }

    @Override
    public void act(float delta) {
        
    }
}
