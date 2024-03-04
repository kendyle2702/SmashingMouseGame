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
import com.mygdx.game.MainGame.Entity.Bomb;
import com.mygdx.game.MainGame.Entity.CountdownTime;
import com.mygdx.game.MainGame.Entity.Hammer;
import com.mygdx.game.MainGame.Entity.Hole;
import com.mygdx.game.MainGame.Entity.Mouse;
import com.mygdx.game.MainGame.Entity.Pointer;
import com.mygdx.game.MainGame.Input.InputProcessing;

public class MainScreen implements Screen{
    private MyGame myGame;
    private Stage stage;
    private Background backGround;
    private ExitButton exitButton;
    private CountdownTime countdownTime;
    private GameArea gameArea;
    private Mouse mouse1,mouse2,mouse3;
    private Bomb bomb;
    private Hammer hammer;
    private ArrayList<Hole> holeList;
    private InputProcessing input;
    private InputMultiplexer multiplexer;
    private Pointer point;
    public boolean isEnd = false;
    private int bombIndex, mouse1Index, mouse2Index,mouse3Index;
    private int countDieMouse1, countDieMouse2,countDieMouse3;
    private float elapsedMouse1Time = 0, elapsedMouse2Time = 0, elapsedMouse3Time = 0, elapsedBombTime = 0;
    private ArrayList<Person> personList;
    private int idOfBomb, idOfPlayer,idOfMouse1,idOfMouse2, idOfMouse3;
    
    
    public boolean isEnd(){
        return isEnd;
    }

    public void config(){
        bombIndex = -1;mouse1Index = -1;mouse2Index = -1;mouse3Index = -1;
        idOfBomb = -1;idOfPlayer = -1;idOfMouse1 = -1;idOfMouse2 = -1; idOfMouse3 = -1;
    }

    public void setPerson(){
        personList = new ArrayList<>();
        personList.add(new Person(0,"Quoc Cu", "QuocCu-Remove1.png","QuocCu-Remove2.png"));
        personList.add(new Person(1,"Hoang Khoi", "HoangKhoi-Remove1.png","HoangKhoi-Remove2.png"));
        personList.add(new Person(2,"Chi Khiem", "ChiKhiem-Remove1.png","ChiKhiem-Remove2.png"));
        personList.add(new Person(3,"Duy Dat", "DuyDat-Remove1.png","DuyDat-Remove2.png"));
        personList.add(new Person(4,"Hoang Uyen", "HoangUyen-Remove1.png","HoangUyen-Remove2.png"));
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

    public void getPersonRandom(){
        idOfPlayer = ThreadLocalRandom.current().nextInt(0,5);

        idOfBomb = ThreadLocalRandom.current().nextInt(0,5);
        while(idOfBomb == idOfPlayer){
            idOfBomb = ThreadLocalRandom.current().nextInt(0,5);
        }

        idOfMouse1 = ThreadLocalRandom.current().nextInt(0,5);
        while(idOfMouse1 == idOfPlayer || idOfMouse1 ==  idOfBomb){
            idOfMouse1 = ThreadLocalRandom.current().nextInt(0,5);
        }

        idOfMouse2 = ThreadLocalRandom.current().nextInt(0,5);
        while(idOfMouse2 == idOfPlayer || idOfMouse2 ==  idOfBomb || idOfMouse2 ==  idOfMouse1){
            idOfMouse2 = ThreadLocalRandom.current().nextInt(0,5);
        }

        idOfMouse3 = ThreadLocalRandom.current().nextInt(0,5);
        while(idOfMouse3 == idOfPlayer || idOfMouse3 ==  idOfBomb || idOfMouse3 ==  idOfMouse1 || idOfMouse3 == idOfMouse2){
            idOfMouse3 = ThreadLocalRandom.current().nextInt(0,5);
        }
    }

    public void getPositionRandom(int currentBomb, int currentMouse1, int currentMouse2,int currentMouse3, String name){
        if(name.equals("mouse1")){
            int mouse1Num = ThreadLocalRandom.current().nextInt(0,9);
            while( mouse1Num == currentMouse1|| mouse1Num == currentMouse2 || mouse1Num == currentMouse3 || mouse1Num == currentBomb){
                mouse1Num = ThreadLocalRandom.current().nextInt(0,9);     
            }
            mouse1Index = mouse1Num;
        }
        else if(name.equals("mouse2")){
            int mouse2Num = ThreadLocalRandom.current().nextInt(0,9);
            while(mouse2Num == currentMouse2 || mouse2Num == currentMouse1 || mouse2Num == currentMouse3 || mouse2Num == currentBomb){
                mouse2Num = ThreadLocalRandom.current().nextInt(0,9);
            }
            mouse2Index = mouse2Num;
        }
        else if(name.equals("mouse3")){
            int mouse3Num = ThreadLocalRandom.current().nextInt(0,9);
            while(mouse3Num == currentMouse3 || mouse3Num == currentMouse1 || mouse3Num == currentMouse2 || mouse3Num == currentBomb){
                mouse3Num = ThreadLocalRandom.current().nextInt(0,9);
            }
            mouse3Index = mouse3Num;
        }
        else{
            int bombNum = ThreadLocalRandom.current().nextInt(0,9);
            while(bombNum == currentBomb || bombNum == currentMouse1 || bombNum == currentMouse2 || bombNum == currentMouse3 ){
                bombNum = ThreadLocalRandom.current().nextInt(0,9);     
            }
            bombIndex = bombNum;
        }
        
    }
    public void createMouse1(){
        countDieMouse1 = 0;
        getPositionRandom(bombIndex,mouse1Index,mouse2Index,mouse3Index,"mouse1");
        mouse1 = new Mouse(hammer, point, holeList.get(mouse1Index).getHoleX(), holeList.get(mouse1Index).getHoleY(),1,personList.get(idOfMouse1).getPath1(),personList.get(idOfMouse1).getPath2()); 
        mouse1.setTouchable(Touchable.enabled);
        stage.addActor(mouse1);
    }

    public void createMouse2(){
        countDieMouse2 = 0;
        getPositionRandom(bombIndex, mouse1Index, mouse2Index,mouse3Index, "mouse2");
        mouse2 = new Mouse(hammer, point, holeList.get(mouse2Index).getHoleX(), holeList.get(mouse2Index).getHoleY(),2,personList.get(idOfMouse2).getPath1(),personList.get(idOfMouse2).getPath2());
        mouse2.setTouchable(Touchable.enabled);
        stage.addActor(mouse2);
    }
    public void createMouse3(){
        countDieMouse3 = 0;
        getPositionRandom(bombIndex, mouse1Index, mouse2Index,mouse3Index, "mouse3");
        mouse3 = new Mouse(hammer, point, holeList.get(mouse3Index).getHoleX(), holeList.get(mouse3Index).getHoleY(),3,personList.get(idOfMouse3).getPath1(),personList.get(idOfMouse3).getPath2());
        mouse3.setTouchable(Touchable.enabled);
        stage.addActor(mouse3);
    }


    public void createBomb(){
        getPositionRandom(bombIndex,mouse1Index,mouse2Index,mouse3Index,"bomb");
        bomb = new Bomb(hammer, holeList.get(bombIndex).getHoleX(), holeList.get(bombIndex).getHoleY(),personList.get(idOfBomb).getPath1(),personList.get(idOfBomb).getPath2());
        bomb.setTouchable(Touchable.enabled);
        stage.addActor(bomb);
    }

    public void exeMouse1(float delta){
        elapsedMouse1Time += delta;
        if(mouse1.isLive() == false){
            countDieMouse1++;
            mouse1.remove();
            if(countDieMouse1 == 1) elapsedMouse1Time = 2f;
        }
        if(elapsedMouse1Time - 2f > 0 ){
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
                elapsedMouse2Time = 1.5f;
            }
        }
        if(elapsedMouse2Time > 1.5f){
            mouse2.remove();
        }
        if(elapsedMouse2Time > 3f){
            createMouse2();
            elapsedMouse2Time = 0f;
        }
    }
    public void exeMouse3(float delta){
        elapsedMouse3Time += delta;
        if(mouse3.isLive() == false){
            countDieMouse3++;
            mouse3.remove();
            if(countDieMouse3 == 1){
                elapsedMouse3Time = 1.5f;
            }
        }
        if(elapsedMouse3Time > 0.5f){
            mouse3.remove();
        }
        if(elapsedMouse3Time > 2f){
            createMouse3();
            elapsedMouse3Time = 0f;
        }
    }
    public void exeBomb(float delta){
        elapsedBombTime += delta;
        
        if(bomb.isLive() == false){
            bomb.remove();
            myGame.showEndScreen(point.getPoint());
        }

        if(elapsedBombTime - 1f > 0 ){
            bomb.remove();
        }
        if(elapsedBombTime - 2.5f > 0){
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
        config();
        setPerson();   
        getPersonRandom();  

        countdownTime = new CountdownTime(60f);
        backGround = new Background();
        gameArea = new GameArea();
        gameArea.setNameOfBoomer(personList.get(idOfBomb).getName());
        gameArea.setNameOfPlayer(personList.get(idOfPlayer).getName());

        hammer = new Hammer();

        point = new Pointer(0);

        exitButton = new ExitButton();

        setHole();
        
        stage.addActor(backGround);
        stage.addActor(gameArea);
        stage.addActor(hammer);
        stage.addActor(point);
        stage.addActor(countdownTime);
        stage.addActor(exitButton);

        createMouse1();
        createMouse2();
        createMouse3();
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
        exeMouse3(delta);
        exeBomb(delta);

        if(countdownTime.isTimeUp()){
            myGame.showEndScreen(point.getPoint());
        }
        if(exitButton.isClick()){
            myGame.showStartScreen();
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
