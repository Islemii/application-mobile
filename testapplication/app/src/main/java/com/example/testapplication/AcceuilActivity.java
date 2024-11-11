package com.example.testapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AcceuilActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<Item> itemList;

    private RecyclerView recyclerView1;
    private MyAdapter myAdapter1;
    private List<Item> itemList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        recyclerView = findViewById(R.id.view_cat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.oip6, "Housekeeper"));
        itemList.add(new Item(R.drawable.oip2, "Baby Sitting"));
        itemList.add(new Item(R.drawable.oip5, "Gardening"));
        itemList.add(new Item(R.drawable.oip3, "Plumbing"));
        itemList.add(new Item(R.drawable.oip10, "DIY and Assembly"));
        itemList.add(new Item(R.drawable.oip9, "Mechanic"));
        itemList.add(new Item(R.drawable.oip11, "Beauty & Good"));
        itemList.add(new Item(R.drawable.oip12, "Freelance"));
        itemList.add(new Item(R.drawable.oip14, "Painting"));

        myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);


        recyclerView1 = findViewById(R.id.view_pop);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        itemList1 = new ArrayList<>();
        itemList1.add(new Item(R.drawable.oip6, "Housekeeper"));
        itemList1.add(new Item(R.drawable.oip2, "Baby Sitting"));
        itemList1.add(new Item(R.drawable.oip5, "Gardening"));
        itemList1.add(new Item(R.drawable.oip3, "Plumbing"));
        itemList1.add(new Item(R.drawable.oip10, "DIY and Assembly"));
        itemList1.add(new Item(R.drawable.oip9, "Mechanic"));
        itemList1.add(new Item(R.drawable.oip11, "Beauty & Good"));
        itemList1.add(new Item(R.drawable.oip12, "Freelance"));
        itemList1.add(new Item(R.drawable.oip14, "Painting"));

        myAdapter1 = new MyAdapter(itemList1);
        recyclerView1.setAdapter(myAdapter1);
    }
}