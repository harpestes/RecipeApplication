package com.example.recipeapplication.models.payload;

import com.example.recipeapplication.models.ExtendedIngredient;
import com.example.recipeapplication.models.WinePairing;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class RecipeDetailsResponse {

    private int id;
    private String title;
    private String image;
    private String imageType;
    private int servings;
    private int readyInMinutes;
    private String license;
    private String sourceName;
    private String sourceUrl;
    private String spoonacularSourceUrl;
    private double healthScore;
    private double spoonacularScore;
    private double pricePerServing;
    private ArrayList<Object> analyzedInstructions;
    private boolean cheap;
    private String creditsText;
    private ArrayList<Object> cuisines;
    private boolean dairyFree;
    private ArrayList<Object> diets;
    private String gaps;
    private boolean glutenFree;
    private String instructions;
    private boolean ketogenic;
    private boolean lowFodmap;
    private ArrayList<Object> occasions;
    private boolean sustainable;
    private boolean vegan;
    private boolean vegetarian;
    private boolean veryHealthy;
    private boolean veryPopular;
    private boolean whole30;
    private int weightWatcherSmartPoints;
    private ArrayList<String> dishTypes;
    private ArrayList<ExtendedIngredient> extendedIngredients;
    private String summary;
    private WinePairing winePairing;
}
