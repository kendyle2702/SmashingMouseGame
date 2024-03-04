package com.mygdx.game.StartGame.InputScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class InputBackground extends Actor{
    private Texture background;
    private Texture inputBackground;
    private Texture yesButton1, yesButton2, temp;
    private BitmapFont showDupError;
    private boolean isClick = false;
    private boolean isDupError = false;

    public InputBackground(){
        background = new Texture(Gdx.files.internal("end_box.png"));
        inputBackground = new Texture(Gdx.files.internal("input.png"));
        yesButton1 = new Texture(Gdx.files.internal("but_yes1.png"));
        temp = yesButton1;
        yesButton2 = new Texture(Gdx.files.internal("but_yes2.png"));
        showDupError = new BitmapFont();

        showDupError.getData().setScale(1f);
        showDupError.setColor(Color.ORANGE);

        setBounds(Gdx.graphics.getWidth() / 2 - yesButton1.getWidth()/2, 120, yesButton1.getWidth(),
                yesButton1.getHeight());

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Music click = Gdx.audio.newMusic(Gdx.files.internal("click.mp3"));
                click.play();
                yesButton1 = yesButton2;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isClick = true;
            }
        });
    }
    
    public void showError(){
        isDupError = true;
    }
    public boolean isClick() {
        return isClick;
    }
    public void setClick(boolean a){
        yesButton1 = temp;
        isClick = a;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(background, Gdx.graphics.getWidth() / 2 - background.getWidth() / 2,
        Gdx.graphics.getWidth() / 2 - background.getWidth() / 2);

        batch.draw(inputBackground, Gdx.graphics.getWidth() / 2 - inputBackground.getWidth() / 2,
        Gdx.graphics.getWidth() / 2 - 100);

        batch.draw(yesButton1, getX(),getY());
        if(isDupError){
            showDupError.draw(batch, "Username already exists. Please re-enter!", 190, 242);
        }
    }
    @Override
    public void act(float delta) {

    }
}
