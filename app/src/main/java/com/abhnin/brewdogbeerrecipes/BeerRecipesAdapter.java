package com.abhnin.brewdogbeerrecipes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BeerRecipesAdapter extends RecyclerView.Adapter<BeerRecipesAdapter.BeerViewHolder>{

    List<BeerRecipe> recipes;

    public BeerRecipesAdapter(List<BeerRecipe> recipes) {
        this.recipes = recipes;

    }

    @NonNull
    @Override
    public BeerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);

        BeerViewHolder holder = new BeerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BeerViewHolder beerViewHolder, int i) {
        BeerRecipe recipe = recipes.get(i);
        beerViewHolder.textViewName.setText(recipe.getName());
        beerViewHolder.textViewDescription.setText(recipe.getDescription());
        Picasso.get().load(recipe.getImage_url()).into(beerViewHolder.imageView);



    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class BeerViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewDescription;

        public BeerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.name);
            textViewDescription = itemView.findViewById(R.id.description);
        }
    }
}
