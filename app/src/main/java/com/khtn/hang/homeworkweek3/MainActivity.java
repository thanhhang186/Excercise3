package com.khtn.hang.homeworkweek3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.RecyclerViewItemClickListener{
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(parseJsonMovie().toString());
        List<Result> results = parseJsonMovie().get(0).getResult();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(results,R.layout.layout_raw,this, this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<Movies> parseJsonMovie() {
        Gson gson = new Gson();
        List<Movies> movies = Arrays.asList(gson.fromJson(MyApp.getMessage(),Movies.class));
        return movies;
    }
    @Override
    public void onItemClick(Result result){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("detail", result);
        startActivity(intent);
    }
}
