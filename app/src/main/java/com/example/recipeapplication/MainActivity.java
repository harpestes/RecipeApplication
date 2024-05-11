package com.example.recipeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.adapters.RandomRecipeAdapter;
import com.example.recipeapplication.listeners.RandomRecipeResponseListener;
import com.example.recipeapplication.listeners.RecipeClickListener;
import com.example.recipeapplication.models.payload.RandomRecipeResponse;
import com.example.recipeapplication.services.RequestManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar dialog;
    private RequestManager manager;
    private final List<String> tags = new ArrayList<>();
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dialog = findViewById(R.id.progress_bar);

        Spinner spinner = findViewById(R.id.spinner_tags);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.tags,
                R.layout.spinner_text
        );

        arrayAdapter.setDropDownViewResource(R.layout.spinner_inner_text);

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(spinnerSelectorListener);

        searchView = findViewById(R.id.search_home);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setVisibility(View.VISIBLE);
                tags.clear();
                tags.add(query);
                manager.getRandomRecipes(randomRecipeResponseListener, tags, 20);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        manager = new RequestManager(this);
    }

    private final RandomRecipeResponseListener randomRecipeResponseListener = new RandomRecipeResponseListener() {
        @Override
        public void fetch(RandomRecipeResponse response, String message) {
            dialog.setVisibility(View.GONE);
            RecyclerView recyclerView = findViewById(R.id.recycler_random);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
            RandomRecipeAdapter randomRecipeAdapter = new RandomRecipeAdapter(MainActivity.this, response.getRecipes(), recipeClickListener);
            recyclerView.setAdapter(randomRecipeAdapter);
        }

        @Override
        public void throwError(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private final AdapterView.OnItemSelectedListener spinnerSelectorListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            dialog.setVisibility(View.VISIBLE);
            searchView.setQuery("", false);
            searchView.clearFocus();
            tags.clear();
            tags.add(parent.getSelectedItem().toString());

            manager.getRandomRecipes(randomRecipeResponseListener, tags, 10);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            dialog.setVisibility(View.VISIBLE);
            searchView.setQuery("", false);
            searchView.clearFocus();
            tags.clear();
            tags.add(parent.getSelectedItem().toString());

            manager.getRandomRecipes(randomRecipeResponseListener, Collections.singletonList("main course"), 10);
        }
    };

    private final RecipeClickListener recipeClickListener = id -> startActivity(
            new Intent(MainActivity.this, RecipeDetailsActivity.class)
                    .putExtra("recipeId", id)
    );
}