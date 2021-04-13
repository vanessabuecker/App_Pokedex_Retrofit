package com.vbuecker.pokedexretrofitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vbuecker.pokedexretrofitapp.Retrofit.IPokemonDex;
import com.vbuecker.pokedexretrofitapp.Retrofit.RetrofitClient;
import com.vbuecker.pokedexretrofitapp.adapter.PokemonListAdapter;
import com.vbuecker.pokedexretrofitapp.common.Common;
import com.vbuecker.pokedexretrofitapp.model.Pokedex;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class PokemonList extends Fragment {

    IPokemonDex iPokemonDex;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    RecyclerView pokemon_list_recyclerView;
    RecyclerView fragment_recyclerView;
    SearchView searchView;


    static PokemonList instance;

    public static PokemonList getInstance() {
        if (instance == null)
            instance = new PokemonList();
        return instance;
    }


    public PokemonList() {
        Retrofit retrofit = RetrofitClient.getInstance();
        iPokemonDex = retrofit.create(IPokemonDex.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);
        View view1 = inflater.inflate(R.layout.fragment_homepagelist, container, false);
        pokemon_list_recyclerView = (RecyclerView) view.findViewById(R.id.pokemon_list_recyclerView);
        fragment_recyclerView = (RecyclerView) view1.findViewById(R.id.recyclerView);
        pokemon_list_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        fragment_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));


        fetchData();
        return view1;

    }

    private void fetchData() {
        compositeDisposable.add(iPokemonDex.getListPokemon()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Pokedex>() {

                    @Override
                    public void accept(Pokedex pokedex) throws Exception {
                        Common.commonPokemonList = pokedex.getPokemon();
                        PokemonListAdapter adapter = new PokemonListAdapter(getActivity(), Common.commonPokemonList);
                        pokemon_list_recyclerView.setAdapter(adapter);
                        fragment_recyclerView.setAdapter(adapter);
                    }
                })
        );
    }
}
