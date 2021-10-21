package com.certant.pokedexMockito.converters;

import org.springframework.stereotype.Component;

import com.certant.pokedexMockito.entitites.Tipo;
import com.certant.pokedexMockito.models.TipoModel;

@Component("tipoConverter")
public class TipoConverter {
	
	public TipoModel entityToModel(Tipo tipo) {
		if(tipo==null)return null;
		return new TipoModel(tipo.getIdTipo(),tipo.getTipo());
	}
	
	public Tipo modelToEntity(TipoModel tipo) {
		if(tipo==null)return null;
		return new Tipo(tipo.getIdTipo(),tipo.getTipo());
	}

}
