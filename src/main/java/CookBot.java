import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CookBot extends TelegramLongPollingBot {

    private static final String TOKEN = "989086914:AAHIJVcfmrbDHlzyX7UpXfaa3vLF0351JB0";
    private static final String USERNAME = "OurCookBot";


    public void onUpdateReceived(Update update) {


        if (update.hasMessage() && update.getMessage().hasText()) {
            String mess_text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();


            if (mess_text.equals("/start")) {
                SendMessage message = new SendMessage()
                        .setChatId(chatId).setText("Сейчас я покажу тебе все прелести анального секаса!!");

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();

                }
            } else if (mess_text.equals("/pic")) {
                //First send to telegram server and know their link

                SendPhoto msg = new SendPhoto()
                        .setChatId(chatId)
                        .setPhoto("AgADAgADB6sxG9PPAAFIlOrJSnHCzEe75LkPAAQBAAMCAAN5AAM5SwIAARYE")
                        .setCaption("Photo");
                try {
                    execute(msg); // Call method to send the photo
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (mess_text.equals("/markup")) {
                SendMessage message = new SendMessage()
                        .setChatId(chatId)
                        .setText("Here is your markup");

                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keyboard = new ArrayList<>();

                KeyboardRow row = new KeyboardRow();

                row.add("Button 1");
                row.add("Button 2");
                row.add("Button 3");

                keyboard.add(row);

                row = new KeyboardRow();

                row.add("Button 4");
                row.add("Button 5");
                row.add("Button 6");

                keyboard.add(row);

                keyboardMarkup.setKeyboard(keyboard);

                message.setReplyMarkup(keyboardMarkup);


                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (mess_text.equals("Button 1")) {

                SendPhoto message = new SendPhoto()
                        .setChatId(chatId)
                        .setPhoto("AgADAgADuasxG0afwUso6iQXKxYuP6DUuQ8ABAEAAwIAA3kAA-gQAgABFgQ")
                        .setCaption("Photo");

                try {
                    execute(message);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (mess_text.equals("/hide")) {
                SendMessage message = new SendMessage()
                        .setChatId(chatId)
                        .setText("Keyboard hidden");

                ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();

                message.setReplyMarkup(keyboardMarkup);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }


            } else {
                //Unknown command

                SendMessage message = new SendMessage()
                        .setChatId(chatId)
                        .setText("Unknown command");

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }


        } else if (update.hasMessage() && update.getMessage().hasPhoto()) {
            // Message contains photo
            // Set variables
            long chat_id = update.getMessage().getChatId();

            // Array with photo objects with different sizes
            // We will get the biggest photo from that array
            List<PhotoSize> photos = update.getMessage().getPhoto();
            // Know file_id
            String f_id = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getFileId();
            // Know photo width
            int f_width = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getWidth();
            // Know photo height
            int f_height = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getHeight();
            // Set photo caption
            String caption = "file_id: " + f_id + "\nwidth: " + Integer.toString(f_width) + "\nheight: " + Integer.toString(f_height);
            SendPhoto msg = new SendPhoto()
                    .setChatId(chat_id)
                    .setPhoto(f_id)
                    .setCaption(caption);
            try {
                execute(msg); // Call method to send the photo with caption
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
