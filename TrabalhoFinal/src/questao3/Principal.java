package questao3;

public class Principal {

	public static void main(String[] args) {
		Conjunto conjuntoTest = new Conjunto();
		
		conjuntoTest.add(1);
		conjuntoTest.imprimeConjunto();
		conjuntoTest.add(2);
		conjuntoTest.imprimeConjunto();
		conjuntoTest.add(3);
		conjuntoTest.imprimeConjunto();
		
		conjuntoTest.remove(2);
		
		conjuntoTest.imprimeConjunto();
	}
}
