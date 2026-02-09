package com.gmail.yagootero2003;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.clases.Config;
import com.gmail.yagootero2003.clases.Objeto;
import com.gmail.yagootero2003.pantallas.Pantalla;

import java.awt.Rectangle;
import java.util.Random;

public class Enemigo extends Objeto {
    public DireccionEnemigo direccion;

    @SuppressWarnings("NewApi")
    public Enemigo() {

        alto = 50;
        ancho = 50;

        // Configuro si empieza a la derecha o izq
        if (new Random().nextBoolean()) {
            x = 0;
            direccion = DireccionEnemigo.DERECHA;
        } else {
            x = Pantalla.ANCHO - ancho;
            direccion = DireccionEnemigo.IZQUIERDA;
        }


        // posicion vertical
        y = new Random().nextFloat(Pantalla.ALTO - alto);


        hitBox = new Rectangle((int) x, (int) y, ancho, alto);
    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {

        if (direccion == DireccionEnemigo.DERECHA) {

            x += deltaTime * Config.VELOCIDAD;
            if (x >= Pantalla.ANCHO) {
                direccion = DireccionEnemigo.IZQUIERDA;
            }
        } else {
            x -= deltaTime * Config.VELOCIDAD;
            if (x <= 0) {
                direccion = DireccionEnemigo.DERECHA;
            }
        }

        hitBox.x = (int) x;
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {
        sr.rect(x, y, ancho, alto);
    }
}
