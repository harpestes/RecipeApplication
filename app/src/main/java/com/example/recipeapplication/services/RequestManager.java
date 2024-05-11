package com.example.recipeapplication.services;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.recipeapplication.R;
import com.example.recipeapplication.listeners.InstructionsListener;
import com.example.recipeapplication.listeners.RandomRecipeResponseListener;
import com.example.recipeapplication.listeners.RecipeDetailsListener;
import com.example.recipeapplication.listeners.SimilarRecipesListener;
import com.example.recipeapplication.models.payload.InstructionsResponse;
import com.example.recipeapplication.models.payload.RandomRecipeResponse;
import com.example.recipeapplication.models.payload.RecipeDetailsResponse;
import com.example.recipeapplication.models.payload.SimilarRecipesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RequestManager {

    private final Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getRandomRecipes(RandomRecipeResponseListener responseListener, List<String> includeTags, int numberOfRecipes) {
        CallRandomRecipes callRandomRecipes = retrofit.create(CallRandomRecipes.class);

        Call<RandomRecipeResponse> call = callRandomRecipes.callRandomRecipe(context.getString(R.string.API_KEY), includeTags, numberOfRecipes + "");

        call.enqueue(
                new Callback<RandomRecipeResponse>() {
                    @Override
                    public void onResponse(
                            @NonNull Call<RandomRecipeResponse> call,
                            @NonNull Response<RandomRecipeResponse> response
                    ) {
                        if (!response.isSuccessful()) {
                            responseListener.throwError(response.message());
                            return;
                        }

                        responseListener.fetch(response.body(), response.message());
                    }

                    @Override
                    public void onFailure(
                            @NonNull Call<RandomRecipeResponse> call,
                            @NonNull Throwable throwable
                    ) {
                        responseListener.throwError(throwable.getMessage());
                    }
                }
        );
    }

    public void getRecipeDetails(RecipeDetailsListener responseListener, String id) {

        CallRecipeDetails callRecipeDetails = retrofit.create(CallRecipeDetails.class);

        Call<RecipeDetailsResponse> call = callRecipeDetails.callRecipeDetails(id, context.getString(R.string.API_KEY));

        call.enqueue(
                new Callback<RecipeDetailsResponse>() {
                    @Override
                    public void onResponse(
                            @NonNull Call<RecipeDetailsResponse> call,
                            @NonNull Response<RecipeDetailsResponse> response
                    ) {
                        if (!response.isSuccessful()) {
                            responseListener.throwError(response.message());
                            return;
                        }

                        responseListener.fetch(response.body(), response.message());
                    }

                    @Override
                    public void onFailure(
                            @NonNull Call<RecipeDetailsResponse> call,
                            @NonNull Throwable throwable
                    ) {
                        responseListener.throwError(throwable.getMessage());
                    }
                }
        );
    }

    public void getSimilarRecipes(SimilarRecipesListener responseListener, String id) {
        CallSimilarRecipes callSimilarRecipes = retrofit.create(CallSimilarRecipes.class);

        Call<List<SimilarRecipesResponse>> call = callSimilarRecipes.callSimilarRecipes(id, context.getString(R.string.API_KEY), "5");

        call.enqueue(
                new Callback<List<SimilarRecipesResponse>>() {
                    @Override
                    public void onResponse(
                            @NonNull Call<List<SimilarRecipesResponse>> call,
                            @NonNull Response<List<SimilarRecipesResponse>> response
                    ) {
                        if (!response.isSuccessful()) {
                            responseListener.throwError(response.message());
                            return;
                        }

                        responseListener.fetch(response.body(), response.message());
                    }

                    @Override
                    public void onFailure(
                            @NonNull Call<List<SimilarRecipesResponse>> call,
                            @NonNull Throwable throwable
                    ) {
                        responseListener.throwError(throwable.getMessage());
                    }
                }
        );
    }

    public void getInstructions(InstructionsListener responseListener, String id) {
        CallInstructions callInstructions = retrofit.create(CallInstructions.class);

        Call<List<InstructionsResponse>> call = callInstructions.callInstructions(id, context.getString(R.string.API_KEY));

        call.enqueue(
                new Callback<List<InstructionsResponse>>() {
                    @Override
                    public void onResponse(
                            @NonNull Call<List<InstructionsResponse>> call,
                            @NonNull Response<List<InstructionsResponse>> response
                    ) {
                        if (!response.isSuccessful()) {
                            responseListener.throwError(response.message());
                            return;
                        }

                        responseListener.fetch(response.body(), response.message());
                    }

                    @Override
                    public void onFailure(
                            @NonNull Call<List<InstructionsResponse>> call,
                            @NonNull Throwable throwable
                    ) {
                        responseListener.throwError(throwable.getMessage());
                    }
                }
        );
    }

    private interface CallRandomRecipes {

        @GET("/recipes/random")
        Call<RandomRecipeResponse> callRandomRecipe(
                @Query("apiKey") String apiKey,
                @Query("include-tags") List<String> includeTags,
                @Query("number") String numberOfRecipes
        );
    }

    private interface CallRecipeDetails {

        @GET("/recipes/{id}/information")
        Call<RecipeDetailsResponse> callRecipeDetails(
                @Path("id") String id,
                @Query("apiKey") String apiKey
        );
    }

    private interface CallSimilarRecipes {

        @GET("recipes/{id}/similar")
        Call<List<SimilarRecipesResponse>> callSimilarRecipes(
                @Path("id") String id,
                @Query("apiKey") String apiKey,
                @Query("number") String numberOfRecipes
        );
    }

    private interface CallInstructions {

        @GET("/recipes/{id}/analyzedInstructions")
        Call<List<InstructionsResponse>> callInstructions(
                @Path("id") String id,
                @Query("apiKey") String apiKey
        );
    }
}
