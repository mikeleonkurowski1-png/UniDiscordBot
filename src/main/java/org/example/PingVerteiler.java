package org.example;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

public class PingVerteiler extends ListenerAdapter {

    private static final String NachrichtenID = "1515060456333775049";
    private static final String RollenID = "1515059896222093594";


    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (event.getMessageId().equals(NachrichtenID)) {
            Role mensaRolle = event.getGuild().getRoleById(RollenID);
            if (mensaRolle != null) {
                event.getGuild().addRoleToMember(event.getMember(), mensaRolle).queue();
            }
        }
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        if (event.getMessageId().equals(NachrichtenID)) {
            Role mensaRolle = event.getGuild().getRoleById(RollenID);
            if (mensaRolle != null) {
                event.getGuild().removeRoleFromMember(event.getMember(), mensaRolle).queue();
            }
        }
    }
}
