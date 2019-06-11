package entity;

import java.io.Serializable;

/**
 * Entity que representa a tabela Desconto
 * @author Michel Mendes 	10/06/2019
 */
public class Desconto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long idDesconto;
	private Double vlDesconto;
	
	public Desconto() {
		super();
	}
	
	public Desconto(Long idDesconto, Double vlDesconto) {
		super();
		this.idDesconto = idDesconto;
		this.vlDesconto = vlDesconto;
	}
	
	public Long getIdDesconto() {
		return idDesconto;
	}
	public void setIdDesconto(Long idDesconto) {
		this.idDesconto = idDesconto;
	}
	public Double getVlDesconto() {
		return vlDesconto;
	}
	public void setVlDesconto(Double vlDesconto) {
		this.vlDesconto = vlDesconto;
	}
	
}
