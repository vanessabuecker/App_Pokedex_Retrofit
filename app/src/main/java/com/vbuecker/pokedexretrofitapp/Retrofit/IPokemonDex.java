package com.vbuecker.pokedexretrofitapp.Retrofit;

import com.vbuecker.pokedexretrofitapp.model.Pokedex;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import retrofit2.http.GET;

public interface IPokemonDex {
    @GET("pokedex.json")
    Observable<Pokedex> getListPokemon();
}
