package com.mygdx.game.MainGame.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Hammer extends Actor {
    private TextureAtlas hammerAtlas;
    private Animation<TextureRegion> animation;
    private float elapsedTime = 0;
    private float hammerX, hammerY;
    private boolean isclick;

    public Hammer() {

        hammerAtlas = new TextureAtlas((Gdx.files.internal("Hammer.pack")));
        animation = new Animation<TextureRegion>(0.01f, hammerAtlas.getRegions());
        setSize(hammerAtlas.getRegions().get(0).getRegionWidth(), hammerAtlas.getRegions().get(0).getRegionHeight());
        hammerX = 100;
        hammerY = 100;
        isclick = false;
    }

    public void setHammerX(float hammerX) {
        this.hammerX = hammerX;
    }

    public void setHammerY(float hammerY) {
        this.hammerY = hammerY;
    }

    public void setIsclick(boolean isclick) {
        this.isclick = isclick;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (isclick) {
            Music hammerMusic = Gdx.audio.newMusic(Gdx.files.internal("hammer.mp3"));
            hammerMusic.play();
            batch.draw(animation.getKeyFrame(elapsedTime, true), hammerX, hammerY);
            setPosition(hammerX, hammerY);
        }
    }

    @Override
    public void act(float delta) {
        if (isclick) {
            elapsedTime += delta;
        }
    }
}
