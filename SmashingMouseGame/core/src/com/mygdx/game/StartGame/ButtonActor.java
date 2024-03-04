package com.mygdx.game.StartGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ButtonActor extends Actor{
    private Texture button1,button2;
    private boolean isClick =false;

    public ButtonActor(String path1, String path2, int x,int y){
        button1 = new Texture(Gdx.files.internal(path1));
        button2 = new Texture(Gdx.files.internal(path2));
        setBounds(x - button1.getWidth() / 2, y, button1.getWidth(), button1.getHeight());
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
                ((ButtonActor) event.getTarget()).isClick = true;
            }
        });
    }
    public boolean isClick() {
        return isClick;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(button1, getX(), getY());
    }
    @Override
    public void act(float delta) {

    }
}
