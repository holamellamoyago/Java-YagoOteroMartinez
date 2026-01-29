//package com.gmail.yagootero2003.so;
//
//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.utils.ScreenUtils;
//import com.gmail.yagootero2003.so.screens.Escritorio;
//import com.gmail.yagootero2003.so.screens.Pantalla;
//
///** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
//public class Game2 extends ApplicationAdapter {
//    private Pantalla pantalla;
//
//    @Override
//    public void create() {
//        Assets.cargarTexturas();
//        pantalla = new Escritorio(this);
//        Gdx.input.setInputProcessor(pantalla);
//
//    }
//
//    @Override
//    public void render() {
//        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
//        pantalla.render(Gdx.graphics.getDeltaTime());
//
//    }
//
//    @Override
//    public void dispose() {
//        pantalla.dispose();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        pantalla.resize(pantalla.ancho, pantalla.alto);
//    }
//}
