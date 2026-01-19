package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gmail.yagootero2003.Screen;

public class Pez {
    private TextureRegion textureRegion;
    private float MEDIDA_ANCHO, MEDIDA_ALTO, POSICION_X, POSICION_Y;
    private final int VELOCIDAD = 4;
    private boolean yendoDerecha;

    public Pez (TextureRegion texture) {
        this.textureRegion = texture;

        // Medidas, 20% de alto , 25% de ancho
        MEDIDA_ALTO = 20 * Screen.SCREEN_HEIGH / 100;
        MEDIDA_ANCHO = 25 * Screen.SCREEN_WIDTH / 100;

        // Posicion X, empieza a la drch -> izq
        POSICION_X = Screen.SCREEN_WIDTH + textureRegion.getRegionX();
        //POSICION_X = 0;

        // Posición Y
        //POSICION_Y = Screen.SCREEN_HEIGH - textureRegion.getRegionY();
        POSICION_Y = 0;

        // Empieza yendo hacia la izquierda
        yendoDerecha = false;
    }

    public void dibujar(Batch batch) {

        if (yendoDerecha) {
            //POSICION_X += VELOCIDAD;


//            if (POSICION_X <= (Screen.SCREEN_WIDTH) + MEDIDA_ANCHO) {
//                yendoDerecha = !yendoDerecha;
//            }

        } else {
            POSICION_X -= VELOCIDAD;

            if (textureRegion.getRegionX() <= 0) {
                System.out.println("Ahora debería de ir a la derecha");
                POSICION_X = Screen.SCREEN_WIDTH;
            }

        }

        batch.draw(textureRegion, POSICION_X, POSICION_Y, MEDIDA_ANCHO, MEDIDA_ALTO);
    }


}
