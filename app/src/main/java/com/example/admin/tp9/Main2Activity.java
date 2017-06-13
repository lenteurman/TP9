package com.example.admin.tp9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Traceur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button bouton2 = (Button) findViewById(R.id.button2);
        bouton2.setText(R.string.button2);

        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
