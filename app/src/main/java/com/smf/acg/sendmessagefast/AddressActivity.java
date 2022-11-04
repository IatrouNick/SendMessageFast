package com.smf.acg.sendmessagefast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressActivity extends AppCompatActivity {

    private static final int ADDRESS_CREATED = 1;

    private List<Address> addr;
    private Gson gson;
    private SharedPreferences database;
    private BaseAdapter addressAdapter;
    private ListView addresses;
    private TextView noAddress;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);


        addresses = findViewById(R.id.address_list);
        noAddress = findViewById(R.id.no_address);



        addr = new ArrayList<>();
        database = getSharedPreferences("database", Context.MODE_PRIVATE);
        String json = database.getString("addr", "");
        gson = new Gson();
        if (!json.isEmpty()) {
            addr = new ArrayList<>(Arrays.asList(gson.fromJson(json, Address[].class)));

            addresses.setVisibility(View.VISIBLE);
            noAddress.setVisibility(View.INVISIBLE);
        }
        else {
            addresses.setVisibility(View.INVISIBLE);
            noAddress.setVisibility(View.VISIBLE);
        }
        addressAdapter = new AddressAdapter(this, addr);
        addresses.setAdapter(addressAdapter);





        addresses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Address addr = (Address) parent.getAdapter().getItem(position);
                SharedPreferences sp = getSharedPreferences("AddPrefDatabase", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("addPref", position);
                editor.apply();

               for (int i=0; i < parent.getAdapter().getCount();i++){
                   addresses.getChildAt(i).setAlpha(0.5f);
               }

               addresses.getChildAt(position).setAlpha(1.0f);
        

                Intent intent = new Intent(getBaseContext(), AddressDetailActivity.class);
                intent.putExtra("addr", addr.serialize());
                startActivity(intent);

            }
        });


        addresses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sp = getSharedPreferences("AddPrefDatabase", Context.MODE_PRIVATE);
                int pos = sp.getInt("addPref",0 );
               if ((position<pos) && (pos !=0) ){
                   pos = pos-1;
                   SharedPreferences.Editor editor = sp.edit();
                   editor.putInt("addPref", pos);
                   editor.apply();
                   addresses.getChildAt(pos).setAlpha(1.0f);
                   if (addr.size()>pos)     addresses.getChildAt(pos+1).setAlpha(0.5f);
            }else if((position==pos) && (pos !=0) ) {
                  pos = pos - 1;
                  SharedPreferences.Editor editor = sp.edit();
                  editor.putInt("addPref", pos);
                  editor.apply();
                  addresses.getChildAt(pos).setAlpha(1.0f);
                   if (addr.size()>pos)     addresses.getChildAt(pos+1).setAlpha(0.5f);
               }
                addr.remove(position);

                storeAndUpdate();

                return false;
            }
        });

        Button add = findViewById(R.id.addAddress);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getBaseContext(), CreateAddress.class), ADDRESS_CREATED);


            }
        });

        Button back = findViewById(R.id.backA);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != ADDRESS_CREATED || resultCode != RESULT_OK || data == null)
            return;
        addr.add(new Address(data.getStringExtra("addr")));
        storeAndUpdate();


    }

    private void storeAndUpdate() {
        SharedPreferences.Editor editor = database.edit();
        editor.putString("addr", gson.toJson(addr));
        editor.apply();
        if (addr.size() > 0 && addresses.getVisibility() == View.INVISIBLE) {
            addresses.setVisibility(View.VISIBLE);
            noAddress.setVisibility(View.INVISIBLE);
        }
        else if (addr.size() == 0 && addresses.getVisibility() == View.VISIBLE) {
            addresses.setVisibility(View.INVISIBLE);
            noAddress.setVisibility(View.VISIBLE);
        }
        addressAdapter.notifyDataSetChanged();
    }



}