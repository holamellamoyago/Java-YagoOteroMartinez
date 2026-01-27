package com.gmail.yagootero2003.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.Assets;
import com.gmail.yagootero2003.Game;

public class PantallaInicial extends Pantalla implements InputProcessor {
    Game game;
    public PantallaInicial(Game game) {
        sb = new SpriteBatch();
        sr = new ShapeRenderer();
        camara = new OrthographicCamera();
        this.game = game;

        Gdx.input.setInputProcessor(this);
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
        Assets.fuente.draw(sb, "Click o pulsa J para jugar",  (ANCHO/ 2) -  150, ALTO / 2);

        sb.end();
        sr.end();
    }

    @Override
    public void resize(int width, int height) {
        camara.setToOrtho(false, ANCHO, ALTO);
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
        sb.dispose();
        sr.dispose();
    }


    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case Input.Keys.J: {
                System.out.println("Detectada");
                game.setScreen(game.pantallas[1]);
            }
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
