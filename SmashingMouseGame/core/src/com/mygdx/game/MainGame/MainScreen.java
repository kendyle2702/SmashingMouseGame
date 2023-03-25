package com.mygdx.game.MainGame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGame;
import com.mygdx.game.Entity.Bomb;
import com.mygdx.game.Entity.CountdownTime;
import com.mygdx.game.Entity.Hammer;
import com.mygdx.game.Entity.Hole;
import com.mygdx.game.Entity.Mouse;
import com.mygdx.game.Entity.Pointer;
import com.mygdx.game.Input.InputProcessing;

public class MainScreen implements Screen{
    private MyGame myGame;
    private Background backGround;
    private CountdownTime countdownTime;
    private GameArea gameArea;
    private Mouse mouse1,mouse2;
    private Bomb bomb;
    private Hammer hammer;
    private ArrayList<Hole> holeList;
    private InputProcessing input;
    private InputMultiplexer multiplexer;
    private Pointer point;
    public boolean isEnd = false;
    private int bombIndex = -1, mouse1Index = -1, mouse2Index = -1,countDieMouse1, countDieMouse2;
    private float elapsedMouse1Time = 0, elapsedMouse2Time = 0, elapsedBombTime = 0;

    private Stage stage;
    
    
    public boolean isEnd(){
        return isEnd;
    }
    public void setHole(){
        holeList = new ArrayList<>();
        Hole hole0 = new Hole(180f,292f);
        holeList.add(hole0);
        Hole hole1 = new Hole(312f,292f);
        holeList.add(hole1);
        Hole hole2 = new Hole(443f,292f);
        holeList.add(hole2);
        Hole hole3 = new Hole(180f,180f);
        holeList.add(hole3);
        Hole hole4 = new Hole(312f,180f);
        holeList.add(hole4);
        Hole hole5 = new Hole(443f,180f);
        holeList.add(hole5);
        Hole hole6 = new Hole(180f,70f);
        holeList.add(hole6);
        Hole hole7 = new Hole(312f,70f);
        holeList.add(hole7);
        Hole hole8 = new Hole(443f,70f);
        holeList.add(hole8);
    }
    public void getRandom(int currentBomb, int currentMouse1, int currentMouse2, String name){
        if(name.equals("mouse1")){
            int mouse1Num = ThreadLocalRandom.current().nextInt(0,9);
            while( mouse1Num == currentMouse1|| mouse1Num == currentMouse2 || mouse1Num == currentBomb){
                mouse1Num = ThreadLocalRandom.current().nextInt(0,9);     
            }
            mouse1Index = mouse1Num;
        }
        else if(name.equals("mouse2")){
            int mouse2Num = ThreadLocalRandom.current().nextInt(0,9);
            while(mouse2Num == currentMouse2 || mouse2Num == currentMouse1 || mouse2Num == currentBomb){
                mouse2Num = ThreadLocalRandom.current().nextInt(0,9);
            }
            mouse2Index = mouse2Num;
        }
        else{
            int bombNum = ThreadLocalRandom.current().nextInt(0,9);
            while(bombNum == currentBomb || bombNum == currentMouse1 || bombNum == currentMouse2){
                bombNum = ThreadLocalRandom.current().nextInt(0,9);     
            }
            bombIndex = bombNum;
        }
        
    }
    public void createMouse1(){
        countDieMouse1 = 0;
        getRandom(bombIndex,mouse1Index,mouse2Index,"mouse1");
        mouse1 = new Mouse(hammer, point, holeList.get(mouse1Index).getHoleX(), holeList.get(mouse1Index).getHoleY(),1,"mouse11.png","mouse12.png"); 
        mouse1.setTouchable(Touchable.enabled);
        stage.addActor(mouse1);
        
    }
    public void createMouse2(){
        countDieMouse2 = 0;
        getRandom(bombIndex, mouse1Index, mouse2Index, "mouse2");
        mouse2 = new Mouse(hammer, point, holeList.get(mouse2Index).getHoleX(), holeList.get(mouse2Index).getHoleY(),2,"mouse21.png","mouse22.png");
        mouse2.setTouchable(Touchable.enabled);
        stage.addActor(mouse2);
    }
    public void createBomb(){
        getRandom(bombIndex,mouse1Index,mouse2Index,"bomb");
        bomb = new Bomb(hammer, holeList.get(bombIndex).getHoleX(), holeList.get(bombIndex).getHoleY());
        bomb.setTouchable(Touchable.enabled);
        stage.addActor(bomb);
    }
    public void exeMouse1(float delta){
        elapsedMouse1Time += delta;
        if(mouse1.isLive() == false){
            countDieMouse1++;
            mouse1.remove();
            if(countDieMouse1 == 1) elapsedMouse1Time = 1.5f;
        }
        if(elapsedMouse1Time - 1.5f > 0 ){
            mouse1.remove();
        }
        if(elapsedMouse1Time - 3f > 0){
            createMouse1();
            elapsedMouse1Time = 0;
        }
    }
    public void exeMouse2(float delta){
        elapsedMouse2Time += delta;
        if(mouse2.isLive() == false){
            countDieMouse2++;
            mouse2.remove();
            if(countDieMouse2 == 1){
                elapsedMouse2Time = 1f;
            }
        }
        if(elapsedMouse2Time > 1f){
            mouse2.remove();
        }
        if(elapsedMouse2Time > 2f){
            createMouse2();
            elapsedMouse2Time = 0f;
        }
    }
    public void exeBomb(float delta){
        elapsedBombTime += delta;
        
        if(bomb.isLive() == false){
            bomb.remove();
            myGame.showEndScreen(point.getPoint());
        }

        if(elapsedBombTime - 1.5f > 0 ){
            bomb.remove();
        }
        if(elapsedBombTime - 3f > 0){
            createBomb();
            elapsedBombTime = 0;
        }
    }
    public MainScreen(MyGame myGame){
        this.myGame = myGame;   
    }
    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        // stage.setDebugAll(true);
        countdownTime = new CountdownTime(60f);
        backGround = new Background();
        gameArea = new GameArea();
        
        hammer = new Hammer();

        point = new Pointer(0);

        setHole();
        
        stage.addActor(backGround);
        stage.addActor(gameArea);
        stage.addActor(hammer);
        stage.addActor(point);
        stage.addActor(countdownTime);
        
        createMouse1();
        createMouse2();
        createBomb();

        input = new InputProcessing(hammer);
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(input);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        stage.act(Gdx.graphics.getDeltaTime());

        exeMouse1(delta);
        exeMouse2(delta);
        exeBomb(delta);

        if(countdownTime.isTimeUp()){
            myGame.showEndScreen(point.getPoint());
        }

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
       
    }

    @Override
    public void hide() {
       
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
