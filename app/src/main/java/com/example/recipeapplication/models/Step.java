package com.example.recipeapplication.models;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class Step {

    private int number;
    private String step;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Equipment> equipment;
    private Length length;
}
