package edu.temple.AndroidLab3;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class CanvasActivity extends Activity {

    boolean selectedFirst = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Spinner spin = (Spinner) findViewById(R.id.spinner);

        Resources res = getResources();
        final String[] colors = res.getStringArray(R.array.color_array);
        final String[] actualColors = res.getStringArray(R.array.actual_color_array);

        CustomAdapter adapter = new CustomAdapter(CanvasActivity.this, android.R.layout.simple_spinner_dropdown_item, colors, actualColors);

        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (selectedFirst) {
                    Intent colorActivityLauncher = new Intent(CanvasActivity.this, PaletteActivity.class);
                    colorActivityLauncher.putExtra("Color", actualColors[position]);
                    startActivity(colorActivityLauncher);
                } else {
                    selectedFirst = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
