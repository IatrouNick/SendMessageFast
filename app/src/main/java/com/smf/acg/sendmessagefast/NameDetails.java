package com.smf.acg.sendmessagefast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameDetails extends AppCompatActivity {

    private static final int PERSON_CREATED = 1;


    private List<User> people;
    private TextView nameUsed, surnameUsed;
    private Button back, change,first;

    private Gson gson;
    private SharedPreferences namesDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_details);

        nameUsed = findViewById(R.id.nameUsed);
        surnameUsed = findViewById(R.id.surnameUsed);
        back = findViewById(R.id.backMM);
        change =findViewById(R.id.change);
        first =findViewById(R.id.firstTime);


        // Load or create list of people
        people = new ArrayList<>();
        namesDatabase = getSharedPreferences("namesDatabase", Context.MODE_PRIVATE);
        String json = namesDatabase.getString("people", "");
        gson = new Gson();
        if (!json.isEmpty()) {
            people = new ArrayList<>(Arrays.asList(gson.fromJson(json, User[].class)));
            first.setVisibility(View.INVISIBLE);
            change.setVisibility(View.VISIBLE);
            displayPerson();

        } else {

            nameUsed.setText(R.string.NameDetailMessage);
        }

        back.setOnClickListener(v -> finish());

              change.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      startActivityForResult(new Intent(NameDetails.this, NameActivity.class), PERSON_CREATED);
                  }
              });

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(NameDetails.this, NameActivity.class), PERSON_CREATED);

            }

        });
    }


             @Override
             public void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {
                 super.onActivityResult(requestCode, resultCode, data);
                 if (requestCode != PERSON_CREATED || resultCode != RESULT_OK || data == null)
                 return;



                     String json = data.getStringExtra("people");
                     User person = gson.fromJson(json, User.class);
                   
                     people.add(new User(person.getName(),person.getSurname()));
                     json = gson.toJson(people);
                     SharedPreferences.Editor editor = namesDatabase.edit();
                     editor.putString("people", json);
                     editor.apply();
                     change.setVisibility(View.INVISIBLE);
                     displayPerson();
                 }


            private void displayPerson () {
                // Display person's name/surname
                User person = people.get(people.size()-1);
                nameUsed.setText(person.getName());
                surnameUsed.setText(person.getSurname());
        }



    }


