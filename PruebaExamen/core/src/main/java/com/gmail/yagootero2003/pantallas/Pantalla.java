package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.DireccionEnemigo;
import com.gmail.yagootero2003.Jugador;

public abstract class Pantalla extends InputAdapter implements Screen {
    protected SpriteBatch sb;
    protected ShapeRenderer sr;
    protected OrthographicCamera camera;
    protected Game game;
    protected float delta;

    public Pantalla(Game pantalla) {
        game = pantalla;
        sb = new SpriteBatch();
        sr = new ShapeRenderer();
        camera = new OrthographicCamera();
        delta = Gdx.graphics.getDeltaTime();
    }

    public static final int ANCHO = 640, ALTO = 480;

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, Pantalla.ANCHO, Pantalla.ALTO);
        camera.update();
        sb.setProjectionMatrix(camera.combined); // SpriteBatch
        sr.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void show() {

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
        sr.dispose();
        sb.dispose();
    }

    public static int calcularAncho(double porcentaje) {
        return (int) (ANCHO * porcentaje);
    }

    public static int calcularAlto(double porcentaje) {
        return (int) (ALTO * porcentaje);
    }


}
