package com.example.recipeapplication.models;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class ExtendedIngredient {

    private int id;
    private String aisle;
    private String image;
    private String consistency;
    private String name;
    private String nameClean;
    private String original;
    private String originalName;
    private double amount;
    private String unit;
    private ArrayList<String> meta;
    private Measures measures;
}
