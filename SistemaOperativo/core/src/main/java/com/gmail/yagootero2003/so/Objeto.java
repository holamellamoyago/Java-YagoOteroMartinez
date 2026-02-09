package com.gmail.yagootero2003.so;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


public abstract class Objeto {
    protected float x, y;
    public int ancho, alto;
    protected Rectangle hitBox;
    protected Texture texture;

    public Objeto(Texture texture, int ancho, int alto) {
        this.texture = texture;
        this.ancho = ancho;
        this.alto = alto;
        this.hitBox = new Rectangle(x, y, ancho, alto);
    }



    public abstract void actualiza(SpriteBatch sb, float deltaTime);
    public abstract void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime);



}
