package com.gmail.yagootero2003;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.clases.Anzuelo;
import com.gmail.yagootero2003.clases.EscuchadorTeclado;
import com.gmail.yagootero2003.clases.Pescador;
import com.gmail.yagootero2003.clases.Pez;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch sb;
    private ShapeRenderer sr;
    private Texture image;
    OrthographicCamera camara;


    @Override
    public void create() {
        camara = new OrthographicCamera();
        sb = new SpriteBatch();
        sr = new ShapeRenderer();

        Gdx.input.setInputProcessor(new EscuchadorTeclado());

        Assets.cargarTexturas();
        Mundo.pescador = new Pescador(Assets.pescador);
        Mundo.peces.add(new Pez(Assets.pezAzul));
        Mundo.anzuelo = new Anzuelo(Assets.anzuelo);
    }

    @Override public void resize(int width, int height) {
        camara.setToOrtho(false, Mundo.ANCHO,Mundo.ALTO);
        camara.update();
        sb.setProjectionMatrix(camara.combined); // SpriteBatch
        //sr.setProjectionMatrix(camara.combined); // ShapeRenderer
    }


    @Override
    public void render() {
        ScreenUtils.clear(1,1,1,1);

        sb.begin();


        sb.draw(Assets.fondo,0,0, Mundo.ANCHO, Mundo.ALTO);

        Mundo.actualizarPersonajes();
        Mundo.dibujarPersonajes(sb);

        //batch.draw(Assets.pezAzul, 0 , 0);

        sb.end();

    }



    @Override
    public void dispose() {
        sb.dispose();
    }
}
