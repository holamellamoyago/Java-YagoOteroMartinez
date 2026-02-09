package com.gmail.yagootero2003.so;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gmail.yagootero2003.so.screens.Escritorio;
import com.gmail.yagootero2003.so.screens.Pantalla;
import com.gmail.yagootero2003.so.screens.Pantallas;


public class Icono extends Objeto {
    public Pantallas pantalla;

    public Icono(String strTexture, Pantallas pantalla) {
        super(new Texture(Gdx.files.internal(strTexture)), 100, 100 );
        this.pantalla = pantalla;
        x = calcularX();
        y = calcularY();

    }

    public void actualizar() {
        hitBox = new Rectangle((int) x, (int) y, super.ancho, alto);
    }

    public void dibujar(SpriteBatch sb, ShapeRenderer sr) {
        sb.draw(texture, x, y, ancho, alto);
        sr.rect(x,y,ancho, alto);
    }

    private float calcularX() {
        //int maxIconosAncho = (int) Math.floor(Gdx.graphics.getWidth() / ancho);
        //int maxIconosAlto = (int) Math.floor(Gdx.graphics.getHeight() / alto);

        return (200 * Escritorio.iconos.size) + 50;
    }

    private float calcularY() {
        return Escritorio.ALTO - alto - 50; // Usa la altura de la ventana
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {

    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {

    }
}
