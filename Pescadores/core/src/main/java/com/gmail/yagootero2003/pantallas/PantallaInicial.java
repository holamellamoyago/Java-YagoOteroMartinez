package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.Assets;
import com.gmail.yagootero2003.escuchadores.TecladoJuego;

public class PantallaInicial extends Pantalla {

    public PantallaInicial() {
        sb = new SpriteBatch();
        sr = new ShapeRenderer();
        camara = new OrthographicCamera();
        escuchador = new TecladoJuego();

        Gdx.input.setInputProcessor(new TecladoJuego());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);

        sr.begin(ShapeRenderer.ShapeType.Line);
        sb.begin();

        sb.draw(Assets.fondo, 0, 0, ANCHO, ALTO);
        //sb.draw(Assets.fuente.getRegion(), 0,0, 100, 200);
        Assets.fuente.draw(sb, "Click o pulsa J para jugar",  ANCHO / 2 , ALTO / 2);

        sb.end();
        sr.end();
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

    }


}
