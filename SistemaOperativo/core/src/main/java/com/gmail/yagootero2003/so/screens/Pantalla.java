package com.gmail.yagootero2003.so.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Pantalla extends InputAdapter implements Screen {
    public static final int ANCHO = 640, ALTO = 480;
    public static final int VELOCIDAD = 100;
    protected SpriteBatch sb;
    protected ShapeRenderer sr;
    protected OrthographicCamera camera;
    protected Game pantallaAnterior;
    protected float delta;

    public Pantalla(Game pantalla) {
        pantallaAnterior = pantalla;
        sb = new SpriteBatch();
        sr = new ShapeRenderer();
        camera = new OrthographicCamera();
        delta = Gdx.graphics.getDeltaTime();
    }


    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, Pantalla.ANCHO, Pantalla.ALTO);
        camera.update();
        sb.setProjectionMatrix(camera.combined); // SpriteBatch
        sr.setProjectionMatrix(camera.combined);
    }


    @Override
    public void dispose() {
        sr.dispose();
        sb.dispose();
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
    public void show() {

    }
}
