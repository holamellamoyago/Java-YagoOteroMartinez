package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.Assets;
import com.gmail.yagootero2003.Mundo;
import com.gmail.yagootero2003.clases.Anzuelo;
import com.gmail.yagootero2003.clases.Pescador;
import com.gmail.yagootero2003.clases.Pez;
import com.gmail.yagootero2003.clases.Sedal;

import java.util.ArrayList;
import java.util.List;

public class PantallaJuego extends  Pantalla{


    public static List<Pez> peces = new ArrayList<>();
    public static Pescador pescador;
    public static Anzuelo anzuelo;
    public static Sedal sedal;
    public PantallaJuego() {

        sb = new SpriteBatch();
        sr = new ShapeRenderer();

        Mundo.pescador = new Pescador(Assets.pescador);
        Mundo.peces.add(new Pez(Assets.pezAzul));
        Mundo.anzuelo = new Anzuelo(Assets.anzuelo);
        Mundo.sedal = new Sedal(Assets.sedal);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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
