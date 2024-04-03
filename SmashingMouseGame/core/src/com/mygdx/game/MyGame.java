package com.mygdx.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.mygdx.game.EndGame.EndScreen;
import com.mygdx.game.MainGame.MainScreen;
import com.mygdx.game.StartGame.StartScreen;
import com.mygdx.game.StartGame.Detail.DetailScreen;
import com.mygdx.game.StartGame.ExitGame.ExitSreen;
import com.mygdx.game.StartGame.HowToPlay.HowToPlayScreen;
import com.mygdx.game.StartGame.InputScreen.InputScreen;

public class MyGame extends Game {
    private Screen startScreen;
    private Screen mainScreen;
    private Screen endScreen;
    private Screen detailScreen;
    private Screen inputScreen;
    private Screen howToPlayScreen;
    private Screen exitScreen;
    private Music music;
    private String username;
    private int maxPoint = 0;
    private ArrayList<User> userList;


    @Override
    public void create() {
        userList = new ArrayList<>();

        readDatabase();

        startScreen = new StartScreen(this);
        mainScreen = new MainScreen(this);
        endScreen = new EndScreen(this);
        detailScreen = new DetailScreen(this);
        inputScreen = new InputScreen(this);
        howToPlayScreen = new HowToPlayScreen(this);
        exitScreen = new ExitSreen(this);

        music = Gdx.audio.newMusic(Gdx.files.internal("soundtrack.mp3"));
        music.setLooping(true);
        music.play();

        setScreen(startScreen);
    }
    

    public void showMainScreen() {
        setScreen(mainScreen);
    }
    

    public void showEndScreen(int point) {
        ((EndScreen) endScreen).setPoint(point);
        setScreen(endScreen);
    }

    public void showStartScreen() {
        setScreen(startScreen);
    }

    public void showDetailScreen(){
        setScreen(detailScreen);
    }
    
    public void showInputScreen(){
        setScreen(inputScreen);
    }
    public void showHowToPlayScreen(){
        setScreen(howToPlayScreen);
    }
    public void showExitScreen(){
        setScreen(exitScreen);
    }
    
    public String getUsername() {
        return username;
    }

    public int getMaxPoint() {
        return maxPoint;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
    

    public void setUsername(String username) {
        if(username.length() == 0){
            this.username = "Anonymity";
        }
        else{
            this.username = username;
            
        }
    }

    public void setMaxPoint(int maxPoint) {
        this.maxPoint = maxPoint;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public void readDatabase(){
        FileHandle fileHandle = Gdx.files.internal("history.txt");
        BufferedReader reader = new BufferedReader(fileHandle.reader());
        try {
            String line;
            String[] str;
            while ((line = reader.readLine()) != null) {
                str = line.split("#-------------#");
                userList.add(new User(str[0], Integer.parseInt(str[1])));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeDatabase(){
        // FileHandle file = Gdx.files.external("history.txt");
        // file.writeString("\n" + getUsername() + "#-------------#" +  maxPoint, true);
    }
    
    @Override
    public void dispose() {
        if(username!=null){
            writeDatabase();
        }
    }
}
