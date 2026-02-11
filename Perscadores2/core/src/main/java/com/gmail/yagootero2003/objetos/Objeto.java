package com.gmail.yagootero2003.objetos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


public abstract class Objeto {
    protected float x, y;
    protected float ancho, alto;

    protected Rectangle hitBox;


//    public Objeto(float x, float y, int ancho, int alto) {
//        this.x = x;
//        this.y = y;
//        this.ancho = ancho;
//        this.alto = alto;
//    }

    public abstract void actualiza(SpriteBatch sb, float deltaTime);

    public abstract void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime);

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getAncho() {
        return ancho;
    }

    public float getAlto() {
        return alto;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }
}
