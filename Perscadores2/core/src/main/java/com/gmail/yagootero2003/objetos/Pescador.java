package com.gmail.yagootero2003.objetos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gmail.yagootero2003.clases.Assets;
import com.gmail.yagootero2003.clases.Config;
import com.gmail.yagootero2003.pantallas.Pantalla;
import com.gmail.yagootero2003.pantallas.PantallaPrincipal;

public class Pescador extends Objeto {

    // Se pone afuera por si no es una texture, pasaría lo mismo con hitBox
    private TextureRegion texture;
    public Direccion direccion;

    public Pescador() {
        texture = Assets.pescador;
        direccion = Direccion.PARADO;

        ancho = (float) ((float) Pantalla.ALTO * 0.2);
        alto = ancho;

        x = (float) Pantalla.ANCHO / 2 - ancho / 2;
        y = (float) (Pantalla.ALTO * 0.65);

        hitBox = new Rectangle(x, y, ancho, alto);
    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {
        if (direccion == Direccion.IZQUIERDA && x >= 0) x -= deltaTime * Config.VELOCIDAD;

        final float MARGEN_DERECHO = Pantalla.ANCHO -  PantallaPrincipal.anzuelo.ancho;
        // Cojo toda la pantalla - el ancho porqué 0 es izquierda
        if (direccion == Direccion.DERECHA && PantallaPrincipal.anzuelo.getX() <= MARGEN_DERECHO) x += deltaTime * Config.VELOCIDAD;



        hitBox.x = x;
        hitBox.y = y;
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {
        sb.draw(texture, x, y, ancho, alto);
        sr.rect(x, y, ancho, alto);
    }
}
