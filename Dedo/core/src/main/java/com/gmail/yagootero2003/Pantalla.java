package com.gmail.yagootero2003;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Pantalla implements Screen {
    protected SpriteBatch sb;
    protected ShapeRenderer sr;
    protected OrthographicCamera camera;
    protected Game game;

    public Pantalla(Game pantalla) {
        sb = new SpriteBatch();
        sr = new ShapeRenderer();
        camera = new OrthographicCamera();
    }
    public static final int ANCHO = 640, ALTO = 480;
    public static final int VELOCIDAD = 100;

    public static final float STATE_MINIMO = 1f, STATE_MAXIMO = 1.2f;

    public static final int NUM_MINIMO = 1, NUM_MAXIMO = 12;

    public static final int RADIO_BALA = 5;

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, Pantalla.ANCHO, Pantalla.ALTO);
        camera.update();
        sb.setProjectionMatrix(camera.combined); // SpriteBatch
        sr.setProjectionMatrix(camera.combined);
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

    }
}
