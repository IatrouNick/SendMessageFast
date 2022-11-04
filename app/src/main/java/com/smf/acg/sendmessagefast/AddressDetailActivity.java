package com.smf.acg.sendmessagefast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddressDetailActivity extends AppCompatActivity {
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_detail);

        Address addr = new Address(getIntent().getStringExtra("addr"));
        ((TextView) findViewById(R.id.addressText)).setText(addr.getAddress());
        ((TextView) findViewById(R.id.numberText)).setText(addr.getNumber());
        ((TextView) findViewById(R.id.locationText)).setText(addr.getLocation());
        ((TextView) findViewById(R.id.postalText)).setText(addr.getPostalCode());
        back=findViewById(R.id.backAA);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}