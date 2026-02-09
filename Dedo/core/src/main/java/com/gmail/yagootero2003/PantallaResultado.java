package com.gmail.yagootero2003;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class PantallaResultado extends Pantalla {

    private MotivoPerdida motivo;

    public PantallaResultado (Game pantallaAnterior, MotivoPerdida motivo) {
        super(pantallaAnterior);
        Assets.cargarTexturas();
        this.motivo = motivo;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLUE);
        sb.begin();

        String motivoPerdida = "";
        switch (motivo) {
            case BALA_TOCO_MANO : motivoPerdida = "Un número tocó el dedo"; break;
            case NO_MAS_VIDAS : motivoPerdida = "Te quedaste sin vidas"; break;
        }

        Assets.fuente.draw(sb, motivoPerdida, 20, 20);

        sb.end();
    }


}
