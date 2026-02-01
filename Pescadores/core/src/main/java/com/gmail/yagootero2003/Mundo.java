package com.gmail.yagootero2003;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Array;
import com.gmail.yagootero2003.clases.Anzuelo;
import com.gmail.yagootero2003.clases.Direccion;
import com.gmail.yagootero2003.clases.Pescador;
import com.gmail.yagootero2003.clases.Pez;
import com.gmail.yagootero2003.clases.Sedal;



public class Mundo {

    public static Array<Pez> peces = new Array<>();
    public static Pescador pescador;
    public static Anzuelo anzuelo;
    public static Sedal sedal;

    public static void actualizarPersonajes(float delta) {
        pescador.actualiza(delta);
        anzuelo.actualiza(delta);
        sedal.actualiza(delta);


        for (Pez pez : peces) {
            pez.actualiza(delta);
        }
    }

    public static void dibujarPersonajes(SpriteBatch sb, ShapeRenderer sr) {
        pescador.dibuja(sb, sr);
        anzuelo.dibuja(sb, sr);
        sedal.dibuja(sb, sr);

        for (Pez pez : peces) {
            pez.dibuja(sb, sr);
        }

    }

    public static void mostrarFondo(SpriteBatch sb) {
        sb.draw(Assets.fondo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public static void comprobarPescadosVivos() {
        for (Pez pez : peces) {
            if (pez.direccion == Direccion.OCUPADO) {
                peces.removeValue(pez, true);
            }
        }
    }
}
