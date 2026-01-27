package com.gmail.yagootero2003.so;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.so.screens.Escritorio;

import java.awt.Rectangle;

public class Icono {
    private float x, y;
    private float ANCHO = 100, ALTO = 100;
    private Texture texture;

    private Rectangle hitBox;

    public Icono(String texture) {
        this.texture = new Texture(Gdx.files.internal(texture));

        x = calcularX();
        y = calcularY();
        hitBox = new Rectangle();
    }

    public void actualizar() {

    }

    public void dibujar(SpriteBatch sb, ShapeRenderer sr) {
        sb.draw(texture, x, y, ANCHO, ALTO);
        //sr.rect(x,y,ANCHO, ALTO);
    }

    private float calcularX() {
        int maxIconosAncho = (int) Math.floor(Gdx.graphics.getWidth() / ANCHO);
        int maxIconosAlto = (int) Math.floor(Gdx.graphics.getHeight() / ALTO);

        return (200 * Escritorio.iconos.size()) + 50;
    }

    private float calcularY() {
        return  texture.getHeight() - 50;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public Texture getTexture() {
        return texture;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }
}
