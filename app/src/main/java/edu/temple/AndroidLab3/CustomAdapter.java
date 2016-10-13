package edu.temple.AndroidLab3;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by kyleoneill on 9/22/16.
 */
public class CustomAdapter extends ArrayAdapter {

    private String[] colors;
    private String[] actualColors;

    public CustomAdapter(Context context, int resource, String[] colors, String[] actualColors) {
        super(context, resource, colors);
        this.colors = colors;
        this.actualColors = actualColors;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = (TextView) super.getView(position, convertView, parent);
        tv.setText(this.colors[position]);
        tv.setBackgroundColor(Color.parseColor(actualColors[position]));
        return tv;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v = super.getDropDownView(position, convertView, parent);
        v.setBackgroundColor(Color.parseColor(actualColors[position]));
        return v;
    }
}
