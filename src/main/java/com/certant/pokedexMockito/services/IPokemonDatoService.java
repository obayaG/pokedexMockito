package com.certant.pokedexMockito.services;


import java.util.List;
import java.util.Set;

import com.certant.pokedexMockito.entitites.Habilidad;
import com.certant.pokedexMockito.entitites.PokemonDato;

public interface IPokemonDatoService {
	
	
	public  PokemonDato agregar(String nombre, int nivelSiguienteEvolucion, int ordenEvolucion, String tipo1, String tipo2,int pokemonRaza, Set<Habilidad> habilidades) throws Exception;
	
	public  PokemonDato traerPokemonDato(String nombre);
	
	public Set<PokemonDato> traerListaPokemonesHabilidadEvolucion(String nombre);
	
	public List<PokemonDato> traerTodosLosPokemones();
	
	public PokemonDato actualizarNombrePokemon(String nombreABuscar,String nuevoNombreDeseado) throws Exception;
	
	public PokemonDato actualizarTipoPokemon(String nombreABuscar,String tipo1, String tipo2) throws Exception;

}
