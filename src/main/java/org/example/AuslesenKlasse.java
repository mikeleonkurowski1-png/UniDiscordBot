package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuslesenKlasse {
    public static String Auslesen() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://openmensa.org/api/v2/canteens/1924/days/2026-06-10/meals")
                .build();

        try {
            Response response = null;
            try {
                response = client.newCall(request).execute();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}