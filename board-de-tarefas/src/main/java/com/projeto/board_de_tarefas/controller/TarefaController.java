package com.projeto.board_de_tarefas.controller;

import com.projeto.board_de_tarefas.model.Tarefas;
import com.projeto.board_de_tarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefas> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefas> buscarTarefa(@PathVariable Long id) {
        return tarefaService.buscarTarefa(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarefas criarTarefa(@RequestBody Tarefas tarefa) {
        return tarefaService.salvarTarefa(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefas> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefas tarefa) {
        return tarefaService.buscarTarefa(id)
                .map(existingTarefas -> {
                    existingTarefas.setTitulo(tarefa.getTitulo());
                    existingTarefas.setDescricao(tarefa.getDescricao());
                    existingTarefas.setStatus(tarefa.getStatus());
                    existingTarefas.setPrioridade(tarefa.getPrioridade());
                    Tarefas updated = tarefaService.salvarTarefa(existingTarefas);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (tarefaService.buscarTarefa(id).isPresent()) {
            tarefaService.deletarTarefa(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
