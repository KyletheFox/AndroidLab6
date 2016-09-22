package edu.temple.AndroidLab3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        String backgroundColor = getIntent().getStringExtra("Color");

        RelativeLayout bg = (RelativeLayout) findViewById(R.id.activity_palette);
        bg.setBackgroundColor(Color.parseColor(backgroundColor));
    }
}
