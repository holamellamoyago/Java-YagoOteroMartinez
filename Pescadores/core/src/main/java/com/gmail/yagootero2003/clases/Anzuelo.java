package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gmail.yagootero2003.Mundo;

import java.util.Random;

public class Anzuelo {

    private TextureRegion texture;
    private float medidaAncho, medidaAlto, x, y;
    private final int VELOCIDAD = 4;
    public DireccionAnzuelo direccion;

    public Anzuelo(TextureRegion texture) {
        this.texture = texture;

        // Medidas, 20% de alto , 25% de ancho
        medidaAlto = 5 * Mundo.ANCHO / 100;
        medidaAncho = 5 * Mundo.ALTO / 100;

        // Posicion X, empieza a la drch -> izq
        x = Mundo.pescador.x + Mundo.pescador.medidaAncho;


        // Posición Y
        //POSICION_Y = Screen.SCREEN_HEIGH - textureRegion.getRegionY();
        y = 60 * Mundo.ALTO / 100;

        // Empieza yendo hacia la izquierda
        direccion = DireccionAnzuelo.PARADO;
    }

    public void actualizar() {
        x = (Mundo.pescador.x + Mundo.pescador.medidaAncho) - 20;

        if (direccion == DireccionAnzuelo.BAJANDO) {
            y-=VELOCIDAD;

            if (y <= 0) direccion = DireccionAnzuelo.SUBIENDO;
        } else if (direccion == DireccionAnzuelo.SUBIENDO) {
            y+= VELOCIDAD;

            if (y>= Mundo.pescador.y) direccion = DireccionAnzuelo.PARADO;
        }

    }

    public void dibujar(Batch batch) {
        batch.draw(texture, x, y, medidaAncho, medidaAlto);
    }
}
