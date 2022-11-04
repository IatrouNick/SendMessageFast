package com.smf.acg.sendmessagefast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class CreateAddress extends AppCompatActivity {

    private Button addButton, backButton;
    private EditText editAddress,editNumber,editLocation,editPostalCode ;
    private TextInputLayout addressLayout,numberLayout,postalCodeLayout,locationLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_address);

        editAddress = findViewById(R.id.editAddress);
        editNumber = findViewById(R.id.editNumber);
        editLocation = findViewById(R.id.editLocation);
        editPostalCode = findViewById(R.id.editPostalCode);


        addButton = findViewById(R.id.addButton);
        backButton = findViewById(R.id.backButton);

        addressLayout = findViewById(R.id.address_container);
        numberLayout = findViewById(R.id.number_container);
        postalCodeLayout = findViewById(R.id.postalCode_container);
        locationLayout = findViewById(R.id.location_container);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validationFailed = false;

              String postalCodeStr = editPostalCode.getText().toString();
              if (postalCodeStr.isEmpty()) {
                  postalCodeLayout.setError(getString(R.string.postal_error));
                  postalCodeLayout.requestFocus();
                  validationFailed = true;
              }

                String locationStr = editLocation.getText().toString();
                if (locationStr.isEmpty()) {
                    locationLayout.setError(getString(R.string.location_error));
                    locationLayout.requestFocus();
                    validationFailed = true;
                }

                String numberStr = editNumber.getText().toString();
                if (numberStr.isEmpty()) {
                    numberLayout.setError(getString(R.string.number_error));
                    numberLayout.requestFocus();
                    validationFailed = true;
                }

                String addressStr = editAddress.getText().toString();
                if (addressStr.isEmpty()) {
                    addressLayout.setError(getString(R.string.address_error));
                    addressLayout.requestFocus();
                    validationFailed = true;
                }
                if (validationFailed) {
                    return;
                }

                Address addr = new Address(addressStr,numberStr, postalCodeStr, locationStr);
                Intent intent = new Intent();
                intent.putExtra("addr", addr.serialize());
                setResult(RESULT_OK, intent);
                finish();

            }
        });


       backButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });


        // Remove errors as user starts typing in edit texts
       editAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                addressLayout.setError(null);
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        editNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                numberLayout.setError(null);
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        editLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                locationLayout.setError(null);
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        editPostalCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               postalCodeLayout.setError(null);
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });

    }
}