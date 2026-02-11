package com.gmail.yagootero2003;

import com.badlogic.gdx.Game;
import com.gmail.yagootero2003.clases.Assets;
import com.gmail.yagootero2003.pantallas.Pantalla;
import com.gmail.yagootero2003.pantallas.PantallaPrincipal;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends Game {
    private Pantalla pantalla;

    @Override
    public void create() {
        Assets.cargarRecursos();
        pantalla = new PantallaPrincipal(this);
        setScreen(pantalla);
    }


}
