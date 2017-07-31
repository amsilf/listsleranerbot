package com.alexander.makarov.keyboards;

import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface ApplicationKeyboard {

    InlineKeyboardMarkup getPreviousKeyboard();

    InlineKeyboardMarkup getNextKeyboard();

}
