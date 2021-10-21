package com.certant.pokedexMockito.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.pokedexMockito.entitites.Tipo;
import com.certant.pokedexMockito.repositories.ITipoRepository;
import com.certant.pokedexMockito.services.ITipoService;



@Service("tipoService")
public class TipoService implements ITipoService{

	@Autowired
	@Qualifier("tipoRepository")
	private ITipoRepository tipoRepository;
	
	
	
	public List<Tipo> traerTipos() {
		return tipoRepository.traerTipos();
	}

}
