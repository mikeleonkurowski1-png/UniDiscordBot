package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.google.gson.Gson;
import java.time.LocalDate;


public class AuslesenKlasse {
    public static String Auslesen() {
        LocalDate date = LocalDate.now();
        String Tag = date.toString();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://openmensa.org/api/v2/canteens/1924/days/" + Tag + "/meals")
                .build();

        Gson gson = new Gson();

            try (Response response = client.newCall(request).execute()){

               String json = response.body().string();
                Gericht[] gerichte = gson.fromJson(json, Gericht[].class);

                if(gerichte.length > 0){
                    Gericht gerichteins = gerichte[0];
                    return "Gericht: " + gerichteins.name + " (" + gerichteins.category + ")" + "[\n" + "Preis: " + gerichteins.prices.studends + "€";
                }else {
                    return "Heute gibt es keine Gerichte";
                }
                //return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Fehler";
    }
}