package com.example.recipeapplication.listeners;

import com.example.recipeapplication.models.payload.RecipeDetailsResponse;

public interface RecipeDetailsListener {

    void fetch(RecipeDetailsResponse response, String message);

    void throwError(String message);
}
