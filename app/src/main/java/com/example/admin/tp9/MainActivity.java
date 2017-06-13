package com.example.admin.tp9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends Traceur {

    String text;
    int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bouton = (Button) findViewById(R.id.button);
        bouton.setText(R.string.button);

        Button bouton3 = (Button) findViewById(R.id.button3);
        bouton3.setText(R.string.button3);

        EditText message = (EditText) findViewById(R.id.editText);
        text = message.getText().toString();

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        bouton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementer();
            }
        });

    }
    // Les sauvegardes aux rotations
    @Override
    //On ressort notre valeur
    protected void onRestoreInstanceState(Bundle savedInstantState) {
        super.onRestoreInstanceState(savedInstantState);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progress = savedInstantState.getInt("progress");
        progressBar.setProgress(progress);
    }
    @Override
    //On sauvegarde notre valeur
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progress = progressBar.getProgress();
        Log.d("Etat", "progress:" + progress);
        //outState.putInt("progress", progress);
        //Méthode Parcelable pour persister
        Point point = new Point(progress);
        outState.putParcelable("progress", point);
    }

    public void incrementer() {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        int progr = progressBar.getProgress();
        if (progr == 100) {
            progr = 0;
        }
        progressBar.setProgress(progr+10);
    }
}
