package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.gmail.yagootero2003.Mundo;

public class EscuchadorTeclado implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.D:  {
                Mundo.pescador.direccion = Direccion.DERECHA;
                System.out.println("Se detecto letra D");
            } break;

            case Input.Keys.A:  {
                System.out.println("Se detecto letra A");
                Mundo.pescador.direccion = Direccion.IZQUIERDA;
            } break;

            default: {}
        };

        return false;
    };

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
