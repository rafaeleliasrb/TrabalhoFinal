package questao1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		Bingo bingo = new Bingo();
		
		boolean vencedor = false;

		System.out.println("***************");
		System.out.println("**** BINGO ****");
		System.out.println("***************");
		
		System.out.println("Cartelas:");
		imprimeCartelas(bingo.getCartelas());
		
		List<Cartela> cartelaVencedoras = new ArrayList<>();
		while(!vencedor) {
			System.out.println("N�mero chamado: " + bingo.sortearNumero());
			cartelaVencedoras = bingo.cartelasVencedoras();
			if(!cartelaVencedoras.isEmpty()) {
				vencedor = true;
			}
		}
		
		System.out.println("Quantidade de n�mero chamados: " + bingo.getNumerosSorteados().size());
		System.out.println("N�meros sorteados:");
		imprimeNumeros(bingo.getNumerosSorteados());
		System.out.println();
		
		System.out.println("Cartela(s) vencedora(s):");
		imprimeCartelas(cartelaVencedoras);
		
	}
	
	public static void imprimeCartelas(List<Cartela> cartelas) {
		
		for(Cartela cartela : cartelas) {
			System.out.println("Cartela: " + cartela.getId());
			
			List<Integer> numeros = new ArrayList<Integer>(cartela.getNumeros());
			imprimeNumeros(numeros);
			System.out.println();
		}
	}
	
	public static void imprimeNumeros(List<Integer> numeros) {
		Collections.sort(numeros, (o1, o2) -> o1 - o2);
		for(Integer numero : numeros) {
			System.out.printf(numero + " ");
		}
	}
}