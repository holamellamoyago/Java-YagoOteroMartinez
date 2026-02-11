package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.clases.Assets;
import com.gmail.yagootero2003.clases.Config;
import com.gmail.yagootero2003.clases.Records;
import com.gmail.yagootero2003.objetos.Direccion;
import com.gmail.yagootero2003.objetos.Hilo;
import com.gmail.yagootero2003.objetos.Objeto;
import com.gmail.yagootero2003.objetos.PescadoAzul;
import com.gmail.yagootero2003.objetos.Pescador;

import java.util.Random;


public class PantallaPrincipal extends Pantalla {
    private float tiempoTotal;
    private Records records;

    public static Pescador pescador;
    public static Hilo hilo;
    public static Azuelo anzuelo;
    public static Array<PescadoAzul> peces = new Array<>();
    public Array<Objeto> objetos = new Array<>();


    public PantallaPrincipal(Game pantalla) {
        super(pantalla);
        tiempoTotal = 0f;
        records = Records.getInstance();

        pescador = new Pescador();
        anzuelo = new Azuelo();
        hilo = new Hilo();

        objetos.addAll(pescador, anzuelo, hilo);
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
        tiempoTotal += delta;

        sb.draw(Assets.fondo, 0, 0, Pantalla.ANCHO, Pantalla.ALTO);
        mostrarTiempoTotal();

        generacionPeces();

        for (Objeto ob : objetos) ob.actualiza(sb, delta);
        for (Objeto ob : objetos) ob.dibuja(sb, sr, delta);

        for (PescadoAzul ob : peces) ob.actualiza(sb, delta);
        for (PescadoAzul ob : peces) ob.dibuja(sb, sr, delta);


        sb.end();
        sr.end();
    }

    private void generacionPeces() {
        Random rdm = new Random();

        if (tiempoTotal >= Config.SEGUNDOS_ENTRE_PECES){
            tiempoTotal = 0;
            peces.add(new PescadoAzul());

        }
    }


    private void mostrarTiempoTotal() {

        Assets.fuente.draw(sb, String.format("%.1f", tiempoTotal) + " Segundos", Pantalla.calcularAncho(0.05), Pantalla.calcularAlto(0.95));
    }

    @Override
    public boolean keyDown(int keycode) {
        if (pescador.direccion != Direccion.PARADO) return false;

        switch (keycode) {
            case Input.Keys.F: {
                Gdx.app.exit();
            }
            break;

            case Input.Keys.LEFT: {
                pescador.direccion = Direccion.IZQUIERDA;
            }
            break;

            case Input.Keys.RIGHT: {
                pescador.direccion = Direccion.DERECHA;
            }
            break;

            case Input.Keys.SPACE: {
                pescador.direccion = Direccion.ABAJO;
            }
            break;

            default: {
            }
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.F: {
                Gdx.app.exit();
            }
            break;

            case Input.Keys.LEFT: {
                if (pescador.direccion == Direccion.DERECHA) return false;
                pescador.direccion = Direccion.PARADO;

            }
            break;

            case Input.Keys.RIGHT: {
                if (pescador.direccion == Direccion.IZQUIERDA) return false;
                pescador.direccion = Direccion.PARADO;
            }
            break;



            default: {
            }
        }

        return true;

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 v3CoordenadasDePantalla = new Vector3(screenX, screenY, 0);
        Vector3 v3CoordenadasDeMundo = camera.unproject(v3CoordenadasDePantalla);

        if (pescador.getHitBox().contains(v3CoordenadasDeMundo.x, v3CoordenadasDeMundo.y))
            System.out.println("Pescador tocado");

        return false;
    }

    public static float calcularDiferenciaHilo() {
        return (pescador.getY() + pescador.getAlto()) - (anzuelo.getY() + anzuelo.getAlto());
    }
}
