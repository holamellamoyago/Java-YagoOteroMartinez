package com.gmail.yagootero2003;

import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gmail.yagootero2003.clases.Pez;

import java.util.ArrayList;
import java.util.List;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private List<Pez> peces;

    @Override
    public void create() {
        Assets.cargarTexturas();
        batch = new SpriteBatch();
        peces = new ArrayList<Pez>();

        peces.add(new Pez(Assets.pezAzul));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();

        dibujarPersonajes();
        //batch.draw(Assets.pezAzul, 0 , 0);

        batch.end();
    }

    private void dibujarPersonajes() {
//        for (int i = peces.size(); i > 0 ; i--) {
//            peces.get(i).dibujar(batch);
//        }

        for (int i = 0; i < peces.size(); i++) {
            peces.get(i).dibujar(batch);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
