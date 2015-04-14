package com.coloredflare.tasklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.coloredflare.tasklist.db.Tasks;

public class TaskAdapter extends BaseAdapter {

    private final Context context;
    private final int resource;
    private final Tasks tasks;

    public TaskAdapter(Context context, int resource, Tasks tasks) {
        this.context = context;
        this.resource = resource;
        this.tasks = tasks;

    }
    @Override
    public int getCount() {
        return tasks.count();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tasks.get(position).getId();
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
        textView.setText(tasks.get(position).toString());

        return rootView;
    }
}
