package com.bot.psybot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;

import java.net.URI;

@Configuration
public class VaultConfig {
    @Value("${vault.root.token}")
    private String token;

    @Value("${vault.listen.address}")
    private String uri;
    @Bean
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.from(URI.create("http://" + uri));
    }

    @Bean
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(token);
    }

    @Bean
    public VaultTemplate vaultTemplate() {
        return new VaultTemplate(vaultEndpoint(), clientAuthentication());
    }

}
