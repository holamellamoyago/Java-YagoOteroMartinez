package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.Assets;
import com.gmail.yagootero2003.Mundo;
import com.gmail.yagootero2003.clases.Anzuelo;
import com.gmail.yagootero2003.clases.Direccion;
import com.gmail.yagootero2003.clases.DireccionAnzuelo;
import com.gmail.yagootero2003.clases.Pescador;
import com.gmail.yagootero2003.clases.Pez;
import com.gmail.yagootero2003.clases.Sedal;

import java.util.ArrayList;
import java.util.List;

public class PantallaJuego extends  Pantalla implements InputProcessor {


    public static List<Pez> peces = new ArrayList<>();
    public static Pescador pescador;
    public static Anzuelo anzuelo;
    public static Sedal sedal;
    public PantallaJuego() {
        camara = new OrthographicCamera();

        sb = new SpriteBatch();
        sr = new ShapeRenderer();




        Mundo.pescador = new Pescador(Assets.pescador);
        Mundo.peces.add(new Pez(Assets.pezAzul));
        Mundo.anzuelo = new Anzuelo(Assets.anzuelo);
        Mundo.sedal = new Sedal(Assets.sedal);

    }

    @Override
    public void show() {
        // SOLUCINADO: Aquí sigue detectando el input de PantallaInicial
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1,1,1,1);
        sr.begin(ShapeRenderer.ShapeType.Line);
        sb.begin();

        Mundo.mostrarFondo(sb);
        Mundo.actualizarPersonajes(delta);
        Mundo.dibujarPersonajes(sb,sr);
        Mundo.comprobarPescadosVivos();

        sb.end();
        sr.end();

    }

    @Override
    public void resize(int width, int height) {
        camara.setToOrtho(false, ANCHO, ALTO);
        camara.update();
        sb.setProjectionMatrix(camara.combined); // SpriteBatch
        sr.setProjectionMatrix(camara.combined);
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
        sb.dispose(); sr.dispose();
    }

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
