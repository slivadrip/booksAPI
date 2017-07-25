package com.slivadrip.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slivadrip.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

	
}
