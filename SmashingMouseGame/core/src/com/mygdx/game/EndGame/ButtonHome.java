package com.mygdx.game.EndGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ButtonHome extends Actor {
    private Texture buttonHome1, buttonHome2;
    private boolean isClick = false;

    public ButtonHome() {
        buttonHome1 = new Texture(Gdx.files.internal("but_home1.png"));
        buttonHome2 = new Texture(Gdx.files.internal("but_home2.png"));
        setBounds(Gdx.graphics.getWidth() / 2 - buttonHome1.getWidth() - 50, 150, buttonHome1.getWidth(),
                buttonHome1.getHeight());
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Music click = Gdx.audio.newMusic(Gdx.files.internal("click.mp3"));
                click.play();
                buttonHome1 = buttonHome2;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isClick = true;
            }
        });
    }

    public boolean isClick() {
        return isClick;
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(buttonHome1, Gdx.graphics.getWidth() / 2 - buttonHome1.getWidth() - 50, 150);
    }
}
