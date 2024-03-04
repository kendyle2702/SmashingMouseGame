package com.mygdx.game.MainGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameArea extends Actor {
    private Texture gameArea;
    private float gameAreaX, gameAreaY;
    private BitmapFont player, boomer;
    private String nameOfPlayer ="", nameOfBoomer="";

    public GameArea() {
        gameArea = new Texture(Gdx.files.internal("game_area.png"));
        gameAreaX = Gdx.graphics.getWidth() / 2 - gameArea.getWidth() / 2;
        gameAreaY = Gdx.graphics.getHeight() / 2 - gameArea.getHeight() / 2 - 50;

        player = new BitmapFont();
        player.setColor(com.badlogic.gdx.graphics.Color.GOLD);
        player.getData().setScale(1.5f);
        boomer = new BitmapFont();
        boomer.setColor(com.badlogic.gdx.graphics.Color.GOLD);
        boomer.getData().setScale(1.5f);

    }
    
    public void setNameOfPlayer(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
    }


    public void setNameOfBoomer(String nameOfBoomer) {
        this.nameOfBoomer = nameOfBoomer;
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(gameArea, gameAreaX, gameAreaY);

        player.draw(batch,nameOfPlayer+" is Player",100,470);
        boomer.draw(batch,nameOfBoomer+" is Boomer", 350,470);
    }
}
