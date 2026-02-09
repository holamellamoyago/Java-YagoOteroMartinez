package com.gmail.yagootero2003;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

import java.util.Objects;

public class Bala extends Objeto {
    protected Circle hitBox;


    public Bala(PantallaJuego pantalla) {
        x = pantalla.dedo.ancho;
        y = pantalla.dedo.y + ((float) pantalla.dedo.alto / 2);
        ancho = (int) Math.ceil(Pantalla.ALTO * 0.05);
        alto = (int) Math.ceil(Pantalla.ALTO * 0.05);
        hitBox = new Circle(x,y,Pantalla.RADIO_BALA);
    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {
        x += deltaTime * Pantalla.VELOCIDAD;
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {
        sr.circle(x,y,Pantalla.RADIO_BALA);
    }
}
