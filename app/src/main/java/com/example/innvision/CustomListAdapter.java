package com.example.innvision;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private List<ClipData.Item> itemList;

    // Constructor
    public CustomListAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public CustomListAdapter(ListActivity context, List<ClipData.Item> itemList) {
    }

    public CustomListAdapter(MainActivity mainActivity, List<ClipData.Item> itemList) {
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // Inflate the custom layout for each list item
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false);

            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.item_title);
            holder.description = convertView.findViewById(R.id.item_description);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the current item and set its values
        ClipData.Item currentItem = itemList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescription());

        return convertView;
    }

    // ViewHolder pattern for better performance
    private static class ViewHolder {
        TextView title;
        TextView description;
    }
}
