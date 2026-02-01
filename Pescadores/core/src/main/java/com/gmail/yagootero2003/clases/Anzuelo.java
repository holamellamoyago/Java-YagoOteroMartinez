package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.Game;
import com.gmail.yagootero2003.Mundo;
import com.gmail.yagootero2003.pantallas.Pantalla;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Anzuelo extends Personaje {

    public DireccionAnzuelo direccion;
    private Pez pezCapturado;


    public Anzuelo(TextureRegion texture) {
        super(texture);

        // Medidas, 20% de alto , 25% de ancho
        alto = 5 * Pantalla.ANCHO / 100;
        ancho = 5 * Pantalla.ALTO / 100;

        // Posicion X, empieza a la drch -> izq
        x = Mundo.pescador.x + Mundo.pescador.ancho;


        // Posición Y
        //POSICION_Y = Screen.SCREEN_HEIGH - textureRegion.getRegionY();
        y = 60 * Pantalla.ALTO / 100;

        // Empieza yendo hacia la izquierda
        direccion = DireccionAnzuelo.PARADO;
    }

    @Override
    public void actualiza(float delta) {
        x = (Mundo.pescador.x + Mundo.pescador.ancho) - 20;

        if (direccion == DireccionAnzuelo.BAJANDO) {
            y -= VELOCIDAD * delta;

            if (y <= 0) direccion = DireccionAnzuelo.SUBIENDO;
        } else if (direccion == DireccionAnzuelo.SUBIENDO) {
            y += VELOCIDAD * delta;

            for (Pez pez : Mundo.peces) {
                if (pezCapturado != null) break;

                if (pez.hitBox.contains(x, y)) {
                    pezCapturado = pez;
                    pez.direccion = Direccion.PESCADO;
                }
            }

            if (y >= Mundo.pescador.y) {
                if (pezCapturado != null) {
                    pezCapturado.direccion = Direccion.OCUPADO;
                    pezCapturado = null;
                }

                direccion = DireccionAnzuelo.PARADO;

            }
        }
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr) {
        sb.draw(texture, x, y, ancho, alto);
        sr.rect(x, y, ancho, alto);
    }

}
