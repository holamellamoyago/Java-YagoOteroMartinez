package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class Records {
    // SingleTon
    private static Records records;
    private static Preferences preferences;
    final String BASE = "record_";


    public static Records getInstance(){
        if (records == null) {
            records = new Records();
            preferences = Gdx.app.getPreferences("records");
        }

        return records;

    }

    private void comprobarGuardarRecord(int dificultad, float tiempo){
        //TODO Comprobar si es menor

        preferences.putString(BASE + dificultad, String.format("%.1f", tiempo));

        // Importante
        preferences.flush();
    }

    public String buscarRecord(int dificultad) {
        return preferences.getString(BASE + dificultad, "SIN RECORD");
    }
}
