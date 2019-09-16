import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private final Logger logger = LogManager.getLogManager().getLogger(Main.class.getName());



    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new CookBot());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
