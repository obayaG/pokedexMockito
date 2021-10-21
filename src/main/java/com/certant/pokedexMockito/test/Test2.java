package com.certant.pokedexMockito.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


import java.util.HashSet;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.certant.pokedexMockito.entitites.Habilidad;
import com.certant.pokedexMockito.entitites.PokemonDato;
import com.certant.pokedexMockito.entitites.PokemonRaza;
import com.certant.pokedexMockito.entitites.PokemonUsuario;
import com.certant.pokedexMockito.entitites.Tipo;
import com.certant.pokedexMockito.entitites.Usuario;
import com.certant.pokedexMockito.repositories.IPokemonDatoRepository;
import com.certant.pokedexMockito.repositories.IPokemonUsuarioRepository;
import com.certant.pokedexMockito.services.implementation.PokemonDatoService;
import com.certant.pokedexMockito.services.implementation.PokemonUsuarioService;

@SpringBootTest
public class Test2 {
	
	
	@MockBean
	@Qualifier("pokemonDatoRepository")
	IPokemonDatoRepository pokemonDatoRepository;
	
	@MockBean
	@Qualifier("pokemonUsuarioRepository")
	IPokemonUsuarioRepository pokemonUsuarioRepository;
	

	@Autowired	
	@Qualifier("pokemonUsuarioService")
	PokemonUsuarioService pokemonUsuarioService;
	
	@Autowired
	@Qualifier("pokemonDatoService")
	PokemonDatoService pokemonDatoService;
	
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
		int oE1=1;
		int oE2=2;
		int oE3=3;
		int n1=15;
		int n2=30;
		int n3=55;
		Tipo t1= new Tipo("electrico");
		Tipo t2= new Tipo("no tiene");
		PokemonDato p1= new PokemonDato(1,"Pichu",t1,t2,n1,oE1,new PokemonRaza(1),habilidades);
		PokemonDato p2= new PokemonDato(2,"Pikachu",t1,t2,n2,oE2,new PokemonRaza(1),habilidades);
		PokemonDato p3= new PokemonDato(3,"Raichu",t1,t2,n3,oE3,new PokemonRaza(1),habilidades);
		Set <PokemonDato> listaMock= new HashSet<PokemonDato>();
		listaMock.add(p1);
		listaMock.add(p2);
		listaMock.add(p3);
		Usuario usuario1 = new Usuario("Ana");
		Usuario usuario2 = new Usuario("Pedro");
		Usuario usuario3 = new Usuario("Ash");
		PokemonUsuario pokemonMock1= new PokemonUsuario();
		PokemonUsuario pokemonMock2= new PokemonUsuario();
		PokemonUsuario pokemonMock3= new PokemonUsuario();
		pokemonMock1.setPokemonDato(p1);
		pokemonMock1.setUsuario(usuario1);
		pokemonMock1.setNivel(3);
		pokemonMock2.setPokemonDato(p2);
		pokemonMock2.setUsuario(usuario2);
		pokemonMock2.setNivel(12);
		pokemonMock3.setPokemonDato(p3);
		pokemonMock3.setUsuario(usuario3);
		pokemonMock3.setNivel(30);
		when(pokemonUsuarioService.traerPokemonUsuario("Pichu", "Ana")).thenReturn(pokemonMock1);
		when(pokemonUsuarioService.traerPokemonUsuario("Pikachu", "Pedro")).thenReturn(pokemonMock2);
		when(pokemonUsuarioService.traerPokemonUsuario("Raichu", "Ash")).thenReturn(pokemonMock3);
	}
	
	
	@Test
	void testTraerNombreTipoYNivel() throws Exception {
		PokemonUsuario pokemon=pokemonUsuarioService.traerPokemonUsuario("Pikachu", "Pedro");
		System.out.println(pokemon);
		assertTrue(pokemon!=null);
		assertEquals("Pikachu",pokemon.getPokemonDato().getNombrePokemon());
		assertEquals("Pedro",pokemon.getUsuario().getNombre());
	}
	
	
}
