package com.gmail.yagootero2003;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PantallaJuego extends InputAdapter implements Screen {
    private SpriteBatch sb;
    private ShapeRenderer sr;

    private OrthographicCamera camara;

    private Dedo dedo;

    private Game juego;

    private float delta, stateTime, stateTimeProximoPez;

    private List<Numero> numeros;


    public PantallaJuego(Main main) {
        Assets.cargarTexturas();

        this.juego = main;
        sr = new ShapeRenderer();
        sb = new SpriteBatch();
        camara = new OrthographicCamera();
        delta = Gdx.graphics.getDeltaTime();
        dedo = new Dedo(Assets.dedo);
        stateTime = 0;
        numeros = new ArrayList<>();

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setColor(Color.RED);
        sb.begin();

        stateTime += delta;
        if (stateTime > stateTimeProximoPez) generarNumero();

        dedo.actualizar(sb, delta);
        for (Numero num : numeros) {
            num.actualiza(sb, delta);
        }

        dedo.dibujar(sb, sr);
        for (Numero num : numeros) {
            num.dibuja(sb, sr, delta);
        }

        sb.end();
        sr.end();
    }

    private void generarNumero() {
        @SuppressWarnings("NewApi") float x = new Random().nextFloat(Pantalla.STATE_MAXIMO) + Pantalla.STATE_MINIMO;
        stateTimeProximoPez += x;

        System.out.println("Se genera número");
        numeros.add(new Numero());


    }

    @Override
    public void resize(int width, int height) {
        camara.setToOrtho(false, Pantalla.ANCHO, Pantalla.ALTO);
        camara.update();
        sb.setProjectionMatrix(camara.combined); // SpriteBatch
        sr.setProjectionMatrix(camara.combined);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        sr.dispose();
        sb.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (dedo.estado != Estado.PARADO) return false;


        switch (keycode) {
            case Input.Keys.W: {
                dedo.estado = Estado.SUBIENDO;
            }
            break;

            case Input.Keys.S: {
                dedo.estado = Estado.BAJANDO;
            }
            break;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (dedo.estado == Estado.PARADO) return false;

        switch (keycode) {
            case Input.Keys.W: {

                // Si la tecla S fue pulsada antes de W, ósea estaba bajando
                // antes de darle a la w
//                if (dedo.estado == Estado.BAJANDO) return false;
                dedo.estado = Estado.PARADO;
            }
            break;

            case Input.Keys.S: {
//                if (dedo.estado == Estado.SUBIENDO) return false;
                dedo.estado = Estado.PARADO;
            }
            break;
        }

        return false;
    }
}
