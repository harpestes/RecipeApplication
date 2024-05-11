package com.example.recipeapplication.adapters.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;

import lombok.Getter;

@Getter
public class SimilarRecipeViewHolder extends RecyclerView.ViewHolder {

    private final CardView similar_recipe_holder;
    private final TextView textView_similar_title;
    private final ImageView imageView_similar;
    private final TextView textView_similar_servings;

    public SimilarRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        similar_recipe_holder = itemView.findViewById(R.id.similar_recipe_holder);
        textView_similar_title = itemView.findViewById(R.id.textView_similar_title);
        imageView_similar = itemView.findViewById(R.id.imageView_similar);
        textView_similar_servings = itemView.findViewById(R.id.textView_similar_servings);
    }
}
