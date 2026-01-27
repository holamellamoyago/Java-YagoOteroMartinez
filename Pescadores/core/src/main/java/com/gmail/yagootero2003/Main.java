package com.gmail.yagootero2003;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.gmail.yagootero2003.pantallas.Pantalla;
import com.gmail.yagootero2003.pantallas.PantallaInicial;
import com.gmail.yagootero2003.pantallas.PantallaJuego;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends Game {
    public static Pantalla[] pantallas = new Pantalla[2];
    public static Pantalla pantallaActual;


    @Override
    public void create() {
        Assets.cargarTexturas();

        pantallas[0] = new PantallaInicial();
        pantallas[1] = new PantallaJuego();
        pantallaActual = pantallas[0];

        //camara = new OrthographicCamera();





    }

    @Override
    public void resize(int width, int height) {
        pantallaActual.resize(width, height);
    }


    @Override
    public void render() {
        pantallaActual.render(Gdx.graphics.getDeltaTime());

//        ScreenUtils.clear(1, 1, 1, 1);
//        float delta = Gdx.graphics.getDeltaTime();
//
//        setScreen(pantallaActual);

//        sr.begin(ShapeRenderer.ShapeType.Line);
//        sb.begin();
//
//
//        //sb.draw(Assets.fondo, 0, 0, Mundo.ANCHO, Mundo.ALTO);
//
//        Mundo.actualizarPersonajes(delta);
//        Mundo.dibujarPersonajes(sb, sr);
//
//        sb.end();
//        sr.end();

    }


    @Override
    public void dispose() {
//        sb.dispose();
//        sr.dispose();
    }

    public void setScreen (Screen screen) {
        if (this.screen != null) this.screen.hide();
        this.screen = screen;
        if (this.screen != null) {
            this.screen.show();
            this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

}
