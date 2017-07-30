package com.alexander.makarov;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

public class Main {

    public static void main(String[] args) {
        // Initialize Api Context
        ApiContextInitializer.init();

        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();

        // Register our bot
        try {
            botsApi.registerBot(new ListsLearnerBot());
        } catch (TelegramApiException e) {
            BotLogger.error("Bot's registration has failed", e);
        }

        System.out.println("ListsLearner Bot has successfully started");
    }

}
