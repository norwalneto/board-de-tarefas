package com.projeto.board_de_tarefas.repository;

import com.projeto.board_de_tarefas.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefas, Long> {
}
