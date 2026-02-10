package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.Cuadrado;
import com.gmail.yagootero2003.clases.Assets;

import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;

public class PantallaPrincipal extends Pantalla {
    private float tiempoTotal;
    private Array<Cuadrado> cuadrados = new Array<>();

    public PantallaPrincipal(Game pantalla) {
        super(pantalla);
        tiempoTotal = 0f;
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();
        anadirCuadrado();


    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        sr.begin(ShapeRenderer.ShapeType.Line);
        sb.begin();

        mostrarTiempoTotal(delta);
        for (Cuadrado c : cuadrados) c.actualiza(sb, delta);
        for (Cuadrado c : cuadrados) c.dibuja(sb, sr, delta);


        sb.end();
        sr.end();
    }

    private void mostrarTiempoTotal(float delta) {
        tiempoTotal += delta;
        Assets.fuente.draw(sb, String.format("%.1f", tiempoTotal) + " Segundos", Pantalla.calcularAncho(0.05), Pantalla.calcularAlto(0.95));
    }

    private void anadirCuadrado() {
        cuadrados.add(new Cuadrado(cuadrados.size / 5, cuadrados.size% 5));
    }
}
