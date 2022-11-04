package com.smf.acg.sendmessagefast;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AddressAdapter extends BaseAdapter {
    private Context context;
    private List<Address> addr;




    public AddressAdapter(Context context, List<Address> addr) {
        this.context = context;
        this.addr = addr;

    }



    @Override
    public int getCount() {
        return addr.size();
    }

    @Override
    public Object getItem(int position) {

        return addr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            SharedPreferences sp = context.getSharedPreferences("AddPrefDatabase", Context.MODE_PRIVATE);
            int pos = sp.getInt("addPref",0 );
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.adapter, parent, false);
            if (addr.size()==1)   convertView.setAlpha(1.0f);
            if (position==pos){
                convertView.setAlpha(1.0f);
            }else{
                convertView.setAlpha(0.5f);
            }


        }
        Address fullAddress = addr.get(position);
        ((TextView) convertView.findViewById(R.id.addressBox)).setText(fullAddress.getAddress());
        ((TextView) convertView.findViewById(R.id.numberBox)).setText(fullAddress.getNumber());


        return convertView;
    }
}
