package com.projeto.board_de_tarefas.service;

import com.projeto.board_de_tarefas.model.Tarefas;
import com.projeto.board_de_tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefas> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefas> buscarTarefa(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefas salvarTarefa(Tarefas tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
