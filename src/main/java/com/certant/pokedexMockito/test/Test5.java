package com.certant.pokedexMockito.test;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.certant.pokedexMockito.entitites.Habilidad;
import com.certant.pokedexMockito.entitites.PokemonDato;
import com.certant.pokedexMockito.entitites.PokemonRaza;
import com.certant.pokedexMockito.entitites.PokemonUsuario;
import com.certant.pokedexMockito.entitites.Tipo;
import com.certant.pokedexMockito.entitites.Usuario;
import com.certant.pokedexMockito.services.implementation.PokemonUsuarioService;

@SpringBootTest
public class Test5 {
	
	@Autowired	
	@Qualifier("pokemonUsuarioService")
	PokemonUsuarioService pokemonUsuarioService;
	
	
	@BeforeEach
    void setUp() throws Exception
    {
        setUpPokemon();
    }
	
	private void setUpPokemon() throws Exception {
		Set<Habilidad> habilidades= new HashSet<Habilidad>();
		Habilidad habilidad1= new Habilidad("ataque1");
		Habilidad habilidad2= new Habilidad("ataque2");
		habilidades.add(habilidad1);
		habilidades.add(habilidad2);
		int oE2=2;
		int n2=30;
		Tipo t1= new Tipo("electrico");
		Tipo t2= new Tipo("no tiene");
		PokemonDato p1= new PokemonDato(2,"Pikachu",t1,t2,n2,oE2,new PokemonRaza(1),habilidades);
		Usuario usuario1 = new Usuario("Ana");
		PokemonUsuario pokemonMock1= new PokemonUsuario();	
		pokemonMock1.setPokemonDato(p1);
		pokemonMock1.setUsuario(usuario1);
		pokemonMock1.setNivel(15);
		pokemonUsuarioService= Mockito.mock(PokemonUsuarioService.class);
		doNothing().when(pokemonUsuarioService).actualizarNivelPokemon("Pichu", 15, "Ana");  
	//	when(pokemonUsuarioService.actualizarNivelPokemon("Pichu", 15, "Ana")).thenReturn(pokemonMock1);
	}
	
	
	@Test
	void testActualizarNivel() throws Exception {
		pokemonUsuarioService.actualizarNivelPokemon("Pichu", 15, "Ana");
		verify(pokemonUsuarioService, times(1)).actualizarNivelPokemon("Pichu", 15, "Ana");
		/*
		PokemonUsuario pokemon=pokemonUsuarioService.actualizarNivelPokemon("Pichu", 15, "Ana");
		System.out.println(pokemon);
		assertEquals("Pikachu",pokemon.getPokemonDato().getNombrePokemon());
		assertEquals(15,pokemon.getNivel());
		assertEquals("Ana",pokemon.getUsuario().getNombre());*/
	}
		
}
