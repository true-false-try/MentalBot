package com.bot.psybot.config;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static com.bot.psybot.constans.AllPath.APPLICATION_PROPERTIES;

@Getter
@Configuration
@RequiredArgsConstructor
@PropertySource(APPLICATION_PROPERTIES)
public class BotConfig {
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.key}")
    private String botKey;

}
