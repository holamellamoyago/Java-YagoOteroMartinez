package com.gmail.yagootero2003.so.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gmail.yagootero2003.so.Assets;
import com.gmail.yagootero2003.so.Icono;
import com.gmail.yagootero2003.so.SistemaOperativo;

import java.util.ArrayList;
import java.util.List;

public class Escritorio extends Pantalla {

    //private final int ANCHO = 1920, ALTO = 1080;
    public static ArrayList<Icono> iconos;
    private SistemaOperativo juego;

    public Escritorio(SistemaOperativo juego) {
        this.juego = juego;

        sb = new SpriteBatch();
        sr = new ShapeRenderer();
        camara = new OrthographicCamera();
        ancho = 1920;
        alto = 1080;

        iconos = new ArrayList<>();
        iconos.add(new Icono("chrome.png", this));
        iconos.add(new Icono("spotify.png", this));

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        camara.setToOrtho(false, ancho, alto);
        camara.update();
        sb.setProjectionMatrix(camara.combined); // SpriteBatch
        sr.setProjectionMatrix(camara.combined);
    }

    @Override
    public void render(float delta) {
        sr.begin(ShapeRenderer.ShapeType.Line);
        sb.begin();


        sb.draw(Assets.fondo, 0, 0, ancho, alto);
        sb.draw(Assets.barraTareas, 0, 0, ancho, 50);

        for (Icono ico : iconos) {
            ico.actualizar();
            ico.dibujar(sb, sr);
        }

        sb.end();
        sr.end();
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
        sb.dispose();
        sr.dispose();
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {


        Vector3 v3CoordenadasDePantalla = new Vector3(screenX, screenY, 0);
        Vector3 v3CoordenadasDeMundo = camara.unproject(v3CoordenadasDePantalla);


        for (Icono ico : iconos) {
            System.out.println("Y: "+ v3CoordenadasDeMundo.y);


            if (ico.getHitBox().contains(v3CoordenadasDeMundo.x, v3CoordenadasDeMundo.y)) {
                System.out.println("Icono pulsado");
            } else {
                System.out.println("Afuera");
            }

        }
        return false;
    }

}
