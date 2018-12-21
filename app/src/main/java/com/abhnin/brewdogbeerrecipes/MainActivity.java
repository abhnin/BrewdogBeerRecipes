package com.abhnin.brewdogbeerrecipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);

        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BeerPunkAPI beerPunkAPI = retrofit.create(BeerPunkAPI.class);

        Call<List<BeerRecipe>> call = beerPunkAPI.getBeerRecipes();

        call.enqueue(new Callback<List<BeerRecipe>>() {
            @Override
            public void onResponse(Call<List<BeerRecipe>> call, Response<List<BeerRecipe>> response) {
                List<BeerRecipe> recipes = response.body();
                adapter = new BeerRecipesAdapter(recipes);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<BeerRecipe>> call, Throwable t) {

            }
        });
    }
}
