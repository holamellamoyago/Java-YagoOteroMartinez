package com.gmail.yagootero2003;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

import javax.sound.sampled.Line;

public class Numero extends Objeto {
    private int numero;
    public BitmapFont fuente;


    public Numero() {
        this.numero = new Random().nextInt(Pantalla.NUM_MAXIMO) + Pantalla.NUM_MINIMO;
        this.fuente = new BitmapFont();
        fuente.getData().setScale(1.5f);
        fuente.setColor(Color.RED);

        super.ancho = (int) Math.ceil(Pantalla.ANCHO * 0.05); // cuadrado
        super.alto = (int) Math.ceil(Pantalla.ANCHO * 0.05); // cuadrado
        super.x = Pantalla.ANCHO + ancho;
        super.y = 200;
    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {
        super.x -= deltaTime * Pantalla.VELOCIDAD;
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {
        fuente.draw(sb, String.valueOf(numero), x, y);
        sr.rect(x, y, ancho, alto);


    }
}
