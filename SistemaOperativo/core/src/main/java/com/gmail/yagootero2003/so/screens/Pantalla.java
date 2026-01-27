package com.gmail.yagootero2003.so.screens;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Pantalla implements Screen, InputProcessor {
    protected ShapeRenderer sr;
    protected SpriteBatch sb;
    protected OrthographicCamera camara;
    protected int ancho, alto;



}
