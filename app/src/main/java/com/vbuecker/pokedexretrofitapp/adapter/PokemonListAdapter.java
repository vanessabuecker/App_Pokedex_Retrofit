package com.vbuecker.pokedexretrofitapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vbuecker.pokedexretrofitapp.R;
import com.vbuecker.pokedexretrofitapp.model.Pokemon;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.MyViewHolder> {
    Context context;
    List<Pokemon> pokemonList;


    public PokemonListAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView pokemon_image;
        public TextView pokemon_name;
        public RecyclerView recyclerView;
        public TextView type;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.id_text_view);
            pokemon_image = (ImageView) itemView.findViewById(R.id.pokemon_Img);
            pokemon_name = (TextView) itemView.findViewById(R.id.pokemon_name);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.pokemon_list_recyclerView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(pokemonList.get(position).getImg()).into(holder.pokemon_image);
        holder.pokemon_name.setText(pokemonList.get(position).getName());
        holder.type.setText(pokemonList.get(position).getWeight());

    }

    @Override
    public int getItemCount() {
        return pokemonList.size();

    }
}
