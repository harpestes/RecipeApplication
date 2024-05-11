package com.example.recipeapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;
import com.example.recipeapplication.adapters.viewHolders.InstructionsViewHolder;
import com.example.recipeapplication.models.payload.InstructionsResponse;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InstructionsAdapter extends RecyclerView.Adapter<InstructionsViewHolder> {

    private final Context context;
    private final List<InstructionsResponse> list;

    @NonNull
    @Override
    public InstructionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionsViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instructions, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionsViewHolder holder, int position) {
        holder.getTextView_instruction_name().setText(list.get(position).getName());

        holder.getRecyclerView_instruction_steps().setHasFixedSize(true);
        holder.getRecyclerView_instruction_steps().setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        InstructionStepAdapter stepAdapter = new InstructionStepAdapter(context, list.get(position).getSteps());
        holder.getRecyclerView_instruction_steps().setAdapter(stepAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
