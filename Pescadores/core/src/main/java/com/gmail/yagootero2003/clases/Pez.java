package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.pantallas.Pantalla;

// TODO Cambiar a personaje
public class Pez extends Personaje {
    private boolean yendoDerecha;

    public Pez (TextureRegion texture) {
        super(texture);

        // Medidas, 20% de alto , 25% de ancho
        alto = 20 * Pantalla.ANCHO / 100;
        ancho = 25 * Pantalla.ALTO / 100;

        // Posicion X, empieza a la drch -> izq
        x = Pantalla.ALTO + texture.getRegionX();
        //POSICION_X = 0;

        // Posición Y
        //POSICION_Y = Screen.SCREEN_HEIGH - textureRegion.getRegionY();
        y = 0;

        // Empieza yendo hacia la izquierda
        yendoDerecha = false;
    }

    @Override
    public void actualiza(float delta) {
        if (yendoDerecha) {
            x += VELOCIDAD * delta;

//            System.out.println("\nPOSICION X: " + posicionX);
//            System.out.println("screen width : " + Mundo.ALTO);
//            System.out.println("medida ancho : " + medidaAncho);

            if ((x) >= (Pantalla.ALTO + Math.abs(ancho))) {
                yendoDerecha = !yendoDerecha;

                // TODO Flip
                ancho = Math.abs(ancho);
            }

        } else {
            x -= VELOCIDAD * delta;

            if ((x + texture.getRegionWidth()) <= 0) {
                yendoDerecha = !yendoDerecha;
                ancho = -Math.abs(ancho);
            }

        }
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr) {sb.draw(texture, x, y, ancho, alto);}

}
