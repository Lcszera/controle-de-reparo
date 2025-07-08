package pacote;

import java.util.Scanner;
import entities.Cliente;
import entities.Aparelho;
import entities.Servico;
import entities.Cliente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Eletronica {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
			System.out.println("Por favor, digite o nome do cliente: ");
				String nome = sc.next();
		
			System.out.println("Agora, digite o telefone do cliente: ");
				String telefone = sc.next();
		
			System.out.println("Digite o endereço do cliente: ");
				String endereco = sc.next();
				
			System.out.println("Digite o número da casa");
				
				
			System.out.println("Digite o CPF do cliente: ");
				int cpf = sc.nextInt();
				
				
					Cliente client = new Cliente(nome, telefone, endereco, cpf); // Aqui eu chamei o construtor do entities Cliente
				
		
			System.out.println("Digite o nome do aparelho: ");
				String nomeAparelho = sc.next();
				
			System.out.println("Digite o defeito do aparelho: ");
				String defeito = sc.next();
				
			System.out.println("Digite a data de entrada: ");
				String dataStr = sc.nextLine();
				
				LocalDate dataEntrada = LocalDate.parse(dataStr, formatter); // Converti de tipo String para tipo formatter
				
				
					Aparelho aparelho = new Aparelho(nomeAparelho, defeito, dataEntrada); // Aqui eu chamei o construtor do entities Aparelho
				
				
				
			sc.close();

	}

}
