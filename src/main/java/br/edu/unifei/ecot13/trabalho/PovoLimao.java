package br.edu.unifei.ecot13.trabalho;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class PovoLimao extends SeresVivos{
	private static final long serialVersionUID = -5007497785542666254L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private boolean ehLeal;
	private boolean sabeFalar;
	
}