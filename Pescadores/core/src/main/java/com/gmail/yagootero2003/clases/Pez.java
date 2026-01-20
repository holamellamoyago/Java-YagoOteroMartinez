package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gmail.yagootero2003.Mundo;

public class Pez {
    private TextureRegion textureRegion;
    private float medidaAncho, medidaAlto, posicionX, posicionY;
    private final int VELOCIDAD = 4;
    private boolean yendoDerecha;

    public Pez (TextureRegion texture) {
        this.textureRegion = texture;

        // Medidas, 20% de alto , 25% de ancho
        medidaAlto = 20 * Mundo.ANCHO / 100;
        medidaAncho = 25 * Mundo.ALTO / 100;

        // Posicion X, empieza a la drch -> izq
        posicionX = Mundo.ALTO + textureRegion.getRegionX();
        //POSICION_X = 0;

        // Posición Y
        //POSICION_Y = Screen.SCREEN_HEIGH - textureRegion.getRegionY();
        posicionY = 0;

        // Empieza yendo hacia la izquierda
        yendoDerecha = false;
    }

    public void actualizar() {
        if (yendoDerecha) {
            posicionX += VELOCIDAD;

            System.out.println("\nPOSICION X: " + posicionX);
            System.out.println("screen width : " + Mundo.ALTO);
            System.out.println("medida ancho : " + medidaAncho);

            if ((posicionX) >= (Mundo.ALTO + Math.abs(medidaAncho))) {
                yendoDerecha = !yendoDerecha;
                medidaAncho = Math.abs(medidaAncho);
            }

        } else {
            posicionX -= VELOCIDAD;

            if ((posicionX + textureRegion.getRegionWidth()) <= 0) {
                yendoDerecha = !yendoDerecha;
                medidaAncho = -Math.abs(medidaAncho);
            }

        }
    }

    public void dibujar(Batch batch) {



        batch.draw(textureRegion, posicionX, posicionY, medidaAncho, medidaAlto);
    }


}
