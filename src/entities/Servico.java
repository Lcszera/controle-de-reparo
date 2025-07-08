package entities;

	public class Servico {
	
		private Cliente cliente;
		private Aparelho aparelho;
		private String pecausada;
		private double ValorPeca;
		private double ValorObra;
		private int diasGarantia;
		private int dataAtual;
		
		
	public Servico(Cliente cliente, Aparelho aparelho, String pecausada, double ValorPeca, double ValorObra, int diasGarantia, int dataAtual) {
		
		this.cliente = cliente;
		this.aparelho = aparelho;
		this.pecausada = pecausada;
		this.ValorPeca = ValorPeca;
		this.ValorObra = ValorObra;
		this.diasGarantia = diasGarantia;
		this.dataAtual = dataAtual;
		
	}
		
}
