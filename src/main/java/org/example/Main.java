package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        Path filePath = Paths.get("config.properties"); //Path zur Textdatei mit dem Token drinnen
        try {
            String inhalt = Files.readString(filePath); //Token auslesen aus der Textdatei

            JDA jda = JDABuilder.createDefault(inhalt)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGE_REACTIONS)
                    .addEventListeners(new PingVerteiler())
                    .build();

            jda.awaitReady();
            TextChannel kanal = jda.getTextChannelById("1514717919714607104"); //ID des Zielkanals auf Discord hinterlegen


            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            //Runnable die zum richtigen ZEitpunkt vom scheduler ausgeführt werden soll:
            Runnable sendeSpeiseplan = new Runnable() {
                @Override
                public void run() {
                    String speiseplan = AuslesenKlasse.Auslesen();
                    kanal.sendMessage(speiseplan).queue();
                }
            };

            //berechnen des Zeitabstands bis zum nächsten Senden des Speiseplans:
            LocalTime zieluhrzeit = LocalTime.of(10, 01); //10:01 Uhr, da die Nachricht immer eine Minute früher gesendet wird, wie angegeben.
            LocalDateTime jetzt = LocalDateTime.now();
            LocalDateTime nächstesAusführen = jetzt.with(zieluhrzeit);

            if (jetzt.compareTo(nächstesAusführen) > 0){ //Überprüft, ob die Zieluhrzeit heute bereits in der Vergangenheit liegt
                nächstesAusführen = nächstesAusführen.plusDays(1); //Falls ja, setzt er das nächste Mal ausführen auf morgen zur Zieluhrzeit
            }

            long delay = Duration.between(jetzt, nächstesAusführen).toMinutes(); //Berechnet wie viele Minuten zwischen jetzt und dem nächsten Mal ausführen liegen

            scheduler.scheduleAtFixedRate(sendeSpeiseplan, delay, 1440, TimeUnit.MINUTES);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
