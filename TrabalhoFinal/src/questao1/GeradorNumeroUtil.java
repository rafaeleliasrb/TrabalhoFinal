package questao1;
import java.util.Random;

/**
 * @author RafaelElias
 * Classe utilitária para gerar números através da classe Random. 
 */
public class GeradorNumeroUtil {

	/**
	 * Gera um número random para ser utilizado no Bingo.
	 * @return número random.
	 */
	public static int geraNumeroRandom() {
		Random geraNumero = new Random();
		return geraNumero.nextInt(98)+1;
	}
}
