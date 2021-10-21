package com.certant.pokedexMockito.services.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.pokedexMockito.entitites.PokemonDato;
import com.certant.pokedexMockito.entitites.PokemonUsuario;
import com.certant.pokedexMockito.repositories.IPokemonDatoRepository;
import com.certant.pokedexMockito.repositories.IPokemonUsuarioRepository;
import com.certant.pokedexMockito.services.IPokemonUsuarioService;



@Service("pokemonUsuarioService")
public class PokemonUsuarioService implements IPokemonUsuarioService{

	
	@Autowired
	@Qualifier("pokemonUsuarioRepository")
	private IPokemonUsuarioRepository pokemonUsuarioRepository;
	
	@Autowired
	@Qualifier("pokemonDatoRepository")
	private IPokemonDatoRepository pokemonDatoRepository;
	
	
	
	@Override
	public PokemonUsuario traerPokemonUsuario(String nombre, String nombreUsuario) throws Exception {
		PokemonUsuario p=pokemonUsuarioRepository.traerPokemonUsuario(nombre, nombreUsuario);
	//	if(p==null) throw new Exception("No existe pokemon de ese usuario");
		return p;
	}

	@Override
	public Set<PokemonUsuario> traerListaPokemones(String nombre) throws Exception { //nombre del usuario
		List<PokemonUsuario> lista= pokemonUsuarioRepository.traerListaPokemones(nombre);
		if(lista.isEmpty())throw new Exception("El usuario no tiene pokemones");
		Set<PokemonUsuario> listaUsuario=  new HashSet<PokemonUsuario>();
		for(PokemonUsuario d: lista) {
			listaUsuario.add(d);
		}
		return listaUsuario;
	}

	@Override
	public void actualizarNivelPokemon(String nombreABuscar, int nivel, String nombreUsuario) throws Exception {
		List<PokemonUsuario> lista=pokemonUsuarioRepository.traerListaPokemones(nombreUsuario);
		PokemonUsuario dato = null;
		PokemonDato d2 = null;
		PokemonDato pRaza=null;
		if (!lista.isEmpty()) {
			for (PokemonUsuario u : lista) {
				if (u.getPokemonDato().getNombrePokemon().equalsIgnoreCase(nombreABuscar)) {
					dato = u;
				}
			}
			if(dato==null) throw new Exception("No se ha encontrado ese pokemon, no pertenece a ese usuario");
			System.out.println("\n datos antes \n"+dato);
			if(nivel <= dato.getNivel())throw new Exception("Error, un pokemon no puede ser de menor nivel o igual que antes");
			pRaza=pokemonDatoRepository.traerPokemonDato(nombreABuscar);		
			if(pRaza!=null ) {
				Set<PokemonDato> listaPokeRaza = pokemonDatoRepository.traerListaPokemones(pRaza.getPokemonRaza().getIdPokemonRaza());
				if (!listaPokeRaza.isEmpty()) {
					for (PokemonDato d : listaPokeRaza) {
						if (d.getNivelSiguienteEvolucion() == nivel && listaPokeRaza.size() > 1 && d.getOrdenEvolucion() != listaPokeRaza.size()) {
							d2 = pokemonDatoRepository.traerSiguienteEvolucion(pRaza.getPokemonRaza().getIdPokemonRaza(),d.getOrdenEvolucion()+1);
							dato.setPokemonDato(d2);
						}
					}

				}
			}		
		}
		dato.setNivel(nivel);
		pokemonUsuarioRepository.save(dato);
		System.out.println("\n datos despues \n"+dato);
	}


}
