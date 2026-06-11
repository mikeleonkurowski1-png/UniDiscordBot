package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class AuslesenKlasse {
    public static String Auslesen() {
        java.time.LocalDate date = java.time.LocalDate.now();
        String Tag = date.toString();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://openmensa.org/api/v2/canteens/1924/days/" + Tag + "/meals")
                .build();
        
            try (Response response = client.newCall(request).execute()){

                return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}