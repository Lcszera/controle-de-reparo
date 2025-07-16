package entities;

import java.time.LocalDate;


public class Servico {


	private Cliente cliente;
	private Aparelho aparelho;
	private String pecaUsada;
	private double valorPeca;
	private double valorObra;
	private int diasGarantia;
	private LocalDate dataEntrada;
	private LocalDate dataFinalizacao;
	private String status;
	private double valorTotalCobrado;
	private int id;

	public Servico() {

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}

	public String getPecaUsada() {
		return pecaUsada;
	}

	public void setPecaUsada(String pecaUsada) {
		this.pecaUsada = pecaUsada;
	}

	public double getValorPeca() {
		return valorPeca;
	}

	public void setValorPeca(double valorPeca) {
		this.valorPeca = valorPeca;
	}

	public double getValorObra() {
		return valorObra;
	}

	public void setValorObra(double valorObra) {
		this.valorObra = valorObra;
	}

	public int getDiasGarantia() {
		return diasGarantia;
	}

	public void setDiasGarantia(int diasGarantia) {
		this.diasGarantia = diasGarantia;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDate dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public String getStatus() {
		return status;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public Servico(Cliente cliente, Aparelho aparelho, String pecaUsada, double valorPeca, double valorObra, int diasGarantia, LocalDate dataEntrada, LocalDate dataFinalizacao, String status, double valorTotalCobrado) {
		this.cliente = cliente;
		this.aparelho = aparelho;
		this.pecaUsada = pecaUsada;
		this.valorPeca = valorPeca;
		this.valorObra = valorObra;
		this.diasGarantia = diasGarantia;
		this.dataEntrada = dataEntrada;
		this.dataFinalizacao = dataFinalizacao;
		this.status = status;
		this.valorTotalCobrado = valorTotalCobrado;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getValorTotalCobrado() {
		return valorTotalCobrado;
	}

	public void setValorTotalCobrado(double valorTotalCobrado) {
		this.valorTotalCobrado = valorTotalCobrado;
	}
}