package com.coloredflare.tasklist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.coloredflare.tasklist.R;
import com.coloredflare.tasklist.datatypes.Items;

public class ItemAdapter extends BaseAdapter {

    private final Context context;
    private final int resource;
    private final Items items;

    public ItemAdapter(Context context, int resource, Items tasks) {
        this.context = context;
        this.resource = resource;
        this.items = tasks;

    }
    @Override
    public int getCount() {
        return items.items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.items.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView;
        if(convertView == null)
            rootView = inflater.inflate(resource, parent, false);
        else
            rootView = convertView;

        TextView name = (TextView) rootView.findViewById(R.id.name);
        name.setText(items.items.get(position).name);

        return rootView;
    }
}
