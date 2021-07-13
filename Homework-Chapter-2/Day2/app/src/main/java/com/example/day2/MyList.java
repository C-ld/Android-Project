package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.day2.myRecycler.MyAdapter;
import com.example.day2.myRecycler.TestData;
import com.example.day2.myRecycler.TestSet;

import java.util.ArrayList;
import java.util.List;

public class MyList extends AppCompatActivity{
    private List<TestData> list = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        list = TestSet.getData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);
    }

}
