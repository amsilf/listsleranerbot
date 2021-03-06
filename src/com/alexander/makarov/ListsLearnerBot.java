package com.alexander.makarov;

import com.alexander.makarov.database.AwsDriverManager;
import com.alexander.makarov.database.ListsDao;
import com.alexander.makarov.database.ListsDaoImpl;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListsLearnerBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "ListsLearnerBot";
    private static final String BOT_TOKEN = "425017284:AAGA4q7toRTUTfQR0XGHUT_wJtkuOoOKDaM";

    private static final String HELP_MESSAGE = "/help show this message\n" +
            "/start start working with api\n" +
            "/lists show existing lists";

    private static final Connection connection = AwsDriverManager.getConnection();

    private static ListsDao listsDao;

    public ListsLearnerBot() {
        listsDao = new ListsDaoImpl(connection);
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            InlineKeyboardMarkup keyboardMarkup;
            SendMessage messageObj = new SendMessage().setChatId(chatId);

            try {
                switch (messageText) {
                    case "/start":
                        listsDao.addList("test_list", "1d");
                        keyboardMarkup = createInlineKeyboard();
                        messageObj.setText("start message");
                        messageObj.setReplyMarkup(keyboardMarkup);
                        break;
                    case "/help":
                    default:
                        messageObj.setText(HELP_MESSAGE);
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            sendMessageToChat(messageObj);
        }
    }

    private InlineKeyboardMarkup createInlineKeyboard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        rowInline.add(new InlineKeyboardButton().setText("Update message text").setCallbackData("update_msg_text"));
        // Set the keyboard to the markup
        rowsInline.add(rowInline);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    private void sendMessageToChat(SendMessage message) {
        try {
            sendApiMethod(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return BOT_USERNAME;
    }

    public String getBotToken() {
        return BOT_TOKEN;
    }

}
