package com.example.projet.db;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.projet.db.AppDatabase;

import java.util.concurrent.Executors;

public class DatabaseClient {

    // Instance unique permettant de faire le lien avec la base de données
    private static DatabaseClient instance;

    // Objet représentant la base de données de votre application
    private AppDatabase appDatabase;

    // Constructeur
    private DatabaseClient(final Context context) {

        // Créer l'objet représentant la base de données de votre application
        // à l'aide du "Room database builder"
        // MyToDos est le nom de la base de données
       // appDatabase = Room.databaseBuilder(context, AppDatabase.class, "EcoleDesLoustics").build();

        ////////// REMPLIR LA BD à la première création à l'aide de l'objet roomDatabaseCallback
        // Ajout de la méthode addCallback permettant de populate (remplir) la base de données à sa création
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "EcoleDesLoustics").addCallback(roomDatabaseCallback).build();
    }

    // Méthode statique
    // Retourne l'instance de l'objet DatabaseClient
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    // Retourne l'objet représentant la base de données de votre application
    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    // Objet permettant de populate (remplir) la base de données à sa création
    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        // Called when the database is created for the first time.
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            //

            db.execSQL("INSERT INTO question (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"… de te plaindre !\", \"Arrête\", \"Arrêtes\", \"Arête\" );");
            db.execSQL("INSERT INTO question (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"Je regrette qu’il … pris cette décision.\", \"ait\", \"es\", \"est\" );");
            db.execSQL("INSERT INTO question (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"Cette chanteuse a une … incroyable.\", \"voix\", \"voie\", \"vois\" );");
            db.execSQL("INSERT INTO question (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"… sont les horaires de la ligne 1 ?\", \"Quelles\", \"Quel\", \"Qu’elles\" );");
            db.execSQL("INSERT INTO question (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"Ces billets d’avion coûtent ….\", \"chers\", \"chères\", \"cher\" );");
            db.execSQL("INSERT INTO question (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"Ils veulent … comprendre le subjonctif.\", \"tous\", \"tout \", \"touts\" );");
            db.execSQL("INSERT INTO question (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"J’ai arrêté d’apprendre l’… c’était trop difficile.\", \"allemand\", \"Allemand\", \"alemand\" );");

            db.execSQL("INSERT INTO questionHG (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"Quelle est la capitale de l’Espagne ?\", \"Madrid\", \"Barcelone\", \"Rome\" );");
            db.execSQL("INSERT INTO questionHG (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"Qui a découvert les Amériques le 12 octobre 1492 ?\", \"Christophe Colomb\", \"Vasco De Gama\", \"Jack Sparrow\" );");
            db.execSQL("INSERT INTO questionHG (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"Sur quel continent se situe le Japon ?\", \"En Asie\", \"En Océanie\", \"En Afrique\" );");
            db.execSQL("INSERT INTO questionHG (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"Quelle est la capitale de l'Italie ?\", \"Rome\", \"Madrid\", \"Naples\" );");
            db.execSQL("INSERT INTO questionHG (question, BonneRéponse, FausseRéponseUn, FausseRéponseDeux) VALUES(\"En quelle année a eu lieu la révolution française ?\", \"1789\", \"2019\", \"1812\" );");
        }
    };
}
