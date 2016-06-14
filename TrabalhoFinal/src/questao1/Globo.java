package questao1;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RafaelElias
 * Simula o Globo do Bingo.
 */
public class Globo {

	private List<Integer> bolas;
	
	public Globo() {
		bolas = new ArrayList<>();
		for(int i=1; i<100; i++){
			bolas.add(i);
		}
	}
	
	/**
	 * Sorteia um n�mero ainda n�o sorteado.
	 * @return n�mero sorteado
	 */
	public Integer sorteiaNumero() {
		Integer numeroSorteado = GeradorNumeroUtil.geraNumeroRandom();
		while(verificaBolaJaSorteada(numeroSorteado)) {
			numeroSorteado = GeradorNumeroUtil.geraNumeroRandom();
		}
		bolas.remove(numeroSorteado);
		return numeroSorteado;
	}
	
	/**
	 * Verifica de o @param j� foi sorteado.
	 * @param bolaSorteada
	 * @return se j� foi sorteado
	 */
	private Boolean verificaBolaJaSorteada(Integer bolaSorteada) {
		Boolean retorno;
		if(bolas.contains(bolaSorteada)) {
			retorno = false;
		}
		else {
			retorno = true;
		}
		
		return retorno;
	}
}
