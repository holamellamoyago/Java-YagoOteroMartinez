package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.Mundo;

import java.awt.Rectangle;

public class Sedal extends Personaje {

    private Rectangle rectangle;

    public Sedal(TextureRegion texture) {
        super(texture);
        x = Mundo.anzuelo.x + (Mundo.anzuelo.ancho);
        y = (Mundo.pescador.y + Mundo.pescador.alto) - 80;
        alto = 50;
        ancho = 2;
    }

    @Override
    public void actualiza(float delta) {
        if (Mundo.anzuelo.direccion == DireccionAnzuelo.BAJANDO) {
            y -= VELOCIDAD * delta;
            alto += VELOCIDAD * delta;
        }
        if (Mundo.anzuelo.direccion == DireccionAnzuelo.SUBIENDO) {
            y += VELOCIDAD * delta;
            alto -= VELOCIDAD * delta;
        }
        x = Mundo.anzuelo.x + (Mundo.anzuelo.ancho / 2);

    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr) {
        sb.draw(texture, x, y, ancho, alto);
        sr.rect(x, y, ancho, alto);
    }
}
