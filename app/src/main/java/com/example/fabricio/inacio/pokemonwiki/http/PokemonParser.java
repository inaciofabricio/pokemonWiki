package com.example.fabricio.inacio.pokemonwiki.http;


import com.example.fabricio.inacio.pokemonwiki.parser.Pokemon;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PokemonParser {

    public static Pokemon getPokemonDetail(int id) throws IOException {
        String url = String.format("https://pokeapi.co/api/v2/pokemon/%s/", id);

        String json = getResponse(url);

        Gson gson = new Gson();
        Pokemon result = gson.fromJson(json, Pokemon.class);
        return result;
    }

    private static String getResponse(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


}
