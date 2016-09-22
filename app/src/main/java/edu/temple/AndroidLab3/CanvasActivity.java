package edu.temple.AndroidLab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Spinner spin = (Spinner) findViewById(R.id.spinner);

        final String[] colors = {"Red", "Yellow", "Green", "Blue", "Magenta"};

        CustomAdapter adapter = new CustomAdapter(CanvasActivity.this, android.R.layout.simple_spinner_dropdown_item, colors);

        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent colorActivityLauncher = new Intent(CanvasActivity.this, PaletteActivity.class);
                colorActivityLauncher.putExtra("Color", colors[position]);
                startActivity(colorActivityLauncher);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
