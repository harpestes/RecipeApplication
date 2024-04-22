package com.example.recipeapplication.services;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.recipeapplication.R;
import com.example.recipeapplication.listeners.RandomRecipeResponseListener;
import com.example.recipeapplication.models.payload.RandomRecipeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
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

    public void getRandomRecipes(RandomRecipeResponseListener responseListener) {
        CallRandomRecipes callRandomRecipes = retrofit.create(CallRandomRecipes.class);

        Call<RandomRecipeResponse> call = callRandomRecipes.callRandomRecipe(context.getString(R.string.API_KEY), "10");

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

    private interface CallRandomRecipes {

        @GET("/recipes/random")
        Call<RandomRecipeResponse> callRandomRecipe(
                @Query("apiKey") String apiKey,
                @Query("number") String numberOfRecipes
        );
    }
}
