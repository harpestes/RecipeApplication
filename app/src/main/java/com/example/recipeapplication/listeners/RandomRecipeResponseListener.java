package com.example.recipeapplication.listeners;

import com.example.recipeapplication.models.payload.RandomRecipeResponse;

public interface RandomRecipeResponseListener {

    void fetch(RandomRecipeResponse response, String message);

    void throwError(String message);
}
