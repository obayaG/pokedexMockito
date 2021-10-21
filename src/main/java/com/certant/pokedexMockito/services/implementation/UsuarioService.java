package com.certant.pokedexMockito.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.pokedexMockito.entitites.Usuario;
import com.certant.pokedexMockito.repositories.IUsuarioRepository;
import com.certant.pokedexMockito.services.IUsuarioService;



@Service("usuarioService")
public class UsuarioService implements IUsuarioService{
	
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	

	
	
	public List<Usuario> traerUsuarios(){
		return usuarioRepository.traerUsuarios();
	}

}
