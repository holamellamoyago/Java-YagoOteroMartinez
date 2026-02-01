package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.Mundo;
import com.gmail.yagootero2003.pantallas.Pantalla;

import java.awt.Rectangle;

// TODO Cambiar a personaje
public class Pez extends Personaje {
    private boolean yendoDerecha;

    public Pez(TextureRegion texture) {
        super(texture);

        // Medidas, 20% de alto , 25% de ancho
        alto = 20 * Pantalla.ANCHO / 100;
        ancho = 25 * Pantalla.ALTO / 100;

        // Posicion X, empieza a la drch -> izq
        x = Pantalla.ALTO + texture.getRegionX();

        // Posición Y
        y = 0;

        // Empieza yendo hacia la izquierda
        yendoDerecha = false;

        hitBox = new Rectangle((int) x, (int) (alto / 2), (int) Math.floor(ancho * 0.2), (int) Math.floor(ancho * 0.2));
    }

    @Override
    public void actualiza(float delta) {
        if (direccion == Direccion.PESCADO) {
            y = Mundo.anzuelo.y;
            return;
        }

        if (yendoDerecha) {
            x += VELOCIDAD * delta;
            hitBox.x = (int) x;

            if ((x) >= (Pantalla.ALTO + Math.abs(ancho))) {
                yendoDerecha = !yendoDerecha;

                // TODO Flip
                ancho = Math.abs(ancho);
            }

        } else {
            x -= VELOCIDAD * delta;
            hitBox.x = (int) x;


            if ((x + texture.getRegionWidth()) <= 0) {
                yendoDerecha = !yendoDerecha;
                ancho = -Math.abs(ancho);
            }

        }


    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr) {
        sb.draw(texture, x, y, ancho, alto);
        sr.rect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }

}
