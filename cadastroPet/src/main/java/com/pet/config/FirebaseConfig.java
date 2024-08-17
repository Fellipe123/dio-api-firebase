package com.pet.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;

import jakarta.annotation.PostConstruct;

@Configuration
public class FirebaseConfig {

	 @Value("${firebase.config.url}")
	 private String urlDatabase;
	 
	 @Value("${firebase.config.path}")
	 private String arquivoConfigJson;
	 
	 private DatabaseReference referencia;
	 
	 @PostConstruct
	 public FirebaseApp inicializando() throws IOException {
	        try (InputStream input = new FileInputStream(arquivoConfigJson)) {
	            FirebaseOptions options = new FirebaseOptions.Builder()
	                .setCredentials(GoogleCredentials.fromStream(input))
	                .setDatabaseUrl(urlDatabase)
	                .build();

	            if (FirebaseApp.getApps().isEmpty()) {
	                return FirebaseApp.initializeApp(options);
	            }
	            return FirebaseApp.getInstance();
	        } catch (IOException e) {
	            throw new RuntimeException("Falha ao iniciar o Firebase", e);
	        }
	  }
	 
}
