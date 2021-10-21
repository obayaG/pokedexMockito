package com.certant.pokedexMockito.converters;

import org.springframework.stereotype.Component;

import com.certant.pokedexMockito.entitites.Usuario;
import com.certant.pokedexMockito.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioModel entityToModel(Usuario usuario) {
		if(usuario==null)return null;
		return new UsuarioModel(usuario.getIdUsuario(),usuario.getNombre());
	}
	
	public Usuario modelToEntity(UsuarioModel usuario) {
		if(usuario==null)return null;
		return new Usuario(usuario.getIdUsuario(),usuario.getNombre());
	}

}
