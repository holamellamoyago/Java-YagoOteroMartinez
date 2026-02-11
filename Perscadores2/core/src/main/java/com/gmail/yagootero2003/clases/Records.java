package com.gmail.yagootero2003.clases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class Records {
    // SingleTon
    private static Records records;
    private static Preferences preferences;
    final String BASE = "record_";


    public static Records getInstance() {
        if (records == null) {
            records = new Records();
            preferences = Gdx.app.getPreferences("records");
        }

        return records;

    }

    public void comprobarGuardarRecord(int dificultad, float tiempoTotal) {

        String strRecordAnterior = buscarRecord(dificultad);
        System.out.println("Record: " + strRecordAnterior);

        if (strRecordAnterior.equals(Config.MENSAJE_NO_RECORD)) {
            preferences.putString(BASE + dificultad, String.format("%.1f", tiempoTotal));
            System.out.println("No existia recortd");
            return;
        }

        strRecordAnterior = strRecordAnterior.replaceAll(",", ".");
        float recordAnterior = Float.parseFloat(strRecordAnterior);

        if (tiempoTotal < recordAnterior)
            preferences.putString(BASE + dificultad, String.format("%.1f", tiempoTotal));

        // Importante
        preferences.flush();
    }

    public String buscarRecord(int dificultad) {
        return preferences.getString(BASE + dificultad, Config.MENSAJE_NO_RECORD);
    }
}
