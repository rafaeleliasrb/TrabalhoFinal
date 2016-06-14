package questao1;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RafaelElias
 * Classe que simula uma cartela de um Bingo.
 */
public class Cartela {

	private static int MAX_ID = 1;
	private Integer id;
	private Set<Integer> numeros;
	private Integer qtdNumeroParaGanhar;
	
	public Cartela() {
		id = MAX_ID++;
		numeros = new HashSet<>();
		gerarNumerosCartela();
		qtdNumeroParaGanhar = 20;
	}
	
	/**
	 * Gera os números da Cartela.
	 */
	private void gerarNumerosCartela() {
		while(numeros.size() < 20) {
			numeros.add(GeradorNumeroUtil.geraNumeroRandom());
		}
	}
	
	/**
	 * Marca a cartela com o @param
	 * @param numeroSorteado
	 */
	public void marcarCartela(int numeroSorteado) {
		if(numeros.contains(numeroSorteado)) {
			qtdNumeroParaGanhar--;
		}
	}
	
	/**
	 * Verifica se todos os números da Cartela foram sorteados.
	 * @return se venceu
	 */
	public Boolean cartelaVencedora() {
		Boolean retorno;
		if(qtdNumeroParaGanhar == 0) {
			retorno = true;
		}
		else {
			retorno = false;
		}
		
		return retorno;
	}
	
	public Integer getId() {
		return id;
	}

	public Set<Integer> getNumeros() {
		return numeros;
	}
}
