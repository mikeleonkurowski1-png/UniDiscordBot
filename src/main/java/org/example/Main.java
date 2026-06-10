package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("config.properties");
        try {
            String Inhalt = Files.readString(filePath);

            JDABuilder.createDefault(Inhalt)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                    .build();
            System.out.println("erfolg");
            //AuslesenKlasse klasse = new AuslesenKlasse();
            //klasse.Auslesen();

            String Ergebniss = AuslesenKlasse.Auslesen();
            System.out.println(Ergebniss);

        } catch (Exception e) {
            System.err.println("Error: Die Datei config.properties konnte nicht ausgelesen werden!");
        }
    }
}

