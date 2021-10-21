package com.certant.pokedexMockito.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
import com.certant.pokedexMockito.entitites.Tipo;
import com.certant.pokedexMockito.services.IPokemonDatoService;
import com.certant.pokedexMockito.services.implementation.PokemonDatoService;


@SpringBootTest
public class Test4 {
	
	
	@Autowired	
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
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
		int n1=15;
		Tipo t1= new Tipo("electrico");
		Tipo t2= new Tipo("no tiene");
		Tipo t3= new Tipo("fuego");
		Tipo t4= new Tipo("normal");
		PokemonDato p2= new PokemonDato(1,"Pichu",t3,t4,n1,oE1,new PokemonRaza(1),habilidades);	
		PokemonDato p3= new PokemonDato(1,"Pichus",t1,t2,n1,oE1,new PokemonRaza(1),habilidades);
		pokemonDatoService=Mockito.mock(PokemonDatoService.class);
		when(pokemonDatoService.actualizarTipoPokemon("Pichu", "fuego","normal")).thenReturn(p2);
		when(pokemonDatoService.actualizarNombrePokemon("Pichu", "Pichus")).thenReturn(p3);
		
	}
	
	@Test 
	void testActualizarInformacionDelPokemonTipo() throws Exception{
			PokemonDato dato=pokemonDatoService.actualizarTipoPokemon("Pichu", "fuego", "normal");
			System.out.println(dato);
			assertEquals("Pichu",dato.getNombrePokemon());
			assertEquals("fuego",dato.getTipo1().getTipo());
			assertEquals("normal",dato.getTipo2().getTipo());
	}
	
	@Test 
	void testActualizarInformacionDelPokemonNombre() throws Exception{
			PokemonDato dato=pokemonDatoService.actualizarNombrePokemon("Pichu", "Pichus");
			System.out.println(dato);
			assertEquals("Pichus",dato.getNombrePokemon());
	}
	
	

}
