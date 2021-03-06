package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciceMathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exerices_maths);
    }

    public void onExercice1(View view) {

        // Création d'une intention
        Intent TableMultiplicationIntent = new Intent(ExerciceMathActivity.this, ExerciceMultiplicationActivity.class);

        // Lancement de la demande de changement d'activité
        startActivity(TableMultiplicationIntent);
    }

    public void onExercice2(View view) {

        // Création d'une intention
        Intent AddidtionIntent = new Intent(ExerciceMathActivity.this, ExerciceAdditionActivity.class);

        // Lancement de la demande de changement d'activité
        startActivity(AddidtionIntent);
    }

    public void onExercice3(View view) {

        // Création d'une intention
        Intent AddidtionIntent = new Intent(ExerciceMathActivity.this, ExerciceSoustractionActivity.class);

        // Lancement de la demande de changement d'activité
        startActivity(AddidtionIntent);
    }
}
