package com.example.innvision;


import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ListActivity extends AppCompatActivity {

    private ListView customListView;
    private ExpandableListView expandableListView;
    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        customListView = findViewById(R.id.custom_list_view);
        expandableListView = findViewById(R.id.expandable_list_view);
        recyclerView = findViewById(R.id.recycler_view);

        setupCustomListView();
        setupExpandableListView();
        setupRecyclerView();
    }

    private void setupCustomListView() {
        List<ClipData.Item> items = new ArrayList<>();
        items.add(new ClipData.Item("Room A", "Single Room with Sea View"));
        items.add(new ClipData.Item("Room B", "Double Room with Pool Access"));
        CustomListAdapter adapter = new CustomListAdapter(this, items);
        customListView.setAdapter((ListAdapter) adapter);
    }

    private void setupExpandableListView() {
        List<String> groupList = new ArrayList<>();
        HashMap<String, List<String>> childMap = new HashMap<>();

        groupList.add("Amenities");
        groupList.add("Attractions");

        List<String> amenities = new ArrayList<>();
        amenities.add("WiFi");
        amenities.add("Pool");
        amenities.add("Gym");

        List<String> attractions = new ArrayList<>();
        attractions.add("Beach");
        attractions.add("Mall");
        attractions.add("Museum");

        childMap.put(groupList.get(0), amenities);
        childMap.put(groupList.get(1), attractions);

        ExpandableListAdapter adapter = new ExpandableListAdapter(this, groupList, childMap);
        expandableListView.setAdapter((ListAdapter) adapter);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<ClipData.Item> items = new ArrayList<>();
        items.add(new ClipData.Item("Room C", "Suite with Garden View"));
        items.add(new ClipData.Item("Room D", "Penthouse with Ocean View"));
        RecyclerAdapter adapter = new RecyclerAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }
}
