package com.example.recipeapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;
import com.example.recipeapplication.adapters.viewHolders.InstructionIngredientViewHolder;
import com.example.recipeapplication.models.Ingredient;
import com.squareup.picasso.Picasso;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InstructionIngredientsAdapter extends RecyclerView.Adapter<InstructionIngredientViewHolder> {

    private final Context context;
    private final List<Ingredient> list;

    @NonNull
    @Override
    public InstructionIngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionIngredientViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instructions_step_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionIngredientViewHolder holder, int position) {
        holder.getTextView_instructions_step_item().setText(list.get(position).getName());
        holder.getTextView_instructions_step_item().setSelected(true);
        String imagePath = list.get(position).getImage();
        if (imagePath.trim().isEmpty()) {
            holder.getImageView_instructions_step_item().setImageResource(R.drawable.image_placeholder);
            holder.getImageView_instructions_step_item().setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            Picasso.get().load(imagePath).into(holder.getImageView_instructions_step_item());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
