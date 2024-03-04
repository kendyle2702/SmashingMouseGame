package com.mygdx.game.MainGame.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.game.MainGame.Entity.Hammer;

public class InputProcessing extends InputAdapter {
    private Hammer hammer;

    public InputProcessing(Hammer hammer) {
        this.hammer = hammer;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("Toa do X va Y: " + screenX + ", " + (Gdx.graphics.getHeight() - screenY));
        System.out.println("So lan click va nut bam: " + pointer + ", " + button);

        hammer.setHammerX(screenX - 50);
        hammer.setHammerY(Gdx.graphics.getHeight() - screenY);
        hammer.setIsclick(true);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        hammer.setIsclick(false);
        
        return true;
    }
}
