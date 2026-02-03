package com.gmail.yagootero2003;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PantallaResultado extends Pantalla {

    private MotivoPerdida motivo;

    public PantallaResultado (Game pantallaAnterior, MotivoPerdida motivo) {
        super(pantallaAnterior);
        Assets.cargarTexturas();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        sb.begin();

        Assets.fuente.draw(sb, "Hola", 20, 20);

        sb.end();
    }


}
