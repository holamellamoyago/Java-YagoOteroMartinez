package com.gmail.yagootero2003.so.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gmail.yagootero2003.so.Assets;
import com.gmail.yagootero2003.so.Icono;
import com.gmail.yagootero2003.so.SistemaOperativo;

import java.util.List;

public class Escritorio extends Pantalla {

    //private final int ANCHO = 1920, ALTO = 1080;
    public static Array<Icono> iconos;

    public Escritorio(SistemaOperativo juego) {
        super(juego);


        iconos = new Array<>();
        iconos.add(new Icono("chrome.png", Pantallas.CHROME));
        iconos.add(new Icono("spotify.png", Pantallas.SPOTIFY));

    }


    @Override
    public void render(float delta) {
        sr.begin(ShapeRenderer.ShapeType.Line);
        sb.begin();


        sb.draw(Assets.fondo, 0, 0, ANCHO, ALTO);
        sb.draw(Assets.barraTareas, 0, 0, ANCHO, 50);

        for (Icono ico : iconos) {
            ico.actualizar();
            ico.dibujar(sb, sr);
        }

        sb.end();
        sr.end();
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 v3CoordenadasDePantalla = new Vector3(screenX, screenY, 0);
        Vector3 v3CoordenadasDeMundo = camera.unproject(v3CoordenadasDePantalla);


        for (Icono ico : iconos) {
            System.out.println("Y: "+ v3CoordenadasDeMundo.y);

            if (ico.getHitBox().contains(v3CoordenadasDeMundo.x, v3CoordenadasDeMundo.y)) {
                switch (ico.pantalla) {
                    case SPOTIFY: pantallaAnterior.setScreen(new Spotify(pantallaAnterior));
                }
            } else {
                System.out.println("Afuera");
            }

        }
        return false;
    }

}
