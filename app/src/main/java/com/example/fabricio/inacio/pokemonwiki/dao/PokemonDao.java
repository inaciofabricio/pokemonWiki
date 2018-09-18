package com.example.fabricio.inacio.pokemonwiki.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.fabricio.inacio.pokemonwiki.model.Pokemon;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface PokemonDao {

    @Insert(onConflict = IGNORE)
    void insertPokemon(Pokemon pokemon);

    @Query("SELECT * FROM Pokemon ORDER BY nome")
    LiveData<List<Pokemon>> listAllFavorites();

    @Query("SELECT COUNT(*) FROM Pokemon WHERE id = :id")
    boolean isFavorite(int id);

    @Delete
    void deleteMovies(Pokemon... pokemons);
}
