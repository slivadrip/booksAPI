package com.slivadrip.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.slivadrip.socialbooks.domain.Comentario;
import com.slivadrip.socialbooks.domain.Livro;
import com.slivadrip.socialbooks.repository.ComentariosRepository;
import com.slivadrip.socialbooks.repository.LivrosRepository;
import com.slivadrip.socialbooks.services.exceptions.LivroNaoEncrontadoExcption;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id){
		Livro livro = livrosRepository.findOne(id);
		
		if(livro == null){
			throw new LivroNaoEncrontadoExcption("O Livro não foi encrontado.");
		}
		
		return livro;
	}
	
	public Livro salvar(Livro livro){
		//livro.setId(null);	
		
		return livrosRepository.save(livro);
		
	}
	
	public void deletar(Long id){
		
		try{
			livrosRepository.delete(id);
     		}catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncrontadoExcption("O Livro não foi encrontado.");
		}
	}
	
	public void atualizar(Livro livro){
		verificarExistencia(livro.getId());
		livrosRepository.save(livro);
	}
	
	
	private void verificarExistencia(Long id){
		buscar(id);
	}

	public Comentario salvarComentario(Long livroId, Comentario comentario){
		Livro livro = buscar(livroId);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		return comentariosRepository.save(comentario);
		
		
	}
	
	public List<Comentario> listarComentarios(Long livroId){
		Livro livro = buscar(livroId);
		
		return livro.getComentarios();
	}
}
