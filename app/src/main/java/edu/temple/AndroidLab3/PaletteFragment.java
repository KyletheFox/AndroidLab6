package edu.temple.AndroidLab3;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {

    public static final String dataKey = "frag_data";

    FrameLayout frameLayout;

    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_palette, container, false);
        this.frameLayout = (FrameLayout) v.findViewById(R.id.palette_window);

        if (getArguments() != null && getArguments().getString(dataKey) != null) {
            String color = getArguments().getString(dataKey);
            frameLayout.setBackgroundColor(Color.parseColor(color));
        }

        return v;
    }

//    public void setBackground(String color) {
//        this.frameLayout.setBackgroundColor(Color.parseColor(color));
//    }

}
