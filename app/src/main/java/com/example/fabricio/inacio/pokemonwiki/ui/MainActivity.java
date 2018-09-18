package com.example.fabricio.inacio.pokemonwiki.ui;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fabricio.inacio.pokemonwiki.R;
import com.example.fabricio.inacio.pokemonwiki.dao.PokemonDao;
import com.example.fabricio.inacio.pokemonwiki.databinding.ActivityMainBinding;
import com.example.fabricio.inacio.pokemonwiki.http.PokemonParser;
import com.example.fabricio.inacio.pokemonwiki.parser.Pokemon;


import org.parceler.Parcels;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_POKEMON = "pokemon";
    public static final String DETAIL_FRAGMENT = "detailFragment";

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);

        Pokemon pokemon = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_POKEMON));

        if (savedInstanceState == null) {
            PokemonDetalheFragment mdf = PokemonDetalheFragment.newInstance(pokemon);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_detail, mdf, DETAIL_FRAGMENT)
                    .commit();
        }


    }
}
