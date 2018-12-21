package com.abhnin.brewdogbeerrecipes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BeerPunkAPI {

    @GET("beers")
    Call<List<BeerRecipe>> getBeerRecipes();
}
