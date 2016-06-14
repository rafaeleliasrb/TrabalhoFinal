package questao3;

/**
 * @author RafaelElias
 * Classe para simular o funcionamento do IntegerSet. 
 */
public class Principal {

	public static void main(String[] args) {
		IntegerSet conjuntoTest = new ConjuntoIntegerArray();
		
		IntegerSet conjuntoBoolean = new ConjuntoArrayBoolean();
		
		System.out.println("Conjunto 1");
		conjuntoTest.add(1);
		conjuntoTest.imprimeIntegerSet();
		conjuntoTest.add(2);
		conjuntoTest.imprimeIntegerSet();
		conjuntoTest.add(3);
		conjuntoTest.imprimeIntegerSet();
		conjuntoTest.add(4);
		conjuntoTest.imprimeIntegerSet();
		conjuntoTest.remove(2);
		conjuntoTest.imprimeIntegerSet();
		
		System.out.println("Conjunto 2");
		conjuntoBoolean.add(4);
		conjuntoBoolean.imprimeIntegerSet();
		conjuntoBoolean.add(5);
		conjuntoBoolean.imprimeIntegerSet();
		conjuntoBoolean.add(6);
		conjuntoBoolean.imprimeIntegerSet();
		conjuntoBoolean.add(7);
		conjuntoBoolean.imprimeIntegerSet();
		conjuntoBoolean.remove(5);
		conjuntoBoolean.imprimeIntegerSet();
		
		System.out.println("(Conjunto 1)U(Conjunto 2)");
		conjuntoTest.union(conjuntoBoolean).imprimeIntegerSet();
		
		System.out.println("(Conjunto 1)n(Conjunto 2)");
		conjuntoTest.intersection(conjuntoBoolean).imprimeIntegerSet();
		
		System.out.println("(Conjunto 1)-(Conjunto 2)");
		conjuntoTest.diff(conjuntoBoolean).imprimeIntegerSet();
	}
}
