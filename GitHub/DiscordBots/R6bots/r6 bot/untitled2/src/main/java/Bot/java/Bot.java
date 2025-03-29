package bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    private static final String TOKEN = "MTM1NTMzMTE4NTI0ODU3MTQxMw.Gy7rka.Q9FS1hdqlPi6QytdBqZU9vQNCxtanB-fwqaoEY"; // Remplace avec ton nouveau token
    private static final String CHANNEL_ID = "1355370606123810968"; // Remplace avec l'ID de ton canal

    public static void main(String[] args) throws LoginException {
        JDABuilder.createDefault(TOKEN)
                .addEventListeners(new Bot()) // Ajoute le listener pour les événements
                .build();
    }

    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("✅ Bot connecté !");

        // Récupérer le salon texte
        TextChannel channel = event.getJDA().getTextChannelById(CHANNEL_ID);

        if (channel != null) {
            channel.sendMessage("Hello, I'm online! 🎉").queue();
        } else {
            System.out.println("❌ Canal introuvable !");
        }
    }
}
