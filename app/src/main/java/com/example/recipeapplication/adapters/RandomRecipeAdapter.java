package com.example.recipeapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;
import com.example.recipeapplication.adapters.viewHolders.RandomRecipeViewHolder;
import com.example.recipeapplication.listeners.RecipeClickListener;
import com.example.recipeapplication.models.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class RandomRecipeAdapter extends RecyclerView.Adapter<RandomRecipeViewHolder> {

    private final Context context;
    private final List<Recipe> list;
    private final RecipeClickListener listener;

    public RandomRecipeAdapter(Context context, List<Recipe> list, RecipeClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_random_recipe, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {
        holder.getTextView_title().setText(list.get(position).getTitle());
        holder.getTextView_title().setSelected(true);
        holder.getTextView_likes().setText(String.format(Locale.getDefault(), "%d Likes", list.get(position).getAggregateLikes()));
        holder.getTextView_servings().setText(String.format(Locale.getDefault(), "%d Servings", list.get(position).getServings()));
        holder.getTextView_time().setText(String.format(Locale.getDefault(), "%d Minutes", list.get(position).getReadyInMinutes()));
        Picasso.get().load(list.get(position).getImage()).into(holder.getImageView_food());

        holder.getRandom_list_container().setOnClickListener(v -> listener.onRecipeClicked(
                        String.valueOf(list.get(holder.getAdapterPosition()).getId())
                )
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
