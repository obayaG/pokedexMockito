package com.certant.pokedexMockito.services;


import java.util.Set;

import com.certant.pokedexMockito.entitites.PokemonUsuario;


public interface IPokemonUsuarioService {
	
	
	public PokemonUsuario traerPokemonUsuario(String nombre,String nombreUsuario)throws Exception;
	
	public Set<PokemonUsuario> traerListaPokemones(String nombre)throws Exception;
	
	public void actualizarNivelPokemon(String nombreABuscar,int nivel,String nombreUsuario) throws Exception;
	

}
