package questao1;
import java.util.Random;

/**
 * @author RafaelElias
 * Classe utilit�ria para gerar n�meros atrav�s da classe Random. 
 */
public class GeradorNumeroUtil {

	/**
	 * Gera um n�mero random para ser utilizado no Bingo.
	 * @return n�mero random.
	 */
	public static int geraNumeroRandom() {
		Random geraNumero = new Random();
		return geraNumero.nextInt(98)+1;
	}
}
