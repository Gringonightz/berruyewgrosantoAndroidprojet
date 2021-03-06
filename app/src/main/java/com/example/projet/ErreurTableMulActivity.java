package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ErreurTableMulActivity extends AppCompatActivity {
    public static final String NB_ERREUR= "value_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_erreur_table_mul);
        TextView text = findViewById(R.id.nbErreurText);
        int valeur = getIntent().getIntExtra(NB_ERREUR,0);
        text.setText(text.getText().toString() + valeur);
    }
    public void goBack(View view){
        setResult(RESULT_OK);
        super.finish();
    }
    public void goTable(View view){
        Intent intent = new Intent(this, ExerciceMultiplicationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}