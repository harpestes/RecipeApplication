package com.example.recipeapplication.models;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class Recipe {

    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean dairyFree;
    private boolean veryHealthy;
    private boolean cheap;
    private boolean veryPopular;
    private boolean sustainable;
    private boolean lowFodmap;
    private int weightWatcherSmartPoints;
    private String gaps;
    private int preparationMinutes;
    private int cookingMinutes;
    private int aggregateLikes;
    private int healthScore;
    private String creditsText;
    private String license;
    private String sourceName;
    private double pricePerServing;
    private ArrayList<ExtendedIngredient> extendedIngredients;
    private int id;
    private String title;
    private int readyInMinutes;
    private int servings;
    private String sourceUrl;
    private String image;
    private String imageType;
    private String summary;
    private ArrayList<Object> cuisines;
    private ArrayList<String> dishTypes;
    private ArrayList<String> diets;
    private ArrayList<Object> occasions;
    private String instructions;
    private ArrayList<AnalyzedInstruction> analyzedInstructions;
    private Object originalId;
    private double spoonacularScore;
    private String spoonacularSourceUrl;
}
