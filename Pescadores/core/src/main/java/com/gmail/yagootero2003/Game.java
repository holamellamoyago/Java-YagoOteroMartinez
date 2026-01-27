package com.gmail.yagootero2003;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.gmail.yagootero2003.pantallas.Pantalla;
import com.gmail.yagootero2003.pantallas.PantallaInicial;
import com.gmail.yagootero2003.pantallas.PantallaJuego;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Game extends com.badlogic.gdx.Game {
    public Pantalla[] pantallas = new Pantalla[2];
    public Pantalla pantallaActual;


    @Override
    public void create() {
        Assets.cargarTexturas();


        pantallas[0] = new PantallaInicial(this);
        pantallas[1] = new PantallaJuego();
        pantallaActual = pantallas[0];
    }

    @Override
    public void resize(int width, int height) {
        pantallaActual.resize(width, height);
    }


    @Override
    public void render() {
        pantallaActual.render(Gdx.graphics.getDeltaTime());
    }


    @Override
    public void dispose() {
        if (pantallaActual != null) pantallaActual.dispose();
    }

    public void setScreen (Pantalla screen) {
        //TODO Lo más probable es que estoy creando un nuevo screen cuando
        // ya lo puede tener AplicationListener de por si

//        if (this.screen != null) this.screen.hide();
//        this.screen = screen;
//        if (this.screen != null) {
//            this.screen.show();
//            this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        }
        this.pantallaActual.hide();
        this.pantallaActual = screen;
        this.pantallaActual.show();
        this.pantallaActual.resize(0,0);


    }

}
