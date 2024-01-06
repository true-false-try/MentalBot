package com.bot.psybot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
public class VaultConfig extends AbstractVaultConfiguration {

    @Value("${vault.root.token}")
    private String token;

    @Value("${vault.root.host}")
    private String host;
    @Value("${vault.root.port}")
    private Integer port;

    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.create(host, port);
    }

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(token);
    }
}
