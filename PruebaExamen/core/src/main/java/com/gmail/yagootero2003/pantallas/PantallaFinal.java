package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

public class PantallaFinal extends Pantalla{
    public PantallaFinal(Game pantalla) {
        super(pantalla);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GREEN);
    }
}
