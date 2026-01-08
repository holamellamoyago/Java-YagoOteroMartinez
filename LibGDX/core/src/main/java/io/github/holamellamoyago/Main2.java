package io.github.holamellamoyago;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main2 extends ApplicationAdapter {
    private Random rdm;
    private SpriteBatch batch;
    private Texture image;
    private Color colorFondo;

    private float SCREEN_WIDTH, SCREEN_HEIGHT, VELOCIDAD;
    private float posicionXimagen, tamanoImagen, orientacionXimagen;

    private boolean adelante;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("img.png");
        rdm = new Random();

        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();
        colorFondo = new Color(0.3f, 0.3f, 0.2f, 1f); // Color inicial
        tamanoImagen = (float) (SCREEN_HEIGHT * 0.2);
        orientacionXimagen = tamanoImagen;
        adelante = true;

        VELOCIDAD = 4;
    }

    @Override
    public void render() {
        ScreenUtils.clear(colorFondo);


        batch.begin();


        if (adelante) {
            posicionXimagen += VELOCIDAD;
            orientacionXimagen = -tamanoImagen;

            if (posicionXimagen >= SCREEN_WIDTH) {
                adelante = false;
                posicionXimagen = SCREEN_WIDTH - tamanoImagen;
                cambiarColorAleatorio();
            }
        } else {
            posicionXimagen -= VELOCIDAD;
            orientacionXimagen = tamanoImagen;

            if (posicionXimagen <= 0) {
                adelante = true;
                posicionXimagen = tamanoImagen;
                cambiarColorAleatorio();
            }
        }

        batch.draw(image, posicionXimagen, SCREEN_HEIGHT / 2, orientacionXimagen, tamanoImagen);





        batch.end();
    }

    private void cambiarColorAleatorio() {
        // LibGDX usa valores de 0 a 1 (float)
        colorFondo.set(rdm.nextFloat(), rdm.nextFloat(), rdm.nextFloat(), 1f);
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
