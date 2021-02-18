package localhost.mongodb.springbootmongodbexample.document;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ApoliceDetalhe extends Apolices implements Serializable {

	private static final long serialVersionUID = 34535L;

	private Clientes cliente;
	
	public ApoliceDetalhe() {
		
	}
	
	
	/**
	 * @param numero
	 * @param vigenciaInicio
	 * @param vigenciaFim
	 * @param placaVeiculo
	 * @param valor
	 * @param cpfCliente
	 * @param cliente
	 */
	public ApoliceDetalhe(Long numero, Date vigenciaInicio, Date vigenciaFim, String placaVeiculo, Double valor,
			Long cpfCliente, Clientes cliente) {
		super();
		super.setNumero(numero);
		super.setVigenciaInicio (vigenciaInicio);
		super.setVigenciaFim (vigenciaFim);
		super.setPlacaVeiculo (placaVeiculo);
		super.setValor (valor);
		super.setCpfCliente (cpfCliente);
		this.cliente = cliente;
	}

	
	/**
	 * @param numero
	 * @param vigenciaInicio
	 * @param vigenciaFim
	 * @param placaVeiculo
	 * @param valor
	 * @param cpfCliente
	 * @param cliente
	 */
	public ApoliceDetalhe(Apolices apolices, Clientes cliente) {
		super();
		super.setNumero(apolices.getNumero());
		super.setVigenciaInicio (apolices.getVigenciaInicio());
		super.setVigenciaFim (apolices.getVigenciaFim());
		super.setPlacaVeiculo (apolices.getPlacaVeiculo());
		super.setValor (apolices.getValor());
		super.setCpfCliente (apolices.getCpfCliente());
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{numero=").append(super.getNumero()).append(", vigenciaInicio=").append(super.getVigenciaInicio())
				.append(", vigenciaFim=").append(super.getVigenciaFim()).append(", placaVeiculo=").append(super.getPlacaVeiculo())
				.append(", valor=").append(super.getValor()).append(", cpfCliente=").append(super.getCpfCliente())
				.append(", getEmVigencia()=").append(getEmVigencia()).append(", getDiasVigencia()=").append(getDiasVigencia())
				.append(", cliente=").append(cliente.toString())
				.append("}");
		return builder.toString();
	}
	
	
	



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Clientes getCliente() {
		return cliente;
	}


	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}



}
