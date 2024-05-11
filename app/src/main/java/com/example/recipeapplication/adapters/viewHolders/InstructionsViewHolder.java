package com.example.recipeapplication.adapters.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;

import lombok.Getter;

@Getter
public class InstructionsViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView_instruction_name;
    private final RecyclerView recyclerView_instruction_steps;

    public InstructionsViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_instruction_name = itemView.findViewById(R.id.textView_instruction_name);
        recyclerView_instruction_steps = itemView.findViewById(R.id.recyclerView_instruction_steps);
    }
}
