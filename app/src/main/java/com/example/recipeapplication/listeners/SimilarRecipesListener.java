package com.example.recipeapplication.listeners;

import com.example.recipeapplication.models.payload.SimilarRecipesResponse;

import java.util.List;

public interface SimilarRecipesListener {

    void fetch(List<SimilarRecipesResponse> response, String message);

    void throwError(String message);
}
