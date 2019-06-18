package com.example.hellospinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spnPotato;
    TextView tvPotato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnPotato = findViewById(R.id.spnPotato);
        tvPotato = findViewById(R.id.tvPotato);

        final String[] arrayPotatos = new String[]{"fritas", "asadas", "cochifritas", "cocidas", "bravas", "en salsa"};

        ArrayAdapter<String> adapterPotato = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayPotatos);

        spnPotato.setAdapter(adapterPotato);

        spnPotato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("MainActivity", "onItemSelected");
                tvPotato.setText(arrayPotatos[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvPotato.setText("choose potato:");
            }
        });

        spnPotato.setSelection(2);
    }
}