package com.example.recipeapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;
import com.example.recipeapplication.adapters.viewHolders.IngredientsViewHolder;
import com.example.recipeapplication.models.ExtendedIngredient;
import com.squareup.picasso.Picasso;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsViewHolder> {

    private final Context context;
    private final List<ExtendedIngredient> ingredientList;

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IngredientsViewHolder(LayoutInflater.from(context).inflate(R.layout.list_recipe_ingradients, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
        holder.getTextView_ingredients_name().setText(ingredientList.get(position).getName());
        holder.getTextView_ingredients_name().setSelected(true);
        holder.getTextView_ingredients_quantity().setText(ingredientList.get(position).getOriginal());
        holder.getTextView_ingredients_quantity().setSelected(true);
        Picasso
                .get()
                .load("https://spoonacular.com/cdn/ingredients_100x100/" + ingredientList.get(position).getImage())
                .into(holder.getImageView_ingredients());
    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }
}
