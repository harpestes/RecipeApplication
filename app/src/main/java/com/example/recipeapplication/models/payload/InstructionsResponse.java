package com.example.recipeapplication.models.payload;

import com.example.recipeapplication.models.Step;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class InstructionsResponse {

    private String name;
    private ArrayList<Step> steps;
}
