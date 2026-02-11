package com.gmail.yagootero2003.objetos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gmail.yagootero2003.clases.Assets;
import com.gmail.yagootero2003.pantallas.Pantalla;

import java.util.Random;

public class PescadoAzul extends  Objeto {
    private TextureRegion texture;
    @SuppressWarnings("NewApi")
    public PescadoAzul() {
        texture = Assets.pez;
        ancho = (float) ((float) Pantalla.ALTO * 0.1);
        alto = ancho;

        x = 0 + ancho;
        y = new Random().nextFloat((float) (Pantalla.ALTO * 0.2)) + alto;

        hitBox = new Rectangle(x, y, ancho, alto);
    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {

    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {
        sb.draw(texture, x, y, ancho, alto);
        sr.rect(x, y, ancho, alto);
    }
}
