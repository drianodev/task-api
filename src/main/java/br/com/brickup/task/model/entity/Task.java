package br.com.brickup.task.model.entity;

import br.com.brickup.task.model.enums.StatusTask;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Long id;

    @Column(name = "nome", nullable = false, length = 250)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusTask status = StatusTask.PENDENTE;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_prazo")
    private Date data;

    @Lob
    @Column(name = "imagem", columnDefinition = "LONGBLOB")
    private byte[] imagem;
}
