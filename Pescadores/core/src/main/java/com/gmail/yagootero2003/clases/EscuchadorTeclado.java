package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.gmail.yagootero2003.Mundo;

public class EscuchadorTeclado implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.D: {
                if (Mundo.anzuelo.direccion == DireccionAnzuelo.SUBIENDO || Mundo.anzuelo.direccion == DireccionAnzuelo.BAJANDO) {
                    return false;
                }
                Mundo.pescador.direccion = Direccion.DERECHA;
            }
            break;

            case Input.Keys.A: {
                if (Mundo.anzuelo.direccion == DireccionAnzuelo.SUBIENDO || Mundo.anzuelo.direccion == DireccionAnzuelo.BAJANDO) {
                    return false;
                }
                Mundo.pescador.direccion = Direccion.IZQUIERDA;
            }
            break;

            case Input.Keys.S: {
                if (Mundo.anzuelo.direccion == DireccionAnzuelo.SUBIENDO) {
                    return false;
                }

                Mundo.pescador.direccion = Direccion.OCUPADO;
                Mundo.anzuelo.direccion = DireccionAnzuelo.BAJANDO;
            }
            break;


            default: {
            }
        }
        ;

        return false;
    }

    ;

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A: {
                if (Mundo.pescador.direccion == Direccion.IZQUIERDA) {
                    Mundo.pescador.direccion = Direccion.PARADO;
                }
            }
            break;

            case Input.Keys.D: {
                if (Mundo.pescador.direccion == Direccion.DERECHA) {
                    Mundo.pescador.direccion = Direccion.PARADO;
                }
            }
            break;

            case Input.Keys.S: {
                if (Mundo.anzuelo.direccion == DireccionAnzuelo.BAJANDO)
                    Mundo.anzuelo.direccion = DireccionAnzuelo.SUBIENDO;
            }

            default: {

                break;
            }

        }

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
