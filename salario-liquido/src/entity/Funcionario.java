package entity;

import java.io.Serializable;
import java.util.List;

/**
 * Entity que representa a tabela Funcionario
 * @author Michel Mendes 	10/06/2019
 */
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long idCliente;
	private String nmCliente;
	private Double vlSalarioBruto;
	private List<Desconto> descontos;

	public Funcionario() {
		super();
	}
	
	public Funcionario(Long idCliente, String nmCliente, Double vlSalarioBruto, List<Desconto> descontos) {
		super();
		this.idCliente = idCliente;
		this.nmCliente = nmCliente;
		this.vlSalarioBruto = vlSalarioBruto;
		this.descontos = descontos;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNmCliente() {
		return nmCliente;
	}
	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}
	public Double getVlSalarioBruto() {
		return vlSalarioBruto;
	}
	public void setVlSalarioBruto(Double vlSalarioBruto) {
		this.vlSalarioBruto = vlSalarioBruto;
	}
	public List<Desconto> getDescontos() {
		return descontos;
	}
	public void setDescontos(List<Desconto> descontos) {
		this.descontos = descontos;
	}
}
