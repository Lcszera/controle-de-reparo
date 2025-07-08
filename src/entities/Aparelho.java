package entities;

import java.time.LocalDate;

	public class Aparelho {
	
		private String nomeAparelho;
		private String defeito;
		private LocalDate dataEntrada;
		
		
	public Aparelho(String nomeAparelho, String defeito, LocalDate dataEntrada) {
			
		this.nomeAparelho = nomeAparelho;
		this.defeito = defeito;
		this.dataEntrada = dataEntrada;
			
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}		
}

	
