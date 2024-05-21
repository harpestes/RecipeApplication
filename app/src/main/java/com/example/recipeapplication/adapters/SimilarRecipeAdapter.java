package com.example.recipeapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;
import com.example.recipeapplication.adapters.viewHolders.SimilarRecipeViewHolder;
import com.example.recipeapplication.listeners.RecipeClickListener;
import com.example.recipeapplication.models.payload.SimilarRecipesResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimilarRecipeAdapter extends RecyclerView.Adapter<SimilarRecipeViewHolder> {

    private final Context context;
    private final List<SimilarRecipesResponse> list;
    private final RecipeClickListener listener;
    private final String recipeName;
    private final String recipeImage;

    @NonNull
    @Override
    public SimilarRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimilarRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_similar_recipe, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarRecipeViewHolder holder, int position) {
        holder.getTextView_similar_title().setText(list.get(position).getTitle());
        holder.getTextView_similar_title().setSelected(true);
        holder.getTextView_similar_servings().setText(String.format("%s Persons", list.get(position).getServings()));

        if(recipeName.equals(list.get(position).getTitle())) {
            Picasso.get()
                    .load(recipeImage)
                    .into(holder.getImageView_similar());
        }
        else {
            Picasso.get()
                    .load(String.format(
                                    "https://img.spoonacular.com/recipes/%s-556x370.%s",
                                    list.get(position).getId(),
                                    list.get(position).getImageType()
                            )
                    )
                    .into(holder.getImageView_similar());
        }

        holder.getSimilar_recipe_holder().setOnClickListener(
                v -> listener.onRecipeClicked(
                        String.valueOf(list.get(holder.getAdapterPosition()).getId())
                )
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
