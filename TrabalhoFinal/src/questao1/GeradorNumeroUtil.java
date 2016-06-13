package questao1;
import java.util.Random;

public class GeradorNumeroUtil {

	public static int geraNumeroRandom() {
		Random geraNumero = new Random();
		return geraNumero.nextInt(98)+1;
	}
}
