package com.gmail.yagootero2003.so.screens;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Pantalla extends InputAdapter implements Screen {
    protected ShapeRenderer sr;
    protected SpriteBatch sb;
    protected OrthographicCamera camara;
    public int ancho, alto;




}
