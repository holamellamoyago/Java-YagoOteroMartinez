package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.clases.Assets;
import com.gmail.yagootero2003.clases.Config;
import com.gmail.yagootero2003.clases.Records;
import com.gmail.yagootero2003.objetos.Insecto;

import java.util.ArrayList;


public class PantallaPrincipal extends Pantalla {
    private Records records;
    private float tiempoTotal;
    private ArrayList<Insecto> insectos = new ArrayList<>();

    private int numInsectosActuales = Config.NUM_INSECTOS_INICIALES;
    private String record;


    public PantallaPrincipal(Game pantalla) {
        super(pantalla);
        tiempoTotal = 0f;
        insectos.add(new Insecto());
        records = Records.getInstance();
        record = records.buscarRecord(numInsectosActuales);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);

        sr.begin(ShapeRenderer.ShapeType.Line);
        sb.begin();

        mostrarTextos(delta);


        for (Insecto in : insectos) in.actualiza(sb, delta);
        for (Insecto in : insectos) in.dibuja(sb, sr, delta);

        sb.end();
        sr.end();
    }


    private void mostrarTextos(float delta) {
        tiempoTotal += delta;
        Assets.fuente.draw(sb, String.format("%.1f", tiempoTotal) + " Segundos", Pantalla.calcularAncho(0.05), Pantalla.calcularAlto(0.95));
        Assets.fuente.draw(sb, String.format("Jugando con " + numInsectosActuales + " a la vez"), Pantalla.calcularAncho(0.05), Pantalla.calcularAlto(0.9));
        Assets.fuente.draw(sb, String.format("Record: " + record + " con ese num de insectos"), Pantalla.calcularAncho(0.05), Pantalla.calcularAlto(0.85));
        Assets.fuente.draw(sb, "INSECTOS", Pantalla.calcularAncho(0.05), Pantalla.calcularAlto(0.80));

    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.F: {
                Gdx.app.exit();
            }
            break;

            case Input.Keys.NUM_1: {
                actualizarNumInsectos(1);
            }
            break;

            case Input.Keys.NUM_2: {
                actualizarNumInsectos(2);
            }
            break;
            case Input.Keys.NUM_3: {
                actualizarNumInsectos(3);
            }
            break;
            case Input.Keys.NUM_4: {
                actualizarNumInsectos(4);
            }
            break;
            case Input.Keys.NUM_5: {
                actualizarNumInsectos(5);
            }
            break;
            case Input.Keys.NUM_6: {
                actualizarNumInsectos(6);
            }
            break;
            case Input.Keys.NUM_7: {
                actualizarNumInsectos(7);
            }
            break;
            case Input.Keys.NUM_8: {
                actualizarNumInsectos(8);
            }
            break;
            case Input.Keys.NUM_9: {
                actualizarNumInsectos(9);
            }
            break;


            default: {
            }
        }

        return true;
    }

    private void actualizarNumInsectos(int numeroInsectos) {
        this.numInsectosActuales = numeroInsectos;
        this.record = Records.getInstance().buscarRecord(numeroInsectos);
    }


}
