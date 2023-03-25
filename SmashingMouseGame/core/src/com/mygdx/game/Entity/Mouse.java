package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Mouse extends Actor{
    private Hammer hammer;
    private Texture mouse1Texture,mouse2Texture;
    private Pointer point;
    private float mouseX;
    private float mouseY;
    private boolean isLive = true;
    private int pointOfMouse;
    
    public Mouse(Hammer hammer,Pointer point, float mouseX, float mouseY,int pointOfMouse,String path1,String path2){
        this.hammer = hammer;
        this.point = point;
        this.pointOfMouse = pointOfMouse;
        mouse1Texture = new Texture(Gdx.files.internal(path1));
        mouse2Texture = new Texture(Gdx.files.internal(path2));
        setSize(mouse1Texture.getWidth(), mouse1Texture.getHeight());
        
        this.mouseX = mouseX - mouse1Texture.getWidth()/2;
        this.mouseY = mouseY;

        setPosition(this.mouseX, this.mouseY);
        
        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Music hit = Gdx.audio.newMusic(Gdx.files.internal("hit.mp3"));
                hit.play();
                addPoint();
                mouse1Texture = mouse2Texture;   
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
    public void addPoint(){
        point.setPoint(point.getPoint() + pointOfMouse);
        System.out.println(point.getPoint());
    }
    public void setDownHammer() {
        hammer.setHammerX(mouseX-10);
        hammer.setHammerY(mouseY+50);
        hammer.setIsclick(true);
    }
    public void setUpHammer(){
        hammer.setIsclick(false);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(mouse1Texture, mouseX, mouseY);
        setPosition(mouseX, mouseY);
    }
    @Override
    public void act(float delta) {
        
    }
    
}
