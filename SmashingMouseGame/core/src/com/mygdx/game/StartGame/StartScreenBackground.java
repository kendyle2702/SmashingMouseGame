package com.mygdx.game.StartGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class StartScreenBackground extends Actor {
    private Texture background;
    private Texture button1, button2;
    private boolean isClick = false;

    public StartScreenBackground() {
        background = new Texture(Gdx.files.internal("start.jpg"));
        button1 = new Texture(Gdx.files.internal("but_start_game1.png"));
        button2 = new Texture(Gdx.files.internal("but_start_game2.png"));
        setBounds(Gdx.graphics.getWidth() / 2 - button1.getWidth() / 2, 120, button1.getWidth(), button1.getHeight());
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Music click = Gdx.audio.newMusic(Gdx.files.internal("click.mp3"));
                click.play();
                button1 = button2;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                ((StartScreenBackground) event.getTarget()).isClick = true;
            }
        });
    }

    public boolean isClick() {
        return isClick;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(background, Gdx.graphics.getWidth() / 2 - background.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - background.getHeight() / 2);
        batch.draw(button1, Gdx.graphics.getWidth() / 2 - button1.getWidth() / 2, 120);
    }

    @Override
    public void act(float delta) {

    }
}
