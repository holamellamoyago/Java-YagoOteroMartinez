package com.gmail.yagootero2003.so.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gmail.yagootero2003.so.Assets;
import com.gmail.yagootero2003.so.Icono;

import java.util.ArrayList;
import java.util.List;

public class Escritorio extends Pantalla {

    private final int ANCHO = 1920, ALTO = 1080;
    public static ArrayList<Icono> iconos;

    public Escritorio() {
        super();

        sb = new SpriteBatch();
        sr = new ShapeRenderer();
        camara = new OrthographicCamera();
        ancho = ANCHO;
        alto = ALTO;

        iconos = new ArrayList<>();
        iconos.add(new Icono("chrome.png"));
        iconos.add(new Icono("spotify.png"));






    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        sr.begin(ShapeRenderer.ShapeType.Line);
        sb.begin();



        sb.draw(Assets.fondo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(Assets.barraTareas, 0, 0 , Gdx.graphics.getWidth(), 50);

        for (Icono  ico : iconos) {
            ico.actualizar();
            ico.dibujar(sb,sr);
        }

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
    public void dispose() {sb.dispose(); sr.dispose();}

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

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
        for(Icono ico : iconos) {
            if (ico.getHitBox().contains(screenX, screenY)) {
                System.out.println("Icono pulsado");
            } else{
                System.out.println("Afuera");
            }

        }
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
