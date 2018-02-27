package com.cc.andbasiccard;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fonts,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        String mg = ((String) parent.getItemAtPosition(pos)).trim();
        mg = (mg.replace(' ', '_')).toLowerCase();
        int m = getResources().getIdentifier(mg, "font", getPackageName());
        Typeface typeface = ResourcesCompat.getFont(this, m);
        TextView text = findViewById(R.id.textView);
        text.setTypeface(typeface);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
