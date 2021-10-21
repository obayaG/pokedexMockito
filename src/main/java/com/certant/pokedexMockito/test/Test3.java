package com.certant.pokedexMockito.test;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;


import com.certant.pokedexMockito.entitites.Habilidad;
import com.certant.pokedexMockito.entitites.PokemonDato;
import com.certant.pokedexMockito.entitites.PokemonRaza;
import com.certant.pokedexMockito.entitites.Tipo;
import com.certant.pokedexMockito.services.implementation.PokemonDatoService;

@SpringBootTest
public class Test3 {
	
	
	
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
		PokemonRaza pokemonRaza= new PokemonRaza(1);
		PokemonDato p1= new PokemonDato(1,"Pichu",t1,t2,n1,oE1,pokemonRaza,habilidades);
		PokemonDato p2= new PokemonDato(2,"Pikachu",t1,t2,n2,oE2,pokemonRaza,habilidades);
		PokemonDato p3= new PokemonDato(3,"Raichu",t1,t2,n3,oE3,new PokemonRaza(1),habilidades);
		Set <PokemonDato> listaMock= new HashSet<PokemonDato>();
		listaMock.add(p1);
		listaMock.add(p2);
		listaMock.add(p3);
		pokemonDatoService=Mockito.mock(PokemonDatoService.class);
		when(pokemonDatoService.traerListaPokemonesHabilidadEvolucion(Mockito.anyString())).thenReturn(listaMock);
		//doReturn(listaMock).when(pokemonDatoService).traerListaPokemonesHabilidadEvolucion(Mockito.anyString());
	}
	
	
	@Test
	 void testTraerHabilidadesYEvoluciones() {
		Set<PokemonDato> lista= pokemonDatoService.traerListaPokemonesHabilidadEvolucion("Pichu");
		System.out.println(lista);
		assertTrue(!lista.isEmpty());
	}


}
