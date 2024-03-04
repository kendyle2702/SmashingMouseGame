package com.mygdx.game.MainGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ExitButton extends Actor{
    private Texture exitButton1, exitButton2;
    private boolean isClick = false;


    public ExitButton(){
        exitButton1 = new Texture(Gdx.files.internal("but_exit1.png"));
        exitButton2 = new Texture(Gdx.files.internal("but_exit2.png"));
        setBounds(Gdx.graphics.getWidth() -70 , Gdx.graphics.getHeight()-70, exitButton1.getWidth(),
                exitButton1.getHeight());
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Music click = Gdx.audio.newMusic(Gdx.files.internal("click.mp3"));
                click.play();
                exitButton1 = exitButton2;
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
        batch.draw(exitButton1, getX(),getY());
    }
}
