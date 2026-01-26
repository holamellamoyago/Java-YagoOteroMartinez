package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.Mundo;

import java.util.Random;


public class Pescador extends Personaje {


    public Pescador(TextureRegion texture) {
        super(texture);

        // Medidas, 20% de alto , 25% de ancho
        alto = 20 * Mundo.ANCHO / 100;
        ancho = 25 * Mundo.ALTO / 100;

        // Posicion X, empieza a la drch -> izq
        x = new Random().nextInt(Mundo.ANCHO);

        //POSICION_Y = Screen.SCREEN_HEIGH - textureRegion.getRegionY();
        y = 60 * Mundo.ALTO / 100;

        // Empieza yendo hacia la izquierda
        direccion = Direccion.PARADO;
    }

    @Override
    public void actualiza(float delta) {
        if (direccion == Direccion.DERECHA) {
            if (x >= (Mundo.ANCHO) - ancho) return;
            x += VELOCIDAD * delta;
            return;
        }

        if (direccion == Direccion.IZQUIERDA) {
            if ((x) <= 0) return;
            x -= VELOCIDAD * delta;
        }
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr) {
        sb.draw(texture, x, y, ancho, alto);
        sr.rect(x, y, ancho, alto);
    }


}
