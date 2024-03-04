package com.mygdx.game.MainGame.Entity;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CountdownTime extends Actor {
    private BitmapFont font;
    private float timeRemaining;
    private boolean timeUp = false;

    public CountdownTime(float totalTime) {
        this.font = new BitmapFont();
        font.getData().setScale(1.5f);
        font.setColor(Color.ORANGE);
        this.timeRemaining = totalTime;
    }

    @Override
    public void act(float delta) {
        timeRemaining -= delta;
        if (timeRemaining <= 0) {
            timeUp = true;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        
        font.draw(batch, String.format("Time: 00:%02d", (int) timeRemaining), 150, 430);
    }

    public boolean isTimeUp() {
        return timeUp;
    }

}
