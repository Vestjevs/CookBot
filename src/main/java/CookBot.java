import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

public class CookBot extends TelegramLongPollingBot {

    private static final String TOKEN = "989086914:AAHIJVcfmrbDHlzyX7UpXfaa3vLF0351JB0";
    private static final String USERNAME = "OurCookBot";


    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String mess = update.getMessage().getText();

            long chatId = update.getMessage().getChatId();
            SendMessage message = new SendMessage()
                    .setChatId(chatId).setText("Hello World");

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();

            }


        }
    }

    public String getBotUsername() {
        return USERNAME;
    }

    public String getBotToken() {
        return TOKEN;
    }

    public void clearWebhook() throws TelegramApiRequestException {

    }
}
