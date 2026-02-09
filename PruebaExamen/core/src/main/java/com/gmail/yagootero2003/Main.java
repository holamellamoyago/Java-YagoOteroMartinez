package com.gmail.yagootero2003;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.pantallas.PantallaPrincipal;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private Screen pantalla;

    @Override
    public void create() {
        this.pantalla = new PantallaPrincipal(this);
        setScreen(pantalla);
    }
}
