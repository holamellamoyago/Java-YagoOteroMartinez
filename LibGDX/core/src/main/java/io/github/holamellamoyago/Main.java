package io.github.holamellamoyago;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;

    private float SCREEN_WIDTH, SCREEN_HEIGHT, VELOCIDAD;
    private float posicionXimagen, tamanoImagen, orientacionXimagen;

    private boolean adelante;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("img.png");

        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();
        tamanoImagen = (float) (SCREEN_HEIGHT * 0.2);
        orientacionXimagen = tamanoImagen;
        adelante = true;

        VELOCIDAD = 1;
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();


        if (adelante) {
            posicionXimagen += VELOCIDAD;
            orientacionXimagen = -tamanoImagen;

            if (posicionXimagen >= SCREEN_WIDTH) {
                adelante = false;
                posicionXimagen = SCREEN_WIDTH - tamanoImagen;
            }
        } else {
            posicionXimagen -= VELOCIDAD;
            orientacionXimagen = tamanoImagen;

            if (posicionXimagen <= 0) {
                adelante = true;
                posicionXimagen = tamanoImagen;
            }
        }

        batch.draw(image, posicionXimagen, SCREEN_HEIGHT / 2, orientacionXimagen, tamanoImagen);


        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
