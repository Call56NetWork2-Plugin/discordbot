import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault("Token"); // Token
        builder.addEventListeners(new Main());
        builder.setActivity(Activity.playing("!help"));
        builder.enableIntents(GatewayIntent.GUILD_PRESENCES);
        builder.build();
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("Logged in");
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message message = event.getMessage();
        if(message.getContentRaw().equals("!help")) {
            message.getChannel().sendMessage("Coming soon").queue();
        }
        if(message.getContentRaw().equals("!ip")) {
            message.getChannel().sendMessage("IP: mc.call56s.work").queue();
        }
    }
}
