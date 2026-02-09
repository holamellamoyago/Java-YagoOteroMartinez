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

public class PantallaJuego extends Pantalla {

    protected Dedo dedo;

    protected float delta, stateTime, stateTimeProximoPez;

    public Array<Numero> numeros;
    protected Array<Bala> balas;

    private int vidasRestantes;


    public PantallaJuego(Main main) {
        super(main);
        Assets.cargarTexturas();

        dedo = new Dedo(Assets.dedo);
        stateTime = 0;
        numeros = new Array<>();
        balas = new Array<>();
        vidasRestantes = Pantalla.VIDAS_INICIALES;

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

        dedo.actualiza(sb, delta);
        for (Numero num : numeros) {
            num.actualiza(sb, delta);
        }


        // Primero movemos posicion, después comprobamos
        for (Bala bala : balas) {
            bala.actualiza(sb, delta);
            comprobarColisionesBalas(bala);
        }


        // Dibujar
        dedo.dibuja(sb, sr, delta);
        for (Numero num : numeros) {
            num.dibuja(sb, sr, delta);
        }
        for (Bala bala : balas) {
            bala.dibuja(sb, sr, delta);
        }

        comprobarPosicionesNumeros();
        mostrarInformacion(sb);


        sb.end();
        sr.end();
    }

    private void comprobarPosicionesNumeros() {
        for (Numero n : numeros) {
            if (dedo.hitBox.contains(n.x, n.y)) abrirPantallaFinal(MotivoPerdida.BALA_TOCO_MANO);

            // Comprobación si el número llega al final de su recorrido
            if (n.x <= 0) {
                numeros.removeValue(n, true);
                vidasRestantes--;
            }
            if (vidasRestantes == 0) abrirPantallaFinal(MotivoPerdida.NO_MAS_VIDAS);

        }




    }

    private void generarNumero() {
        @SuppressWarnings("NewApi") float x = new Random().nextFloat(Pantalla.STATE_MAXIMO) + Pantalla.STATE_MINIMO;
        stateTimeProximoPez += x;

        numeros.add(new Numero());


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

    private void comprobarColisionesBalas(Bala bala) {
        for (Numero numero : numeros) {
            //if (numero.hitBox.contains(dedo.ancho, dedo.y)) abrirPantallaFinal(MotivoPerdida.BALA_TOCO_MANO);


            if (numero.hitBox.contains(bala.x, bala.y)) {

                // Quito una vida al número , si queda a 0 devuelve true y se elimina
                if (numero.quitarVida(bala)) numeros.removeValue(numero, true);

                // Elimino la bala
                //balas.removeValue(bala, true);
            }
        }
    }

    private void abrirPantallaFinal(MotivoPerdida motivoPerdida) {
        super.game.setScreen(new PantallaResultado(super.game, motivoPerdida));
    }

    private void mostrarInformacion(SpriteBatch sb) {
        Assets.fuente.draw(sb, "Te quedan " + vidasRestantes + " vidas y J balas restantes", Pantalla.ANCHO * 0.05f, (Pantalla.ALTO * 0.1f));
    }
}
