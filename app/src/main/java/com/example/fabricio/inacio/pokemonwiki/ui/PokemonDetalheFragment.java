package com.example.fabricio.inacio.pokemonwiki.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fabricio.inacio.pokemonwiki.R;
import com.example.fabricio.inacio.pokemonwiki.dao.AppDatabase;
import com.example.fabricio.inacio.pokemonwiki.dao.PokemonDao;
import com.example.fabricio.inacio.pokemonwiki.databinding.FragmentPokemonDetalheBinding;
import com.example.fabricio.inacio.pokemonwiki.http.PokemonParser;
import com.example.fabricio.inacio.pokemonwiki.parser.Pokemon;

import org.parceler.Parcels;

import java.io.IOException;

import static com.example.fabricio.inacio.pokemonwiki.ui.MainActivity.EXTRA_POKEMON;


public class PokemonDetalheFragment extends Fragment {

    FragmentPokemonDetalheBinding binding;
    //PokemonDao dao;
    int numero;


    public PokemonDetalheFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {

        numero = 1;

        Log.d("teste", ""+numero+"");

        Pokemon pokemon = Parcels.unwrap(getArguments().getParcelable(EXTRA_POKEMON));

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pokemon_detalhe, container, false);
        binding.setPokemon(pokemon);

        new PokemonByIdTask().execute();

        binding.btAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anteriorPokemon();
            }
        });

        binding.btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximoPokemon();
            }
        });

        return binding.getRoot();
    }

    private void anteriorPokemon() {

        if(numero == 1) {
            numero = 721;
        }else if((numero < 722)&&(numero != 1)){
            numero--;
        }

        //Com mega evolução - infelizmente a API não tem todos os Sprites
//        if(numero == 1) {
//            numero = 10090;
//        }else if(numero == 10001){
//            numero = 721;
//        }else if((numero < 722)&&(numero != 1)&&(numero != 10001)){
//            numero--;
//        }

        new PokemonByIdTask().execute();
    }

    private void proximoPokemon() {

        if(numero == 721){
            numero = 1;
        }else if((numero > 0)&&(numero != 721)){
            numero++;
        }

        //Com mega evolução - infelizmente a API não tem todos os Sprites
//        if(numero == 10090){
//            numero = 1;
//        }else if(numero == 721){
//            numero = 10001;
//        }else if((numero > 0)&&(numero != 721)&&(numero != 10090)){
//            numero++;
//        }

        new PokemonByIdTask().execute();
    }

    public static PokemonDetalheFragment newInstance(Pokemon p) {

        Bundle params = new Bundle();
        params.putParcelable(EXTRA_POKEMON, Parcels.wrap(p));

        PokemonDetalheFragment f = new PokemonDetalheFragment();
        f.setArguments(params);

        return f;
    }


    class PokemonByIdTask extends AsyncTask<String, Void, Pokemon> {

        @Override
        protected Pokemon doInBackground(String... params) {
            try {
                return PokemonParser.getPokemonDetail(numero);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Pokemon p) {
            super.onPostExecute(p);
            if (p != null) {
                binding.setPokemon(p);
            }
        }
    }

}
