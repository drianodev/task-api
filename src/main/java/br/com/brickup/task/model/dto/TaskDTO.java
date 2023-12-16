package br.com.brickup.task.model.dto;

import br.com.brickup.task.model.enums.StatusTask;
import lombok.Data;

@Data
public class TaskDTO {

    private Long id;
    private String nome;
    private String descricao;
    private StatusTask status;
    private byte[] imagem;
}
