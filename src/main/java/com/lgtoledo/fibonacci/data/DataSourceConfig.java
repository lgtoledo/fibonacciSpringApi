package com.lgtoledo.fibonacci.data;

import javax.sql.DataSource;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.AzureCliCredential;
import com.azure.identity.AzureCliCredentialBuilder;
import com.azure.identity.ChainedTokenCredential;
import com.azure.identity.ChainedTokenCredentialBuilder;
import com.azure.identity.ManagedIdentityCredential;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    public DataSource dataSource() {

        // .url("jdbc:mysql://mysql.database.windows.net:3306/fibonacci?useSSL=false&serverTimezone=UTC") //


        return DataSourceBuilder
                .create()
                .url("jdbc:mysql://db-labanca.mysql.database.azure.com:3306/fibonacci_db?useSSL=false&requireSSL=false&serverTimezone=UTC")
                .username("adminlabanca@db-labanca.mysql.database.azure.com")
                .password("Labanca.2022")
                .build();
    }

    // public DataSource dataSource() {
    //     if (secretClient == null) {
    //         secretClient = new SecretClientBuilder()
    //             .vaultUrl(keyVaultUrl)
    //             .credential(getCredential())
    //             .buildClient();
    //     }

    //     return DataSourceBuilder
    //             .create()
    //             .driverClassName("com.mysql.jdbc.Driver")//com.microsoft.sqlserver.jdbc.SQLServerDriver")
    //             .url(secretClient.getSecret("jdbcUrl").getValue())
    //             .username(secretClient.getSecret("jdbcUsername").getValue())
    //             .password(secretClient.getSecret("jdbcPassword").getValue())
    //             .build();
    // }

    // @Value("${keyvault.url}")
    // private String keyVaultUrl;
    // @Value("${managedIdentity.clientId}")
    // private String managedIdentityClientId;

    // private SecretClient secretClient = null;

    // private TokenCredential getCredential() {
    //     AzureCliCredential cliCredential = new AzureCliCredentialBuilder().build();
        
    //     ManagedIdentityCredential miCredential = new ManagedIdentityCredentialBuilder()
    //         .clientId(managedIdentityClientId)
    //         .build();

    //     ChainedTokenCredential chainedCredential = new ChainedTokenCredentialBuilder()
    //         .addLast(miCredential)
    //         .addLast(cliCredential)
    //         .build();
        
    //     return chainedCredential;
    // }
}
