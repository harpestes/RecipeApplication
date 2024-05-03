package com.example.recipeapplication.models;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class WinePairing {

    public ArrayList<String> pairedWines;
    public String pairingText;
    public ArrayList<ProductMatch> productMatches;
}
