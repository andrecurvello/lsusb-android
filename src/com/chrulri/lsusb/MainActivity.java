
package com.chrulri.lsusb;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends ListActivity {

    private UsbAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new UsbAdapter(this);
        adapter.loadDevices();
        setListAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.loadDevices();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter = null;
    }

}
