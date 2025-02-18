package com.projeto.board_de_tarefas.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_tarefas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(length = 1000)
    private String descricao;

    private String status;

    // Nova coluna adicionada na migração V2
    private String prioridade;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;
}
