package com.smf.acg.sendmessagefast;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SendMessageActivity extends AppCompatActivity {


    private static final int PERMISSION_SEND_SMS = 1;

    // private String phoneNo = "13033";
    // private String phoneNo2 = "13032";
    private String body, name, surname, address, number;
    private int num;
    private Button option1, option2, option3, option4, option5, option6, option7;
    private SharedPreferences sharedPref, database, countDatabase;
    private List<User> people;
    private List<Address> addr;
    private Gson gson1, gson2, gson3;
    private List<CountCodes> countCodes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        countCodes = new ArrayList<>();
        countDatabase = getSharedPreferences("countDatabase", Context.MODE_PRIVATE);
        String json = countDatabase.getString("countCodes", "");
        gson3 = new Gson();

        if (!json.isEmpty()) {
            countCodes = new ArrayList<>(Arrays.asList(gson3.fromJson(json, CountCodes[].class)));

        } else {
            countCodes.add(new CountCodes("0", "0", "0", "0", "0", "0", "0"));
            StoreCount();
        }

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        option5 = findViewById(R.id.option5);
        option6 = findViewById(R.id.option6);
        option7 = findViewById(R.id.option7);

        SharedPreferences sp = getSharedPreferences("AddPrefDatabase", Context.MODE_PRIVATE);
        int pos = sp.getInt("addPref", 0);

//LOAD NAME/SURNAME
        people = new ArrayList<>();
        sharedPref = getSharedPreferences("namesDatabase", Context.MODE_PRIVATE);
        gson1 = new Gson();
        String jsonN = sharedPref.getString("people", "");
        gson1.toJson(jsonN);
        people = Arrays.asList(gson1.fromJson(jsonN, User[].class));
        name = people.get(people.size() - 1).getName();
        surname = people.get(people.size() - 1).getSurname();

//LOAD ADDRESS
        addr = new ArrayList<>();
        database = getSharedPreferences("database", Context.MODE_PRIVATE);
        gson2 = new Gson();
        String jsonA = database.getString("addr", "");
        gson2.toJson(jsonA);
        addr = new ArrayList<>(Arrays.asList(gson2.fromJson(jsonA, Address[].class)));
        address = addr.get(pos).getAddress();
        number = addr.get(pos).getNumber();


//BODY 0F THE MESSAGE
        body = name + " " + surname + " " + address + " " + number;



        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:13033");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "1 " + body);
                num = Integer.parseInt(countCodes.get(0).getCode1());
                num = num + 1;
                countCodes.get(0).setCode1(String.valueOf(num));
                StoreCount();
                startActivity(intent);
                finish();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:13033");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "2 " + body);
                num = Integer.parseInt(countCodes.get(0).getCode2());
                num = num + 1;
                countCodes.get(0).setCode2(String.valueOf(num));
                StoreCount();
                startActivity(intent);
                finish();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:13033");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "3 " + body);
                num = Integer.parseInt(countCodes.get(0).getCode3());
                num = num + 1;
                countCodes.get(0).setCode3(String.valueOf(num));
                StoreCount();
                startActivity(intent);
                finish();
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:13033");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "4 " + body);
                num = Integer.parseInt(countCodes.get(0).getCode4());
                num = num + 1;
                countCodes.get(0).setCode4(String.valueOf(num));
                StoreCount();
                startActivity(intent);
                finish();
            }
        });

        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:13033");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "5 " + body);
                num = Integer.parseInt(countCodes.get(0).getCode5());
                num = num + 1;
                countCodes.get(0).setCode5(String.valueOf(num));
                StoreCount();
                startActivity(intent);
                finish();
            }
        });

        option6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:13033");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "6 " + body);
                num = Integer.parseInt(countCodes.get(0).getCode6());
                num = num + 1;
                countCodes.get(0).setCode6(String.valueOf(num));
                StoreCount();
                startActivity(intent);
                finish();
            }
        });

        option7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:13032");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "2 " + body);
                num = Integer.parseInt(countCodes.get(0).getCode7());
                num = num + 1;
                countCodes.get(0).setCode7(String.valueOf(num));
                StoreCount();
                startActivity(intent);
                finish();
            }
        });

    }

  //      option1.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View v) {
  //              sendSMS(phoneNo, body, "1");
  //
  //              num = Integer.parseInt(countCodes.get(0).getCode1());
  //              num = num + 1;
  //              countCodes.get(0).setCode1(String.valueOf(num));
  //              StoreCount();
  //              finish();
  //          }
  //      });
  //
  //      option2.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View v) {
  //              sendSMS(phoneNo, body, "2");
  //
  //              num = Integer.parseInt(countCodes.get(0).getCode2());
  //              num = num + 1;
  //              countCodes.get(0).setCode2(String.valueOf(num));
  //              StoreCount();
  //              finish();
  //
  //          }
  //      });
  //
  //      option3.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View v) {
  //              sendSMS(phoneNo, body, "3");
  //
  //              num = Integer.parseInt(countCodes.get(0).getCode3());
  //              num = num + 1;
  //              countCodes.get(0).setCode3(String.valueOf(num));
  //              StoreCount();
  //              finish();
  //
  //          }
  //      });
  //
  //      option4.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View v) {
  //              sendSMS(phoneNo, body, "4");
  //
  //              num = Integer.parseInt(countCodes.get(0).getCode4());
  //              num = num + 1;
  //              countCodes.get(0).setCode4(String.valueOf(num));
  //              StoreCount();
  //              finish();
  //          }
  //      });
  //
  //      option5.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View v) {
  //              sendSMS(phoneNo, body, "5");
  //
  //              num = Integer.parseInt(countCodes.get(0).getCode5());
  //              num = num + 1;
  //              countCodes.get(0).setCode5(String.valueOf(num));
  //              StoreCount();
  //              finish();
  //          }
  //      });
  //
  //      option6.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View v) {
  //              sendSMS(phoneNo, body, "6");
  //
  //              num = Integer.parseInt(countCodes.get(0).getCode6());
  //              num = num + 1;
  //              countCodes.get(0).setCode6(String.valueOf(num));
  //              StoreCount();
  //              finish();
  //          }
  //      });
  //
  //      option7.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View v) {
  //              sendSMS(phoneNo2, body, "2");
  //
  //              num = Integer.parseInt(countCodes.get(0).getCode7());
  //              num = num + 1;
  //              countCodes.get(0).setCode7(String.valueOf(num));
  //              StoreCount();
  //              finish();
  //          }
  //      });
  //
  //
  //           if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
  //
  //               if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
  //
  //                   Log.d("permission", "permission denied to SEND_SMS - requesting it");
  //                   String[] permissions = {Manifest.permission.SEND_SMS};
  //
  //                   requestPermissions(permissions, PERMISSION_SEND_SMS);
  //
  //               }
  //           }
  //
  //
  //       }
  //
  //
  //
  //       public void sendSMS(String phoneNo, String msg,String code) {
  //           try {
  //               SmsManager smsManager = SmsManager.getDefault();
  //               smsManager.sendTextMessage(phoneNo, null, code +" " +msg, null, null);
  //               Toast.makeText(getApplicationContext(), R.string.MessageSent,
  //                       Toast.LENGTH_LONG).show();
  //           } catch (Exception ex) {
  //               Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
  //                       Toast.LENGTH_LONG).show();
  //               ex.printStackTrace();
  //           }
  //
  //
  //  }
  //
  //
  //
    public void StoreCount(){
        SharedPreferences.Editor editor = countDatabase.edit();
        editor.putString("countCodes", gson3.toJson(countCodes));
        editor.apply();
    }

    }