package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.DireccionEnemigo;
import com.gmail.yagootero2003.Enemigo;
import com.gmail.yagootero2003.Jugador;

public class PantallaPrincipal extends Pantalla {
    private Array<Enemigo> enemigos = new Array<>();
    private Jugador jugador;
    float tiempoEntreTiempos = 10;
    float tiempoTotal = 0;

    public PantallaPrincipal(Game pantalla) {
        super(pantalla);
        enemigos.add(new Enemigo());
        jugador = new Jugador();

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        sr.begin(ShapeRenderer.ShapeType.Line);
        sb.begin();
        tiempoTotal += delta;


        System.out.println(tiempoTotal);
        if (tiempoTotal >= tiempoEntreTiempos) {
            tiempoTotal = 0;
            enemigos.add(new Enemigo());
            System.out.println("Enemigo inicializado");
        }

        jugador.actualiza(sb, delta);
        for (Enemigo e : enemigos) {
            e.actualiza(sb, delta);

            // Esto tiene que ir aquí para comprobar colisiones
            jugador.dibuja(sb, sr, delta);
            comprobarcolisiones(e);
            e.dibuja(sb, sr, delta);
        }

        sb.end();
        sr.end();

    }

    private void comprobarcolisiones(Enemigo e) {
        if (e.hitBox.contains(jugador.hitBox)) {

        }

        if (jugador.hitBox.contains(e.hitBox))game.setScreen(new PantallaFinal(game));

    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W: {
                Jugador.direccion = DireccionEnemigo.ARRIBA;
            }
            break;

            case Input.Keys.S: {
                Jugador.direccion = DireccionEnemigo.ABAJO;
            }
            break;

            default: {
            }
        }

        return false;
    }

    ;
}
