package com.example.recipeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.text.HtmlCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.adapters.IngredientsAdapter;
import com.example.recipeapplication.adapters.InstructionsAdapter;
import com.example.recipeapplication.adapters.SimilarRecipeAdapter;
import com.example.recipeapplication.listeners.InstructionsListener;
import com.example.recipeapplication.listeners.RecipeClickListener;
import com.example.recipeapplication.listeners.RecipeDetailsListener;
import com.example.recipeapplication.listeners.SimilarRecipesListener;
import com.example.recipeapplication.models.payload.InstructionsResponse;
import com.example.recipeapplication.models.payload.RecipeDetailsResponse;
import com.example.recipeapplication.models.payload.SimilarRecipesResponse;
import com.example.recipeapplication.services.RequestManager;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class RecipeDetailsActivity extends AppCompatActivity {

    private int recipeId;
    private String recipeName;
    private String recipeImage;
    private TextView textView_recipe_name;
    private TextView textView_recipe_source;
    private TextView textView_recipe_summary;
    private ImageView imageView_recipe_image;
    private RecyclerView recyclerView_recipe_ingredients;
    private RecyclerView recyclerView_recipe_similar;
    private RecyclerView recyclerView_recipe_instructions;

    private RequestManager manager;
    private ProgressBar dialog;
    private IngredientsAdapter ingredientsAdapter;
    private SimilarRecipeAdapter similarRecipeAdapter;
    private InstructionsAdapter instructionsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recipe_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViews();

        recipeId = Integer.parseInt(
                Objects.requireNonNull(
                        getIntent().getStringExtra("recipeId")
                )
        );

        manager = new RequestManager(this);
        manager.getRecipeDetails(recipeDetailsListener, String.valueOf(recipeId));

        manager.getSimilarRecipes(similarRecipesListener, String.valueOf(recipeId));

        manager.getInstructions(instructionsListener, String.valueOf(recipeId));

        dialog.setVisibility(View.VISIBLE);
    }

    private void findViews() {
        textView_recipe_name = findViewById(R.id.textView_recipe_name);
        textView_recipe_source = findViewById(R.id.textView_recipe_source);
        textView_recipe_summary = findViewById(R.id.textView_recipe_summary);
        imageView_recipe_image = findViewById(R.id.imageView_recipe_image);
        recyclerView_recipe_ingredients = findViewById(R.id.recyclerView_recipe_ingredients);
        recyclerView_recipe_similar = findViewById(R.id.recyclerView_recipe_similar);
        recyclerView_recipe_instructions = findViewById(R.id.recyclerView_recipe_instructions);

        dialog = findViewById(R.id.progress_bar);
    }

    private final RecipeDetailsListener recipeDetailsListener = new RecipeDetailsListener() {
        @Override
        public void fetch(RecipeDetailsResponse response, String message) {
            dialog.setVisibility(View.GONE);

            recipeName = response.getTitle();
            textView_recipe_name.setText(response.getTitle());
            textView_recipe_source.setText(response.getSourceName());
            textView_recipe_summary.setText(HtmlCompat.fromHtml(response.getSummary(), HtmlCompat.FROM_HTML_MODE_LEGACY));
            recipeImage = response.getImage();
            Picasso.get().load(response.getImage()).into(imageView_recipe_image);
            recyclerView_recipe_ingredients.setHasFixedSize(true);
            recyclerView_recipe_ingredients.setLayoutManager(new LinearLayoutManager(
                    RecipeDetailsActivity.this,
                    LinearLayoutManager.HORIZONTAL,
                    false)
            );

            ingredientsAdapter = new IngredientsAdapter(RecipeDetailsActivity.this, response.getExtendedIngredients());

            recyclerView_recipe_ingredients.setAdapter(ingredientsAdapter);
        }

        @Override
        public void throwError(String message) {
            Toast.makeText(RecipeDetailsActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private final SimilarRecipesListener similarRecipesListener = new SimilarRecipesListener() {
        @Override
        public void fetch(List<SimilarRecipesResponse> response, String message) {
            recyclerView_recipe_similar.setHasFixedSize(true);
            recyclerView_recipe_similar.setLayoutManager(new LinearLayoutManager(
                            RecipeDetailsActivity.this,
                            LinearLayoutManager.HORIZONTAL,
                            false
                    )
            );

            similarRecipeAdapter = new SimilarRecipeAdapter(RecipeDetailsActivity.this, response, recipeClickListener, recipeName, recipeImage);

            recyclerView_recipe_similar.setAdapter(similarRecipeAdapter);
        }

        @Override
        public void throwError(String message) {
            Toast.makeText(RecipeDetailsActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private final RecipeClickListener recipeClickListener = id -> startActivity(
            new Intent(RecipeDetailsActivity.this, RecipeDetailsActivity.class)
                    .putExtra("recipeId", id)
    );

    private final InstructionsListener instructionsListener = new InstructionsListener() {
        @Override
        public void fetch(List<InstructionsResponse> response, String message) {
            recyclerView_recipe_instructions.setHasFixedSize(true);
            recyclerView_recipe_instructions.setLayoutManager(
                    new LinearLayoutManager(
                            RecipeDetailsActivity.this,
                            LinearLayoutManager.VERTICAL,
                            false
                    )
            );

            instructionsAdapter = new InstructionsAdapter(RecipeDetailsActivity.this, response);

            recyclerView_recipe_instructions.setAdapter(instructionsAdapter);
        }

        @Override
        public void throwError(String message) {
            Toast.makeText(RecipeDetailsActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
}