package com.example.recipeapplication.adapters.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;

import lombok.Getter;

@Getter
public class InstructionStepViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView_instruction_step_number;
    private final TextView textView_instruction_step_title;
    private final RecyclerView recyclerView_instruction_step_equipment;
    private final RecyclerView recyclerView_instruction_step_ingredients;


    public InstructionStepViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_instruction_step_number = itemView.findViewById(R.id.textView_instruction_step_number);
        textView_instruction_step_title = itemView.findViewById(R.id.textView_instruction_step_title);
        recyclerView_instruction_step_equipment = itemView.findViewById(R.id.recyclerView_instruction_step_equipment);
        recyclerView_instruction_step_ingredients = itemView.findViewById(R.id.recyclerView_instruction_step_ingredients);
    }
}
