package com.mygdx.game.EndGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class EndScreenBackground extends Actor {
    private Texture endgameTexture;
    private Texture buttonRestart1, buttonRestart2;
    private boolean isClick = false;
    private int point = 0;
    private BitmapFont bitmapFont;
    private BitmapFont fontEndGame;

    public EndScreenBackground(int point) {
        this.point = point;
        bitmapFont = new BitmapFont();
        fontEndGame = new BitmapFont();
        endgameTexture = new Texture(Gdx.files.internal("end_box.png"));
        buttonRestart1 = new Texture(Gdx.files.internal("but_restart1.png"));
        buttonRestart2 = new Texture(Gdx.files.internal("but_restart2.png"));

        setBounds(Gdx.graphics.getWidth() / 2 + buttonRestart1.getWidth() / 2,
                150, buttonRestart1.getWidth(),
                buttonRestart1.getHeight());
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Music click = Gdx.audio.newMusic(Gdx.files.internal("click.mp3"));
                click.play();
                buttonRestart1 = buttonRestart2;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                ((EndScreenBackground) event.getTarget()).isClick = true;
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
        batch.draw(endgameTexture, Gdx.graphics.getWidth() / 2 - endgameTexture.getWidth() / 2,
                Gdx.graphics.getWidth() / 2 - endgameTexture.getWidth() / 2);
        batch.draw(buttonRestart1, Gdx.graphics.getWidth() / 2 + buttonRestart1.getWidth() / 2, 150);
        bitmapFont.getData().setScale(1.5f);
        bitmapFont.setColor(Color.ORANGE);
        fontEndGame.setColor(Color.ORANGE);
        fontEndGame.getData().setScale(2.5f);
        fontEndGame.draw(batch, "END GAME", 230, 320);
        bitmapFont.draw(batch, "Score: " + point, 280, 280);
    }
}
