package com.mygdx.game.StartGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.User;

public class Rank extends Actor{
    private User user1,user2,user3;
    private BitmapFont top1Name,top1Point,top2Name,top2Point, top3Name,top3Point;
    private Texture rankBackground;

    public Rank(){
        rankBackground = new Texture(Gdx.files.internal("rankbackground.png"));
        setBounds(400,330, 10,10);


        top1Name = new BitmapFont();
        top1Name.getData().setScale(0.8f);
        top2Name = new BitmapFont();
        top2Name.getData().setScale(0.8f);
        top3Name = new BitmapFont();
        top2Name.getData().setScale(0.8f);
        top1Point = new BitmapFont();
        top2Point = new BitmapFont();
        top3Point = new BitmapFont();
        top1Name.setColor(Color.BLACK);
        top2Name.setColor(Color.BLACK);
        top3Name.setColor(Color.BLACK);
        top1Point.setColor(Color.BLACK);
        top2Point.setColor(Color.BLACK);
        top3Point.setColor(Color.BLACK);

    }
   
    public void setTopUser(User user1, User user2,User user3){
        this.user1 = user1;
        this.user2 = user2;
        this.user3 = user3;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(rankBackground, getX(),getY());
        
        top1Name.draw(batch,user1.getUsername(),482,423);
        top1Point.draw(batch,user1.getPoint()+"",610,423);
        top2Name.draw(batch,user2.getUsername(),482,393);
        top2Point.draw(batch,user2.getPoint()+"",610,393);
        top2Name.draw(batch,user3.getUsername(),482,363);
        top2Point.draw(batch,user3.getPoint()+"",610,363);
    }

    @Override
    public void act(float delta) {
        
    }

}
