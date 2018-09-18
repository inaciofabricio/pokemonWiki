package com.example.fabricio.inacio.pokemonwiki.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Entity
@Parcel
public class Pokemon {

    @PrimaryKey
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String nome;
}
