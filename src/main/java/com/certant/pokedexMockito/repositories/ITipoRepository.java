package com.certant.pokedexMockito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certant.pokedexMockito.entitites.Tipo;

@Repository ("tipoRepository")
public interface ITipoRepository extends CrudRepository<Tipo,Integer>{
	
	@Query("Select t from Tipo t where t.tipo=(:tipo)")
	public abstract Tipo traerTipo(String tipo);
	
	@Query("Select t from Tipo t")
	public abstract List<Tipo> traerTipos();

}
