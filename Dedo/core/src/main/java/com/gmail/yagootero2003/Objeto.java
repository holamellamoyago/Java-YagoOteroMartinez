package com.gmail.yagootero2003;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Objeto {
    protected float x, y;
    protected int ancho, alto;

    public abstract void actualiza(SpriteBatch sb, float deltaTime);
    public abstract void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime);



}
