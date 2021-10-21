package com.certant.pokedexMockito.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.pokedexMockito.entitites.PokemonRaza;
import com.certant.pokedexMockito.repositories.IPokemonRazaRepository;
import com.certant.pokedexMockito.services.IPokemonRazaService;



@Service("pokemonRazaService")
public class PokemonRazaService implements IPokemonRazaService {
	
	@Autowired
	@Qualifier("pokemonRazaRepository")
	private IPokemonRazaRepository pokemonRazaRepository;
	
	

	@Override
	public List<PokemonRaza> traerTodosPokemonRaza() {	
		return pokemonRazaRepository.traerPokemonRaza();
	}

}
