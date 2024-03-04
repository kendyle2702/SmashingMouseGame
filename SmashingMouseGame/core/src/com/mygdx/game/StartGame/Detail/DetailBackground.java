package com.mygdx.game.StartGame.Detail;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class DetailBackground extends Actor{
    private Texture background;
    private Texture detail;

    public DetailBackground(String pathDetail){
        background = new Texture(Gdx.files.internal("detail_box.png"));
        detail = new Texture(Gdx.files.internal(pathDetail));
    }


    @Override
    public void act(float delta) {

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(background, Gdx.graphics.getWidth() / 2 - background.getWidth() / 2,
                Gdx.graphics.getWidth() / 2 - background.getWidth() / 2);
        batch.draw(detail, Gdx.graphics.getWidth() / 2 - detail.getWidth() / 2,
                Gdx.graphics.getWidth() / 2 - detail.getWidth() / 2 + 50);
    }
}
