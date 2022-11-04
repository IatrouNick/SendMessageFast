package com.smf.acg.sendmessagefast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Histogram extends AppCompatActivity {

    private BarChart barChart;
    private Button buttonH;
    private List<CountCodes> countCodes;
    private SharedPreferences countDatabase;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histogram);

        barChart = (BarChart) findViewById(R.id.histogram);
        buttonH=findViewById(R.id.backH);




//LOAD codes counter
        countCodes = new ArrayList<>();
        countDatabase = getSharedPreferences("countDatabase", Context.MODE_PRIVATE);
        gson = new Gson();
        String jsonC = countDatabase.getString("countCodes", "");
        gson.toJson(jsonC);
        countCodes = Arrays.asList(gson.fromJson(jsonC, CountCodes[].class));




        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1, Integer.parseInt(countCodes.get(0).getCode1())));
        entries.add(new BarEntry(2,Integer.parseInt(countCodes.get(0).getCode2())));
        entries.add(new BarEntry(3,Integer.parseInt(countCodes.get(0).getCode3())));
        entries.add(new BarEntry(4,Integer.parseInt(countCodes.get(0).getCode4())));
        entries.add(new BarEntry(5,Integer.parseInt(countCodes.get(0).getCode5())));
        entries.add(new BarEntry(6,Integer.parseInt(countCodes.get(0).getCode6())));
        entries.add(new BarEntry(7,Integer.parseInt(countCodes.get(0).getCode7())));
        BarDataSet setEntries = new BarDataSet(entries,getString(R.string.codeSent));

        BarData theData = new BarData(setEntries);
        barChart.setData(theData);

        barChart.setTouchEnabled(false);
        barChart.setDragEnabled(false);
        barChart.setScaleEnabled(false);
        barChart.getAxisRight().setDrawLabels(false);
        barChart.getAxisLeft().setGranularity(1.0f);
        barChart.getAxisLeft().setGranularityEnabled(true);
        buttonH.setOnClickListener(new View.OnClickListener() {
                                      @Override public void onClick(View v) {
                                          finish();
                                      }
                                  }
        );
    }
}