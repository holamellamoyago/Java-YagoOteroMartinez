package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.Rectangle;

public abstract class Personaje {
    public TextureRegion texture;
    public float ancho, alto, x, y;
    protected final int VELOCIDAD = 80;
    public Direccion direccion;

    protected Rectangle hitBox;

    public Personaje(TextureRegion texture) {
        this.texture = texture;
    }

    public Personaje(TextureRegion texture, Direccion direccion, float ancho, float alto, float x, float y) {
        this.texture = texture;
        this.direccion = direccion;
        this.ancho = ancho;
        this.alto = alto;
        this.x = x;
        this.y = y;

        this.hitBox = new Rectangle();
    }

    abstract public void actualiza(float delta);
    abstract public void dibuja(SpriteBatch sb, ShapeRenderer sr);
}
