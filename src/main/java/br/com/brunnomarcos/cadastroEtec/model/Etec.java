package br.com.brunnomarcos.cadastroEtec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.etechoracio.common.model.BaseORM;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ETEC")
public class Etec extends BaseORM{
	
	@Id
	@GeneratedValue
	@Column(name="ID_ETEC")
	private Long id;
	
	@Column(name="NM_ETEC")
	private String nome;
	
	@Column(name="CDG_ETEC")
	private Integer codigo;
	
	@Column(name="ENDERECO")
	private String logradouro;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="CEP")
	private String cep;
	
}
