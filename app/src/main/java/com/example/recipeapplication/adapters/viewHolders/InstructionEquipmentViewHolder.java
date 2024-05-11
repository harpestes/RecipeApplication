package com.example.recipeapplication.adapters.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;

import lombok.Getter;

@Getter
public class InstructionEquipmentViewHolder extends RecyclerView.ViewHolder {

    private final ImageView imageView_instructions_step_item;
    private final TextView textView_instructions_step_item;

    public InstructionEquipmentViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView_instructions_step_item = itemView.findViewById(R.id.imageView_instructions_step_item);
        textView_instructions_step_item = itemView.findViewById(R.id.textView_instructions_step_item);

    }

}
