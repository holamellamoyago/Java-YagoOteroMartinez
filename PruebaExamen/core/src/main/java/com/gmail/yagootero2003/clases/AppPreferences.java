package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppPreferences {
    private static AppPreferences appPreferences;
    private Preferences preferences;
    private Map<String, float[]> datos = new HashMap<>();

    public AppPreferences() {
        final String TITULO_RECORDS = "Records";
        preferences = Gdx.app.getPreferences(TITULO_RECORDS);
        recuperarDatos();


    }

    public static AppPreferences getInstance() {
        if (appPreferences == null) appPreferences = new AppPreferences();

        return appPreferences;
    }

    private void recuperarDatos() {
        datos = (Map<String, float[]>) preferences.get();
        System.out.println(datos);
    }

    public void setRecord(int dificultad, float tiempo) {
        String dif = String.valueOf(dificultad);
        float[] recordsPorDificultad = datos.get(dif);

        for (int i = 0; i < recordsPorDificultad.length; i++) {
            if (recordsPorDificultad[i] < tiempo) {
                recordsPorDificultad[i] = tiempo;
                return;
            }

            if (i <= 2) {
                recordsPorDificultad[recordsPorDificultad.length + 1] = tiempo;
                return;
            }
        }

        datos.put(String.valueOf(dificultad): )
    }
}
