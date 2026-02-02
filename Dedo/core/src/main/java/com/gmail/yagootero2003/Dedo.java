package com.gmail.yagootero2003;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Dedo {
    public Estado estado;
    private Texture imagen;
    private int ancho, alto;

    private float x, y;

    public Dedo(Texture imagen) {
        this.imagen = imagen;

        ancho = (int) Math.ceil(Pantalla.ANCHO * 0.1); // cuadrado
        alto = (int) Math.ceil(Pantalla.ANCHO * 0.1);

        x = 0;
        y = Pantalla.ALTO / 2;

        estado = Estado.PARADO;
    }

    public void actualizar(SpriteBatch sb, float deltaTime) {
        if (estado == Estado.PARADO) return;

        if (estado == Estado.BAJANDO) {
            y -= deltaTime * Pantalla.VELOCIDAD;
        }

        if (estado == Estado.SUBIENDO) {
            y += deltaTime * Pantalla.VELOCIDAD;
        }
    }

    public void dibujar(SpriteBatch sb, ShapeRenderer sr) {
        sb.draw(Assets.dedo, x, y, ancho, alto);
        sr.rect(x, y, ancho, alto);

    }
}
