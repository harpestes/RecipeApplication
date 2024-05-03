package com.example.recipeapplication.adapters.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;

import lombok.Getter;

@Getter
public class IngredientsViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView_ingredients_quantity;
    private final TextView textView_ingredients_name;
    private final ImageView imageView_ingredients;

    public IngredientsViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_ingredients_quantity = itemView.findViewById(R.id.textView_ingredients_quantity);
        textView_ingredients_name = itemView.findViewById(R.id.textView_ingredients_name);
        imageView_ingredients = itemView.findViewById(R.id.imageView_ingredients);
    }
}
