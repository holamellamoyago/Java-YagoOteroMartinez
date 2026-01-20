package com.gmail.yagootero2003;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.gmail.yagootero2003.clases.Pescador;
import com.gmail.yagootero2003.clases.Pez;

import java.util.ArrayList;
import java.util.List;

public class Mundo {
    public static final int ANCHO = 480, ALTO = 480;

    public static List<Pez> peces = new ArrayList<>();
    public Pescador pescador = new Pescador();

    public static void actualizarPersonajes() {
        pescador.


        for (Pez pez : peces) {
            pez.actualizar();
        }
    }

    public static void dibujarPersonajes(Batch batch) {

        for (Pez pez : peces) {
            pez.dibujar(batch);
        }

    }
}
