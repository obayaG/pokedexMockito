package com.certant.pokedexMockito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certant.pokedexMockito.entitites.Usuario;


@Repository ("usuarioRepository")
public interface IUsuarioRepository extends CrudRepository<Usuario,Integer>{
	
	@Query("Select u from Usuario u")
	public abstract List<Usuario> traerUsuarios();

}
