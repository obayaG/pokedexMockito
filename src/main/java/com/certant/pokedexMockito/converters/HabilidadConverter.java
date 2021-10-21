package com.certant.pokedexMockito.converters;

import org.springframework.stereotype.Component;

import com.certant.pokedexMockito.entitites.Habilidad;
import com.certant.pokedexMockito.models.HabilidadModel;

@Component("habilidadConverter")
public class HabilidadConverter {
	
	public HabilidadModel entityToModel(Habilidad habilidad) {
		if(habilidad==null)return null;
		return new HabilidadModel(habilidad.getIdHabilidad(),habilidad.getHabilidad());
	}
	
	public Habilidad modelToEntity(HabilidadModel habilidad) {
		if(habilidad==null)return null;
		return new Habilidad(habilidad.getIdHabilidad(),habilidad.getHabilidad());
	}

}
