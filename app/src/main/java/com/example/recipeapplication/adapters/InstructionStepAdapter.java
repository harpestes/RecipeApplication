package com.example.recipeapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;
import com.example.recipeapplication.adapters.viewHolders.InstructionStepViewHolder;
import com.example.recipeapplication.models.Step;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InstructionStepAdapter extends RecyclerView.Adapter<InstructionStepViewHolder> {

    private final Context context;
    private final List<Step> list;

    @NonNull
    @Override
    public InstructionStepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionStepViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instructions_step, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionStepViewHolder holder, int position) {
        holder.getTextView_instruction_step_number().setText(String.valueOf(list.get(position).getNumber()));
        holder.getTextView_instruction_step_title().setText(list.get(position).getStep());

        holder.getRecyclerView_instruction_step_ingredients().setHasFixedSize(true);
        holder.getRecyclerView_instruction_step_ingredients().setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        InstructionIngredientsAdapter ingredientsAdapter = new InstructionIngredientsAdapter(context, list.get(position).getIngredients());
        holder.getRecyclerView_instruction_step_ingredients().setAdapter(ingredientsAdapter);

        holder.getRecyclerView_instruction_step_equipment().setHasFixedSize(true);
        holder.getRecyclerView_instruction_step_equipment().setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        InstructionEquipmentsAdapter equipmentsAdapter = new InstructionEquipmentsAdapter(context, list.get(position).getEquipment());
        holder.getRecyclerView_instruction_step_equipment().setAdapter(equipmentsAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
