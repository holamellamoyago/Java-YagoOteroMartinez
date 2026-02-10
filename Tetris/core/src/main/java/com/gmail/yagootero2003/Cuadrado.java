package com.gmail.yagootero2003;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gmail.yagootero2003.clases.Config;
import com.gmail.yagootero2003.clases.Estado;
import com.gmail.yagootero2003.clases.Objeto;
import com.gmail.yagootero2003.pantallas.Pantalla;


public class Cuadrado extends Objeto {
    private Estado estado;

    public Cuadrado(int fila, int columna) {
        estado = Estado.MOVIENDOSE;
        ancho = Pantalla.calcularAncho(0.2);
        alto = ancho;

        x = ancho * columna;
        y = -((fila * ancho) - alto);
        hitBox = new Rectangle(x, y, ancho, alto);
    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {
        y += deltaTime * Config.VELOCIDAD;

        if (y>= Pantalla.ALTO) resetearObjeto();
    }

    private void resetearObjeto() {
        // TODO Si se toco volver a rellenar y tal
        y = 0;
        y = y - alto;
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {
        sr.setColor(Color.RED);
        sr.rect(x, y, ancho, alto);
    }
}
