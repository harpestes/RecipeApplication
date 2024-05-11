package com.example.recipeapplication.listeners;

import com.example.recipeapplication.models.payload.InstructionsResponse;

public interface InstructionsListener {

    void fetch(InstructionsResponse response, String message);

    void throwError(String message);
}
