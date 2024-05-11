package com.example.recipeapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.R;
import com.example.recipeapplication.adapters.viewHolders.InstructionEquipmentViewHolder;
import com.example.recipeapplication.models.Equipment;
import com.squareup.picasso.Picasso;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InstructionEquipmentsAdapter extends RecyclerView.Adapter<InstructionEquipmentViewHolder> {

    private final Context context;
    private final List<Equipment> list;

    @NonNull
    @Override
    public InstructionEquipmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionEquipmentViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instructions_step_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionEquipmentViewHolder holder, int position) {
        holder.getTextView_instructions_step_item().setText(list.get(position).getName());
        holder.getTextView_instructions_step_item().setSelected(true);
        Picasso.get().load(list.get(position).getImage()).into(holder.getImageView_instructions_step_item());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
