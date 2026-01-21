package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gmail.yagootero2003.Assets;
import com.gmail.yagootero2003.Mundo;

import java.util.Random;


public class Pescador {
    private TextureRegion texture;
    private float medidaAncho, medidaAlto, x, y;
    private final int VELOCIDAD = 4;
    public Direccion direccion;

    public Pescador(TextureRegion texture) {
        this.texture = texture;

        // Medidas, 20% de alto , 25% de ancho
        medidaAlto = 20 * Mundo.ANCHO / 100;
        medidaAncho = 25 * Mundo.ALTO / 100;

        // Posicion X, empieza a la drch -> izq
        x = new Random().nextInt(Mundo.ANCHO);
            ;
        //POSICION_X = 0;

        // Posición Y
        //POSICION_Y = Screen.SCREEN_HEIGH - textureRegion.getRegionY();
        y = 60*Mundo.ALTO / 100;

        // Empieza yendo hacia la izquierda
        direccion = Direccion.PARADO;
    }

    public void actualizar() {
        if (direccion == Direccion.DERECHA) {
            if (x >= (Mundo.ANCHO) - medidaAncho) return;
            x++;
            return;
        }

        if (direccion == Direccion.IZQUIERDA) {
            if ((x) <= 0) return;
            x--;
        }
    }

    public void dibujar(Batch batch) {
        batch.draw(texture, x, y, medidaAncho, medidaAlto);
    }


}
