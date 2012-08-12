
package com.chrulri.lsusb;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

final class UsbAdapter extends ArrayAdapter<UsbDevice> {

    private final UsbManager manager;
    private final LayoutInflater inflater;

    public UsbAdapter(Context context) {
        super(context, 0);
        this.manager = (UsbManager) context.getSystemService(Context.USB_SERVICE);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void loadDevices() {
        setNotifyOnChange(false);
        clear();
        addAll(manager.getDeviceList().values());
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listitem_usb, parent, false);
        }

        UsbDevice device = getItem(position);

        // TODO handle view

        return convertView;
    }
}
