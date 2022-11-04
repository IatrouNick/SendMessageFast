package com.smf.acg.sendmessagefast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AppInfo extends AppCompatActivity {
    private Button button,histogramB;
    private SharedPreferences countDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);

        button = findViewById(R.id.back);
        histogramB=findViewById(R.id.histogramButton);

        countDatabase = getSharedPreferences("countDatabase", Context.MODE_PRIVATE);
        String jsonC = countDatabase.getString("countCodes", "");

        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                finish();
            }
        }
        );

        histogramB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jsonC.isEmpty()) {
                    countDatabase = getSharedPreferences("countDatabase", Context.MODE_PRIVATE);
                    String jsonC = countDatabase.getString("countCodes", "");

                    if (jsonC.isEmpty()) {
                        Toast.makeText(getApplicationContext(), R.string.create_Histogram,
                                Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(getBaseContext(), Histogram.class);
                        startActivity(intent);
                    }

                }else {
                    Intent intent = new Intent(getBaseContext(), Histogram.class);

                    startActivity(intent);
                }
            }});
    }
}