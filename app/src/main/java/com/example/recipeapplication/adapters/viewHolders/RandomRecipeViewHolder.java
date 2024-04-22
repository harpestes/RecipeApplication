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
public class RandomRecipeViewHolder extends RecyclerView.ViewHolder {

    private final CardView random_list_container;
    private final TextView textView_title;
    private final ImageView imageView_food;
    private final TextView textView_servings;
    private final TextView textView_likes;
    private final TextView textView_time;


    public RandomRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        random_list_container = itemView.findViewById(R.id.random_list_container);
        textView_title = itemView.findViewById(R.id.textView_title);
        imageView_food = itemView.findViewById(R.id.imageView_food);
        textView_servings = itemView.findViewById(R.id.textView_servings);
        textView_likes = itemView.findViewById(R.id.textView_likes);
        textView_time = itemView.findViewById(R.id.textView_time);
    }
}
