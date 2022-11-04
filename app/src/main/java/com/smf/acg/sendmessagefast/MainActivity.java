package com.smf.acg.sendmessagefast;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_FOR_SEND_BUTTON= 1;
//button for the app info activity
//button1 for the name activity
//button2 for the address activity
//button3 for the send activity

    private Button button,button1,button2, button3;
    private SharedPreferences database,namesDatabase;
    private List<User> people;
    private List<Address> addr;
    private Gson gson1,gson2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//set variables
        button = findViewById(R.id.appInfo);
        button1 = findViewById(R.id.nameOption);
        button2 = findViewById(R.id.address);
        button3 = findViewById(R.id.SMS);




        namesDatabase = getSharedPreferences("namesDatabase", Context.MODE_PRIVATE);
        String jsonN = namesDatabase.getString("people", "");

        database = getSharedPreferences("database", Context.MODE_PRIVATE);
        String jsonA = database.getString("addr", "");

       


//Get into the send
        button3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if(jsonN.isEmpty() || jsonA.isEmpty()) {
                    namesDatabase = getSharedPreferences("namesDatabase", Context.MODE_PRIVATE);
                    String jsonN = namesDatabase.getString("people", "");
                    database = getSharedPreferences("database", Context.MODE_PRIVATE);
                    String jsonA = database.getString("addr", "");
                    if (jsonN.isEmpty() || jsonA.isEmpty()) {
                        Toast.makeText(getApplicationContext(), R.string.Fill,
                                Toast.LENGTH_LONG).show();
                    } else {

                        Intent intent = new Intent(getBaseContext(), SendMessageActivity.class);
                        startActivity(intent);
                    }
                } else {
                Intent intent = new Intent(getBaseContext(), SendMessageActivity.class);
                startActivity(intent);
            }
        }});


        //Get into the address
        button2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {


               Intent intent = new Intent(getBaseContext(), AddressActivity.class);
               startActivity(intent);

            }});

//Get into the app info option
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AppInfo.class);
                startActivity(intent);
            }});
        
//Get into the name option
        button1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NameDetails.class);
                startActivity(intent);
            }});


    }


}