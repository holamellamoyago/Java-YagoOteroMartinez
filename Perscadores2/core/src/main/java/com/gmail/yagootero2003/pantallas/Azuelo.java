package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gmail.yagootero2003.clases.Assets;
import com.gmail.yagootero2003.clases.Config;
import com.gmail.yagootero2003.objetos.Direccion;
import com.gmail.yagootero2003.objetos.Objeto;
import com.gmail.yagootero2003.objetos.Pescador;

public class Azuelo extends Objeto {
    private Sprite texture;


    public Azuelo() {
        texture = new Sprite(Assets.anzuelo);
        texture.flip(texture.isFlipX(), false);


        ancho = (float) (Pantalla.ANCHO * 0.05);
        alto = ancho;

        x = PantallaPrincipal.pescador.getAncho() + PantallaPrincipal.pescador.getX() - 15;
        y = PantallaPrincipal.pescador.getY();


        hitBox = new Rectangle(x, y, ancho, alto);
    }

    @Override
    public void actualiza(SpriteBatch sb, float deltaTime) {
        x = PantallaPrincipal.pescador.getAncho() + PantallaPrincipal.pescador.getX() - 15;
        //y = PantallaPrincipal.pescador.getY();


        if (PantallaPrincipal.pescador.direccion == Direccion.ABAJO) {
            System.out.println("Pescador bajando");
            y -= deltaTime * Config.VELOCIDAD;

            if (y <= 0) PantallaPrincipal.pescador.direccion = Direccion.ARRIBA;
        }

        if (PantallaPrincipal.pescador.direccion == Direccion.ARRIBA) {
            y += deltaTime * Config.VELOCIDAD;

            if (y >= PantallaPrincipal.pescador.getY())
                PantallaPrincipal.pescador.direccion = Direccion.PARADO;
        }

        hitBox.x = x;
        hitBox.y = y;
    }


    @Override
    public void dibuja(SpriteBatch sb, ShapeRenderer sr, float deltaTime) {
        sb.draw(texture, x, y, ancho, alto);
        sr.rect(x, y, ancho, alto);
    }
}
