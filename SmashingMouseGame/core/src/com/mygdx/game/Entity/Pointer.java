package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Pointer extends Actor {
    private int point;
    private BitmapFont font;

    public Pointer(int point) {
        this.point = point;
        font = new BitmapFont();

    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.getData().setScale(1.5f);
        font.setColor(Color.ORANGE);
        font.draw(batch, "Score: " + point, 400, 400);
    }

    @Override
    public void act(float delta) {

    }

}
