package com.gmail.yagootero2003;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import javax.sound.sampled.Line;

public class Numero extends Objeto {
    private int numero;
    public BitmapFont fuente;

    private ArrayList<Bala> balasPasadas = new ArrayList<>();

    protected Rectangle hitBox;

    protected boolean isCirculo;


    public Numero() {
        this.numero = new Random().nextInt(Pantalla.NUM_MAXIMO) + Pantalla.NUM_MINIMO;
        this.fuente = new BitmapFont();
        fuente.getData().setScale(1f);
        fuente.setColor(Color.RED);


        super.ancho = (int) Math.ceil(Pantalla.ANCHO * 0.05); // cuadrado
        super.alto = (int) Math.ceil(Pantalla.ANCHO * 0.05); // cuadrado
        super.x = Pantalla.ANCHO + ancho;
        super.y = new Random().nextInt(Pantalla.ALTO) + (float) (Pantalla.ALTO * 15) / 100;

        if (super.y + alto > Pantalla.ALTO) {
            super.y = Pantalla.ALTO - super.alto;
        }

        hitBox = new Rectangle((int) x, (int) y, ancho, alto);
        isCirculo = new Random().nextBoolean();

        System.out.println("Numero: " + numero + ", Y:" + y);

    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {
        super.x -= deltaTime * Pantalla.VELOCIDAD;
        hitBox.x = (int) super.x;
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {

        fuente.draw(sb, String.valueOf(numero), super.x, super.y);

//        if (hitBox instanceof Rectangle) {
//            Rectangle rectanglerHitBox = (Rectangle) hitBox;
//            fuente.draw(sb, String.valueOf(numero), (int) rectanglerHitBox.getCenterX(), (int) rectanglerHitBox.getCenterY());
//        } else {
//            Circle circleHitBox = (Circle) hitBox;
//            fuente.draw(sb, String.valueOf(numero), (int) circleHitBox.x, (int) circleHitBox.y);
//        }

        if (isCirculo) {
            float radio = hitBox.width / 2f;
            sr.circle(hitBox.x + radio, hitBox.y + radio,  radio);
        } else {
            sr.rect(x, y, ancho, alto);
        }
    }

    public boolean quitarVida(Bala bala) {
        if (balasPasadas.contains(bala)) return false;

        numero--;
        balasPasadas.add(bala);

        // Retornamos True si el número se queda sin vidas
        if (numero <= 0) return true;
        return false;
    }


}
