package br.com.brickup.task.model.dto;

import br.com.brickup.task.model.enums.StatusTask;
import lombok.Data;

import java.util.Date;

@Data
public class TaskDTO {

    private Long id;
    private String nome;
    private String descricao;
    private StatusTask status;
    private Date data;
    private byte[] imagem;
}
