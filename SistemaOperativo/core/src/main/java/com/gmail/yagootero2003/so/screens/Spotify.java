package com.gmail.yagootero2003.so.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;


public class Spotify extends Pantalla{
    public Spotify(Game juego) {
        super(juego);

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GREEN);
    }
}
