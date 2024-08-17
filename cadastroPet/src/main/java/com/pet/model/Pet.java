package com.pet.model;

import lombok.Data;

@Data
public class Pet {
	
	private String cpf;
	private String nome;
	private String descricao;
	private String raca;
	private Integer idade;

}
