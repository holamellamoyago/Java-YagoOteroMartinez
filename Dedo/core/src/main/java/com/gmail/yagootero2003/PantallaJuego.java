package com.gmail.yagootero2003;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class PantallaJuego extends InputAdapter implements Screen {
    private SpriteBatch sb;
    private ShapeRenderer sr;

    private OrthographicCamera camara;

    protected Dedo dedo;

    protected Game juego;

    protected float delta, stateTime, stateTimeProximoPez;

    public Array<Numero> numeros;
    protected Array<Bala> balas;


    public PantallaJuego(Main main) {
        Assets.cargarTexturas();

        this.juego = main;
        sr = new ShapeRenderer();
        sb = new SpriteBatch();
        camara = new OrthographicCamera();
        delta = Gdx.graphics.getDeltaTime();
        dedo = new Dedo(Assets.dedo);
        stateTime = 0;
        numeros = new Array<>();
        balas = new Array<>();

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

        // Primero movemos posicion, después comprobamos

        for (Bala bala : balas) {
            bala.actualiza(sb, delta);
            comprobarColisiones(bala);
        }

        // Dibujar
        dedo.dibujar(sb, sr);
        for (Numero num : numeros) {
            num.dibuja(sb, sr, delta);
        }
        for (Bala bala : balas) {
            bala.dibuja(sb, sr, delta);
        }

        sb.end();
        sr.end();
    }

    private void generarNumero() {
        @SuppressWarnings("NewApi") float x = new Random().nextFloat(Pantalla.STATE_MAXIMO) + Pantalla.STATE_MINIMO;
        stateTimeProximoPez += x;

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

            case Input.Keys.SPACE: {
                lanzarBala();
            }
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

    private void lanzarBala() {
        balas.add(new Bala(this));
    }

    private void comprobarColisiones(Bala bala) {
        for (Numero numero : numeros) {
            if (numero.hitBox.contains(dedo.x, dedo.y)) abrirPantallaFinal(MotivoPerdida.BALA_TOCO_MANO);


                if (numero.hitBox.contains(bala.x, bala.y)) {

                    // Quito una vida al número , si queda a 0 devuelve true y se elimina
                    if (numero.quitarVida(bala)) numeros.removeValue(numero, true);

                    // Elimino la bala
                    balas.removeValue(bala, true);
                }
        }
    }

    private void abrirPantallaFinal(MotivoPerdida motivoPerdida) {
        juego.setScreen(new PantallaResultado(juego, motivoPerdida));
    }
}
