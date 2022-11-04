package com.smf.acg.sendmessagefast;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class NameActivity extends AppCompatActivity {
//confirm is to save the name and username
//name and surname for the edit Text
//nameLayout and SurnameLayout for the for the input the user gives
//back to return to main menu



    private Button confirm, backMM;
    private EditText name, surname;
    private TextInputLayout nameLayout, surnameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
//set variables
        confirm = findViewById(R.id.confirm);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        nameLayout = findViewById(R.id.name_container);
        surnameLayout = findViewById(R.id.surname_container);
        backMM = findViewById(R.id.backMM);




//validate user info for name surname, can not be empty and will contain only letters(ascii character) With error messages
        confirm.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           boolean validationFailed = false;

                           String surnameStr = surname.getText().toString();
                           if (surnameStr.isEmpty()) {
                               surnameLayout.setError(getString(R.string.surname_error));
                               surnameLayout.requestFocus();
                               validationFailed = true;
                           }

                           String nameStr = name.getText().toString();
                           if (nameStr.isEmpty()) {
                               nameLayout.setError(getString(R.string.name_error));
                               nameLayout.requestFocus();
                               validationFailed = true;
                           }

                           if (validationFailed) {
                               return;
                           }

                           User people = new User(nameStr, surnameStr);
                           Intent intent = new Intent();
                           intent.putExtra("people", people.serialize());
                           setResult(RESULT_OK, intent);
                           Toast.makeText(getApplicationContext(), R.string.Name_Saved, Toast.LENGTH_LONG).show();
                           finish();
                                      }
                                  }
        );



 backMM.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         finish();
     }
 });
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                nameLayout.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        surname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                surnameLayout.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

}


