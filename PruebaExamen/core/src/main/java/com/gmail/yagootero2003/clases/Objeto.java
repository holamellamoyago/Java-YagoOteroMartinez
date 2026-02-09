package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.Rectangle;

public abstract class Objeto {
    protected float x, y;
    protected int ancho, alto;

    public Rectangle hitBox;


//    public Objeto(float x, float y, int ancho, int alto) {
//        this.x = x;
//        this.y = y;
//        this.ancho = ancho;
//        this.alto = alto;
//    }

    public abstract void actualiza(SpriteBatch sb, float deltaTime);

    public abstract void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime);


}
