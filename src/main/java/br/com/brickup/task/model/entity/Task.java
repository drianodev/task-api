package br.com.brickup.task.model.entity;

import br.com.brickup.task.model.enums.StatusTask;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusTask status = StatusTask.PENDENTE;

    @Lob
    @Column(name = "imagem")
    private byte[] imagem;
}
