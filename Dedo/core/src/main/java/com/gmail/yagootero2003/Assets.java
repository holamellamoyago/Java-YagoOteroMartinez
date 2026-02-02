package com.gmail.yagootero2003;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static Texture dedo;
    public static BitmapFont fuente;


    public static void cargarTexturas(){
		dedo = new Texture(Gdx.files.internal("dedo.png"));
        fuente = new BitmapFont();
        fuente.getData().setScale(1.5f);
        fuente.setColor(Color.RED);


    }

	public static void liberarTexturas(){
		dedo.dispose();
//		captura.dispose();
//		musicaDeFondo.dispose();
//		finDelJuego.dispose();
//		fuente.dispose();
//		atlas.dispose();
	}
}
