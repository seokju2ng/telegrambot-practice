package com.telegrambot.practice;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class SimpleHandler extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        log.info("onUpdateReceived....");
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (update.getMessage().getText().equals("hello")) {
                SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                        .setChatId(update.getMessage().getChatId())
                        .setText("world");
                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        log.info("getBotUsername....");
        return "HelloWorldBot";
    }

    @Override
    public String getBotToken() {
        log.info("getBotToken....");
        return "1335248271:AAEGuoAYVPsTABxAvIYlb4O-XkqxFcxvIfY";
    }
}
