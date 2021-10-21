package com.certant.pokedexMockito.test;

import java.util.HashSet;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.certant.pokedexMockito.entitites.Habilidad;
import com.certant.pokedexMockito.entitites.PokemonDato;
import com.certant.pokedexMockito.entitites.PokemonRaza;
import com.certant.pokedexMockito.entitites.Tipo;
import com.certant.pokedexMockito.repositories.IPokemonDatoRepository;
import com.certant.pokedexMockito.repositories.ITipoRepository;
import com.certant.pokedexMockito.services.implementation.PokemonDatoService;



@SpringBootTest
public class Test6 {
	
	
	@MockBean
	@Qualifier("tipoRepository")
	ITipoRepository tipoRepository;
	
	@MockBean
	@Qualifier("pokemonDatoRepository")
	IPokemonDatoRepository pokemonDatoRepository;
	
	
	
	
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
		int n1=15;
		Tipo t1= new Tipo("electrico");
		Tipo t2= new Tipo("no tiene");
		PokemonDato p1= new PokemonDato();
		p1.setIdPokemonDato(1);
		p1.setNombrePokemon("Pichu");
		p1.setOrdenEvolucion(oE1);
		p1.setNivelSiguienteEvolucion(n1);
		p1.setTipo1(t1);
		p1.setTipo2(t2);
		p1.setPokemonRaza(new PokemonRaza(1));
		p1.setHabilidades(habilidades);
		pokemonDatoService= Mockito.mock(PokemonDatoService.class);
		when(pokemonDatoService.agregar(Mockito.anyString(), Mockito.anyInt(),Mockito.anyInt(), Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(), Mockito.anySet())).thenReturn(p1);
		//doNothing().when(pokemonDatoService).agregar("Pichu", n1, oE1, "electrico","no tiene",1, habilidades);  //si el metodo fuera void
	}
	
	@Test
	void testAgregarPokemon() throws Exception {
		Set<Habilidad> habilidades= new HashSet<Habilidad>();
		Habilidad habilidad1= new Habilidad("ataque1");
		Habilidad habilidad2= new Habilidad("ataque2");
		habilidades.add(habilidad1);
		habilidades.add(habilidad2);
		PokemonDato dato= pokemonDatoService.agregar("Pichu", 15, 1, "electrico","no tiene",1, habilidades);
		System.out.println(dato);
		assertEquals("Pichu",dato.getNombrePokemon());
		assertEquals("electrico",dato.getTipo1().getTipo());
	//	verify(pokemonDatoService, times(1)).agregar("Pichu", 1, 15, "electrico","no tiene",1, habilidades);  si el metodo fuera void
	}
		

}
