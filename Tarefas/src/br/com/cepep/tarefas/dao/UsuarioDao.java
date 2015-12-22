package br.com.cepep.tarefas.dao;

import org.springframework.stereotype.Repository;

import br.com.cepep.tarefas.model.Usuario;

@Repository
public class UsuarioDao {
	
	public boolean existeUsuario(Usuario usuario) {
		return true;
	}
}
