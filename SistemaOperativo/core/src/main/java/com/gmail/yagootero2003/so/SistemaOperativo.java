package com.gmail.yagootero2003.so;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.so.screens.Escritorio;
import com.gmail.yagootero2003.so.screens.Pantalla;

public class SistemaOperativo extends Game {
    public Pantalla pantalla;

    @Override
    public void create() {
        Assets.cargarTexturas();
        pantalla = new Escritorio(this);
        Gdx.input.setInputProcessor(pantalla);
        setScreen(pantalla);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        super.render();
    }


    @Override
    public void dispose() {
        super.dispose();
    }
}
