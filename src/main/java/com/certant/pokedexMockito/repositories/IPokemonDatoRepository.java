package com.certant.pokedexMockito.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certant.pokedexMockito.entitites.PokemonDato;

@Repository ("pokemonDatoRepository")
public interface IPokemonDatoRepository extends CrudRepository<PokemonDato,Integer>{
	
	
	@Query("Select d from PokemonDato d join fetch d.pokemonRaza join fetch d.tipo1 join fetch d.tipo2 join fetch d.habilidades join fetch d.pokemonRaza")
	public abstract List<PokemonDato> traerTodosLosPokemones();
	
	
	@Query("Select p from PokemonDato p join fetch p.tipo1 join fetch p.tipo2 join fetch p.pokemonRaza join fetch p.habilidades where p.nombrePokemon=(:nombre)")
	public abstract PokemonDato traerPokemonDato(String nombre);
	
	@Query("Select d from PokemonDato d join fetch d.tipo1 join fetch d.tipo2 join fetch d.pokemonRaza r join fetch d.habilidades where r.idPokemonRaza=(:idPokemonRaza)") 
	public abstract Set<PokemonDato> traerListaPokemones(int idPokemonRaza);
	
	@Query("Select p from PokemonDato p join fetch p.tipo1 join fetch p.tipo2 join fetch p.pokemonRaza join fetch p.habilidades where p.nombrePokemon=(:nombrePokemon)")
	public abstract PokemonDato traerTodoPokemon(String nombrePokemon);
	
	@Query("Select d from PokemonDato d join fetch d.tipo1 join fetch d.tipo2 join fetch d.habilidades join fetch d.pokemonRaza r where r.idPokemonRaza=(:idPokemonRaza) and d.ordenEvolucion=(:ordenEvolucion)")
	public abstract PokemonDato traerSiguienteEvolucion(int idPokemonRaza,int ordenEvolucion);

}
