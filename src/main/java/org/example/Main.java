package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("config.properties");
        try {
            String Inhalt = Files.readString(filePath);

            JDA jda = JDABuilder.createDefault(Inhalt)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                    .build();

            jda.awaitReady();
            TextChannel kanal = jda.getTextChannelById("1514717919714607104");
            String Speiseplan = AuslesenKlasse.Auslesen();
            kanal.sendMessage(Speiseplan).queue();




            //System.out.println("erfolgreich gestartet");
            //AuslesenKlasse klasse = new AuslesenKlasse();
            //klasse.Auslesen();

            //String Ergebniss = AuslesenKlasse.Auslesen();
            //System.out.println(Ergebniss);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
