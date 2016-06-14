package questao1;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RafaelElias
 * Classe que simula um Bingo.
 */
public class Bingo {

	//Número máximo de cartelas é o resultado da combinação 99 escolhe 20
	private static int NUMERO_DE_CARTELAS = 100;
	private Globo globo;
	private List<Cartela> cartelas;
	private List<Integer> numerosSorteados;
	
	public Bingo() {
		globo = new Globo();
		cartelas = new ArrayList<>();
		numerosSorteados = new ArrayList<>();
		for(int i=0; i<NUMERO_DE_CARTELAS; i++) {
			cartelas.add(new Cartela());
		}
	}
	
	/**
	 * Sorteia um número e marca nas cartelas do Bingo
	 * @return número sorteado
	 */
	public Integer sortearNumero() {
		Integer numeroSorteado = globo.sorteiaNumero();
		numerosSorteados.add(numeroSorteado);
		
		for(Cartela cartela : cartelas) {
			cartela.marcarCartela(numeroSorteado);
		}
		
		return numeroSorteado;
	}
	
	/**
	 * Lista as Cartelas que venceram o Bingo.
	 * @return lista de Cartelas
	 */
	public List<Cartela> cartelasVencedoras() {
		List<Cartela> cartelasVencedoras = new ArrayList<>();
		for(Cartela cartela : cartelas) {
			if(cartela.cartelaVencedora()) {
				cartelasVencedoras.add(cartela);
			}
		}
		
		return cartelasVencedoras;
	}

	public Globo getGlobo() {
		return globo;
	}

	public List<Cartela> getCartelas() {
		return cartelas;
	}

	public List<Integer> getNumerosSorteados() {
		return numerosSorteados;
	}
}
