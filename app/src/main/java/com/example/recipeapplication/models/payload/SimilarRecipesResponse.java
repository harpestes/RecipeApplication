package com.example.recipeapplication.models.payload;

import lombok.Getter;

@Getter
public class SimilarRecipesResponse {

    private int id;
    private String title;
    private String imageType;
    private int readyInMinutes;
    private int servings;
    private String sourceUrl;
}
