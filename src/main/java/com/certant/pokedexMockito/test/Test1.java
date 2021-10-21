package com.certant.pokedexMockito.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.certant.pokedexMockito.entitites.Habilidad;
import com.certant.pokedexMockito.entitites.PokemonDato;
import com.certant.pokedexMockito.entitites.PokemonRaza;
import com.certant.pokedexMockito.entitites.Tipo;
import com.certant.pokedexMockito.repositories.IPokemonDatoRepository;
import com.certant.pokedexMockito.repositories.ITipoRepository;
import com.certant.pokedexMockito.services.implementation.PokemonDatoService;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@SpringBootTest
public class Test1 {
	
	
	@MockBean
	@Qualifier("pokemonDatoRepository")
	IPokemonDatoRepository pokemonDatoRepository;
	
	@MockBean
	@Qualifier("tipoRepository")
	ITipoRepository tipoRepository;
	
	@Autowired
	@Qualifier("pokemonDatoService")
	PokemonDatoService pokemonDatoService;
	
	@BeforeEach
    void setUp()
    {
        setUpPokemon();
    }
	
	private void setUpPokemon() {
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
		List<PokemonDato> listaMock= new ArrayList<PokemonDato>();
		listaMock.add(p1);
		listaMock.add(p2);
		listaMock.add(p3);
		when(pokemonDatoService.traerTodosLosPokemones()).thenReturn(listaMock);
	}

	@Test
	public void traerTodos() {
		List<PokemonDato> lista= pokemonDatoService.traerTodosLosPokemones();
		System.out.println(lista);
		assertFalse(lista.isEmpty());
	}
	
	
	
	

}
