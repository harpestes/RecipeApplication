package com.example.recipeapplication.listeners;

import com.example.recipeapplication.models.payload.InstructionsResponse;

import java.util.List;

public interface InstructionsListener {

    void fetch(List<InstructionsResponse> response, String message);

    void throwError(String message);
}
