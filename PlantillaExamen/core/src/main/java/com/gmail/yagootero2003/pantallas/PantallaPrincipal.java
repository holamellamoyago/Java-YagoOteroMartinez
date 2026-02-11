package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.Cuadrado;
import com.gmail.yagootero2003.clases.Assets;
import com.gmail.yagootero2003.clases.Estado;

import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;

public class PantallaPrincipal extends Pantalla {
    private float tiempoTotal;
    private static Array<Cuadrado> cuadrados = new Array<>();

    public PantallaPrincipal(Game pantalla) {
        super(pantalla);
        tiempoTotal = 0f;

        // Inicio los cuadrados con
        for (int i = 0; i < 4; i++) {
            anadirFilaCuadrados();
        }

    }

    public static void anadirFilaCuadrados() {
        for (int i = 0; i < 5; i++) {
            anadirCuadrado();
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        sr.begin(ShapeRenderer.ShapeType.Line);
        sb.begin();

        mostrarTiempoTotal(delta);
        for (Cuadrado c : cuadrados) c.actualiza(sb, delta);
        for (Cuadrado c : cuadrados) c.dibuja(sb, sr, delta);

        comprobarCuadradosAfuera();


        sb.end();
        sr.end();
    }

    private void comprobarCuadradosAfuera() {
        for(Cuadrado c : cuadrados) {
            if (c.estado == Estado.FUERA_DE_PANTALLA) cuadrados.removeValue(c, true);
        }
    }

    private void mostrarTiempoTotal(float delta) {
        tiempoTotal += delta;
        Assets.fuente.draw(sb, String.format("%.1f", tiempoTotal) + " Segundos", Pantalla.calcularAncho(0.05), Pantalla.calcularAlto(0.95));
    }

    private static void anadirCuadrado() {
        cuadrados.add(new Cuadrado(cuadrados.size / 5, cuadrados.size% 5));
    }
}
