package questao1;
import java.util.ArrayList;
import java.util.List;

public class Bingo {

	private static int NUMERO_DE_CARTELAS = Integer.MAX_VALUE;
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
	
	public Integer sortearNumero() {
		Integer numeroSorteado = globo.sorteiaNumero();
		numerosSorteados.add(numeroSorteado);
		
		for(Cartela cartela : cartelas) {
			cartela.marcarCartela(numeroSorteado);
		}
		
		return numeroSorteado;
	}
	
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
