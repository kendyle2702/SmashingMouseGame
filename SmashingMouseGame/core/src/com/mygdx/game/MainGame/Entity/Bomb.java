package com.mygdx.game.MainGame.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Bomb extends Actor {
    private Hammer hammer;
    private Texture bomb1, bomb2;
    private float bombX;
    private float bombY;
    private boolean isLive = true;
    private Music bomb;

    public Bomb(Hammer hammer, float bombX, float bombY, String path1,String path2) {
        this.hammer = hammer;

        bomb1 = new Texture(Gdx.files.internal(path1));
        bomb2 = new Texture(Gdx.files.internal(path2));
        setSize(bomb1.getWidth(), bomb1.getHeight());

        this.bombX = bombX - bomb1.getWidth() / 2;
        this.bombY = bombY;

        setPosition(this.bombX, this.bombY);

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                bomb1 = bomb2;
                bomb = Gdx.audio.newMusic(Gdx.files.internal("bomb.mp3"));
                bomb.play();
                setDownHammer();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isLive = false;
                setUpHammer();
            }
        });
    }

    public boolean isLive() {
        return isLive;
    }

    public void setDownHammer() {
        hammer.setHammerX(bombX - 10);
        hammer.setHammerY(bombY + 50);
        hammer.setIsclick(true);
    }

    public void setUpHammer() {
        hammer.setIsclick(false);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(bomb1, bombX, bombY);
        setPosition(bombX, bombY);
    }

    @Override
    public void act(float delta) {

    }

}
