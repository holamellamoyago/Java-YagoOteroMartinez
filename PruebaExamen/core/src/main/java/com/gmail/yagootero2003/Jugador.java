package com.gmail.yagootero2003;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gmail.yagootero2003.clases.Config;
import com.gmail.yagootero2003.clases.Objeto;
import com.gmail.yagootero2003.pantallas.Pantalla;

import java.awt.Rectangle;

public class Jugador extends Objeto {
    public static DireccionEnemigo direccion;
    public Rectangle hitBox;

    public Jugador() {
        direccion = DireccionEnemigo.PARADO;
        ancho = 50;
        alto = 50;


        ancho = Pantalla.calcularAncho(0.05);
        alto = Pantalla.calcularAncho(0.05);

        x = Pantalla.ANCHO / 2 - ancho;
        y = Pantalla.ALTO / 2 - alto;

        hitBox = new Rectangle((int) x, (int) y, ancho, alto);
    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {
        switch (direccion) {
            case ARRIBA: {
                y -= deltaTime * Config.VELOCIDAD;
            }
            break;

            case ABAJO: {
                y += deltaTime * Config.VELOCIDAD;
            }
            break;
        }

        alto += 1;
        ancho += 1;

        hitBox = new Rectangle((int) x, (int) y, ancho, alto);
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {
        sr.rect(x, y, ancho, alto);
    }


}
