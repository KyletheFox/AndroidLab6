package edu.temple.AndroidLab3;


import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    public static final String dataKey = "frag_data";
    private boolean selected;
    private CanvasInterface canvasInterface;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selected = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);

        Spinner spin = (Spinner) v.findViewById(R.id.spinner);

        Resources res = getResources();
        final String[] colors = res.getStringArray(R.array.color_array);
        final String[] actualColors = res.getStringArray(R.array.actual_color_array);

        CustomAdapter adapter = new CustomAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, colors, actualColors);

        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (selected) {
                    canvasInterface.acceptBgColor(actualColors[position]);
                    selected = false;
                } else
                    selected = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            canvasInterface = (CanvasInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement CanvasInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        canvasInterface = null;
    }

    public interface CanvasInterface {
        void acceptBgColor(String str);
    }

}
