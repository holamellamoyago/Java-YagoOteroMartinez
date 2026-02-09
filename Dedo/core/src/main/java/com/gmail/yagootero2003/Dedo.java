package com.gmail.yagootero2003;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.Rectangle;

public class Dedo extends Objeto {
    public Estado estado;
    private Texture imagen;

    public Dedo(Texture imagen) {
        this.imagen = imagen;
        this.estado = Estado.PARADO;

        super.ancho = (int) Math.ceil(Pantalla.ANCHO * 0.1); // cuadrado
        super.alto = (int) Math.ceil(Pantalla.ANCHO * 0.1);

        super.x = 0;
        super.y = Pantalla.ALTO / 2;
        super.hitBox = new Rectangle((int) x, (int) y, ancho, alto);

    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {
        if (estado == Estado.PARADO) return;

        if (estado == Estado.BAJANDO) {
            y -= deltaTime * Pantalla.VELOCIDAD;
        }

        if (estado == Estado.SUBIENDO) {
            y += deltaTime * Pantalla.VELOCIDAD;
        }

        hitBox.y = (int) y;
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {
        sb.draw(Assets.dedo, x, y, ancho, alto);
        sr.rect(x, y, ancho, alto);
    }
}
