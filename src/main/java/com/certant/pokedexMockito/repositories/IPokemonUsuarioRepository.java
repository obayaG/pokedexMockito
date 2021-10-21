package com.certant.pokedexMockito.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certant.pokedexMockito.entitites.PokemonUsuario;


@Repository ("pokemonUsuarioRepository")
public interface IPokemonUsuarioRepository extends CrudRepository<PokemonUsuario,Integer>{

	
	@Query("Select p from PokemonUsuario p join fetch p.usuario u join fetch p.pokemonDato d join fetch d.tipo1 join fetch d.tipo2 join fetch d.pokemonRaza join fetch d.habilidades where d.nombrePokemon=(:nombrePokemon) and u.nombre=(:nombreUsuario)")	
	public abstract PokemonUsuario traerPokemonUsuario(String nombrePokemon,String nombreUsuario);
	
	@Query("Select u from PokemonUsuario  u join fetch u.usuario a join fetch u.pokemonDato d join fetch d.tipo1 join fetch d.tipo2 join fetch d.pokemonRaza r join fetch d.habilidades where a.nombre=(:nombreUsuario)")
	public abstract List<PokemonUsuario> traerListaPokemones(String nombreUsuario);
}
