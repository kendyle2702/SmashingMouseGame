package com.mygdx.game.StartGame.InputScreen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.mygdx.game.MyGame;
import com.mygdx.game.User;
import com.mygdx.game.MainGame.ExitButton;

public class InputScreen implements Screen{
    private MyGame myGame;
    private Stage stage;
    private InputBackground inputBackground;
    private ExitButton exitButton;
    private TextField textField;

    public InputScreen(MyGame myGame){
        this.myGame = myGame;
    }

    public boolean existUser(String checkUsername){
        for (User user : myGame.getUserList()) {
            if(user.getUsername().equalsIgnoreCase(checkUsername)){
                return false;
            }
        }
        return true;
    }
    @Override
    public void show() {
        stage = new Stage();
        // stage.setDebugAll(true);

        BitmapFont font = new BitmapFont();
        TextFieldStyle textFieldStyle = new TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.fontColor = com.badlogic.gdx.graphics.Color.WHITE;
         
        textField = new TextField("", textFieldStyle);
        textField.setHeight(30);
        textField.setPosition(170,245);
        textField.setWidth(300f);
        

        inputBackground = new InputBackground();
        exitButton = new ExitButton();
        exitButton.setTouchable(Touchable.enabled);
        inputBackground.setTouchable(Touchable.enabled);
        stage.addActor(exitButton);
        stage.addActor(inputBackground);
        stage.addActor(textField);
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void render(float delta) {
        stage.act();
        if(inputBackground.isClick()){
            if(existUser(textField.getText().trim())){
                myGame.setUsername(textField.getText().trim());
                myGame.showMainScreen();
            }
            else{
                inputBackground.showError();
                inputBackground.setClick(false);
            }
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
