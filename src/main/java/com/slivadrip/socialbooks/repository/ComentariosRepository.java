package com.slivadrip.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slivadrip.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

	
}
