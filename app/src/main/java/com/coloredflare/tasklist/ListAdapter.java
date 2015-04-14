package com.coloredflare.tasklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.coloredflare.tasklist.db.List;
import com.coloredflare.tasklist.db.Lists;


public class ListAdapter extends BaseAdapter{

    private final Context context;
    private final int resource;
    private final Lists lists;

    public ListAdapter(Context context, int resource, Lists lists) {
//        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.lists = lists;

    }

    @Override
    public int getCount() {
        return lists.count();
    }

    @Override
    public List getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lists.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView;
        if(convertView == null)
            rootView = inflater.inflate(resource, parent, false);
        else
            rootView = convertView;

        TextView textView = (TextView) rootView.findViewById(R.id.textView);
        textView.setText(lists.get(position).toString());

        return rootView;
    }
}
