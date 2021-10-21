package com.certant.pokedexMockito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certant.pokedexMockito.entitites.PokemonRaza;

@Repository ("pokemonRazaRepository")
public interface IPokemonRazaRepository extends CrudRepository<PokemonRaza,Integer>{

	@Query("Select p from PokemonRaza p")
	public abstract List<PokemonRaza> traerPokemonRaza();
}
