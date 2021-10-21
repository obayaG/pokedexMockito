package com.certant.pokedexMockito.converters;

import org.springframework.stereotype.Component;
import com.certant.pokedexMockito.entitites.PokemonRaza;
import com.certant.pokedexMockito.models.PokemonRazaModel;

@Component("pokemonRazaConverter")
public class PokemonRazaConverter {
	
	
	public PokemonRazaModel entityToModel(PokemonRaza pokemonRaza) {
		if(pokemonRaza==null)return null;
		return new PokemonRazaModel(pokemonRaza.getIdPokemonRaza());
	}
	
	
	public PokemonRaza modelToEntity(PokemonRazaModel pokemonRaza) {
		if(pokemonRaza==null)return null;
		return new PokemonRaza(pokemonRaza.getIdPokemonRaza());
	}

}
