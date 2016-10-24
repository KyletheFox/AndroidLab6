package edu.temple.AndroidLab3;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class CanvasActivity extends Activity implements CanvasFragment.CanvasInterface {

    boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // See if the palette fragment has be init
        twoPanes = (findViewById(R.id.palette_fragment) != null);

        CanvasFragment canvasFragment = new CanvasFragment();

        Bundle bundle = new Bundle();
        bundle.putStringArray(canvasFragment.dataKey, getResources().getStringArray(R.array.color_array));
        canvasFragment.setArguments(bundle);

        loadFragment(R.id.canvas_fragment, canvasFragment, false);

        if (twoPanes) {
            loadFragment(R.id.palette_fragment, new PaletteFragment(), false);
        }

    }

    @Override
    public void acceptBgColor(String str) {
        PaletteFragment paletteFragment = new PaletteFragment();

        Bundle bundle = new Bundle();
        bundle.putString(paletteFragment.dataKey, str);
        paletteFragment.setArguments(bundle);

        if (twoPanes) {
            loadFragment(R.id.palette_fragment, paletteFragment, !twoPanes);
        } else {
            loadFragment(R.id.canvas_fragment, paletteFragment, !twoPanes);
        }
    }

    //  Load fragment in a specified frame
    private void loadFragment(int paneId, Fragment fragment, boolean placeOnBackstack){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .replace(paneId, fragment);
        if (placeOnBackstack)
            ft.addToBackStack(null);
        ft.commit();

        //  Ensure fragment is attachecd before attempting to call its public methods
        fm.executePendingTransactions();
    }
}
