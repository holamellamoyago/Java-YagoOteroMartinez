package com.gmail.yagootero2003.objetos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gmail.yagootero2003.clases.Assets;
import com.gmail.yagootero2003.clases.Config;
import com.gmail.yagootero2003.pantallas.PantallaPrincipal;

public class Hilo extends Objeto {
    private TextureRegion texture;
    public Hilo() {
        texture = new TextureRegion(Assets.pescador);
        ancho = 1;
        alto = PantallaPrincipal.calcularDiferenciaHilo();

        x = PantallaPrincipal.pescador.getX() + PantallaPrincipal.pescador.getAncho();
        y = PantallaPrincipal.pescador.getY() + PantallaPrincipal.anzuelo.getAlto();

        hitBox = new Rectangle(x, y, ancho, alto);
    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {
        final float ESPACIO_MINIMO_X = PantallaPrincipal.pescador.getX() + PantallaPrincipal.pescador.getAncho();
        final float ESPACIO_MINIMO_Y = PantallaPrincipal.pescador.getY() + PantallaPrincipal.anzuelo.getAlto();
        x = ESPACIO_MINIMO_X;
        y = ESPACIO_MINIMO_Y;

//        if (PantallaPrincipal.pescador.direccion == Direccion.ABAJO) {
//            alto -= deltaTime * Config.VELOCIDAD;
//            y = ESPACIO_MINIMO_Y;
//        }

        hitBox.x = x;
        hitBox.y = y;
    }

    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {
        sb.draw(texture, x, y, ancho, alto);
        sr.rect(x, y, ancho, alto);
    }
}
