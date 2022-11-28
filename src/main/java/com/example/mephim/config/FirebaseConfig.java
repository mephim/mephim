package com.example.mephim.config;

import com.google.cloud.storage.Storage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseConfig {
    public void initDB() throws IOException {
        InputStream serviceAccount = this.getClass().getClassLoader()
                .getResourceAsStream("./use_your_private_key.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://use_your_project_url.com").build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }

    public Firestore getFirebase() {
        return FirestoreClient.getFirestore();
    }
}
