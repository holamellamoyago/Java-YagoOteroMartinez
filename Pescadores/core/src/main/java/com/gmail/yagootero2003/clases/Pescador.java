package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gmail.yagootero2003.Assets;
import com.gmail.yagootero2003.Mundo;

public class Pescador {
    private TextureRegion textureRegion;
    private float medidaAncho, medidaAlto, posicionX, posicionY;
    private final int VELOCIDAD = 4;
    private boolean yendoDerecha;

    public Pescador() {
        this.textureRegion = Assets.pescador;

        // Medidas, 20% de alto , 25% de ancho
        medidaAlto = 20 * Mundo.ANCHO / 100;
        medidaAncho = 25 * Mundo.ALTO / 100;

        // Posicion X, empieza a la drch -> izq
        posicionX = Mundo.ALTO + textureRegion.getRegionX();
        //POSICION_X = 0;

        // Posición Y
        //POSICION_Y = Screen.SCREEN_HEIGH - textureRegion.getRegionY();
        posicionY = 70 * Mundo.ALTO / 100;

        // Empieza yendo hacia la izquierda
        yendoDerecha = false;
    }
}
