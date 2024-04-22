package com.example.recipeapplication.models.payload;

import com.example.recipeapplication.models.Recipe;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class RandomRecipeResponse {

    private ArrayList<Recipe> recipes;
}
