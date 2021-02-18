package localhost.mongodb.springbootmongodbexample.document;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Apolices implements Serializable {

	private static final long serialVersionUID = 34535L;

	@Id
	private Long numero;
	private Date vigenciaInicio;
	private Date vigenciaFim;
	private String placaVeiculo;
	private Double valor;
	/**
	 * é por este campo de relacao com a entidade cliente que é usado um banco de
	 * dados relacional de tipo SQL como Oracle, Postgres, Mysql, MsSqlServer, etc e
	 * nao usar NOSQL como MongoDb. Aqui a explicacao.
	 * https://www.reddit.com/r/webdev/comments/45v12j/seriously_when_is_nosql_a_good_idea/
	 */
	private Long cpfCliente;
	


	@Transient
	private Boolean emVigencia;

	@Transient
	private int diasVigencia;

	
	
	public Apolices() {
		
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{numero=").append(numero).append(", vigenciaInicio=").append(vigenciaInicio)
				.append(", vigenciaFim=").append(vigenciaFim).append(", placaVeiculo=").append(placaVeiculo)
				.append(", valor=").append(valor).append(", emVigencia=").append(getEmVigencia()).append(", diasVigencia=")
				.append(getDiasVigencia()).append(", cpfCliente=").append(cpfCliente).append("}");
		return builder.toString();
	}


	/**
	 * @param numero
	 * @param vigenciaInicio
	 * @param vigenciaFim
	 * @param placaVeiculo
	 * @param valor
	 * @param cpfCliente
	 */
	public Apolices(Long numero, Date vigenciaInicio, Date vigenciaFim,
			String placaVeiculo, Double valor, Long cpfCliente) {
		this.numero = numero;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.placaVeiculo = placaVeiculo;
		this.valor = valor;
		this.emVigencia = emVigencia;
		this.diasVigencia = diasVigencia;
		this.cpfCliente = cpfCliente;
	}


	
	/* *
	 * @param numero
	 * @param vigenciaInicio
	 * @param vigenciaFim
	 * @param placaVeiculo
	 * @param valor
	 * @param emVigencia
	 * @param diasVigencia
	 * @param cpfCliente
	 * /
	public Apolices(Long numero, Date vigenciaInicio, Date vigenciaFim, String placaVeiculo, Double valor,
			Boolean emVigencia, int diasVigencia, Long cpfCliente) {
		this.numero = numero;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.placaVeiculo = placaVeiculo;
		this.valor = valor;
		this.emVigencia = emVigencia;
		this.diasVigencia = diasVigencia;
		this.cpfCliente = cpfCliente;
	}
*/
	
	
	
	/*
	 * @Override public String toString() { StringBuilder builder = new
	 * StringBuilder();
	 * builder.append("{numero=").append(numero).append(", vigenciaInicio=").append(
	 * vigenciaInicio)
	 * .append(", vigenciaFim=").append(vigenciaFim).append(", placaVeiculo=").
	 * append(placaVeiculo)
	 * .append(", valor=").append(valor).append(", emVigencia=").append(
	 * getEmVigencia()).append(", cpfCliente=") .append(cpfCliente).append("}");
	 * return builder.toString(); }
	 */

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Long getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(Long cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getEmVigencia() {
		Date hoje = new Date();
		return vigenciaInicio.compareTo(hoje) < 0 && hoje.compareTo(vigenciaFim) <= 0;
	}

	public void setEmVigencia(Boolean emVigencia) {
		this.emVigencia = emVigencia;
	}

	public int getDiasVigencia() {
		Date hoje = new Date();
		return hoje.compareTo(vigenciaFim);
	}

	public void setDiasVigencia(int diasVigencia) {
		this.diasVigencia = diasVigencia;
	}

}
