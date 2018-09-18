package com.example.fabricio.inacio.pokemonwiki.parser;


import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;


public class Sprites {

    @SerializedName("back_female")
    public String back_female;
    @SerializedName("back_shiny_female")
    public String back_shiny_female;
    @SerializedName("back_default")
    public String back_default;
    @SerializedName("front_female")
    public String front_female;
    @SerializedName("front_shiny_female")
    public String front_shiny_female;
    @SerializedName("back_shiny")
    public String back_shiny;
    @SerializedName("front_default")
    public String front_default;
    @SerializedName("front_shiny")
    public String front_shiny;
}
