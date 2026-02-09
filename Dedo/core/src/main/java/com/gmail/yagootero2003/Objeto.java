package com.gmail.yagootero2003;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.Rectangle;

public abstract class Objeto {
    protected float x, y;
    protected int ancho, alto;
    protected Rectangle hitBox;



    public abstract void actualiza(SpriteBatch sb, float deltaTime);
    public abstract void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime);



}
