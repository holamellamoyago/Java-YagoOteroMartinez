package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.escuchadores.TecladoJuego;

public abstract class Pantalla implements Screen {
    public static final int ANCHO = 480, ALTO = 480;
    protected SpriteBatch sb;
    protected ShapeRenderer sr;
    protected OrthographicCamera camara;

    protected InputProcessor escuchador;





}
