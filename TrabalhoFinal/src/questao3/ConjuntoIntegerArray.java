package questao3;

/**
 * @author RafaelElias
 * IntegerSet utilizando um array de inteiros.
 */
public class ConjuntoIntegerArray implements IntegerSet {

	private Integer sizeMax = 101;
	private Integer[] set = new Integer[sizeMax];
	private Integer size = 0;
	
	@Override
	public void add(Integer n) {
		if(size==0 || binarySearch(set, size-1, n) == -1) {
			set[size++] = n;
		}
		quickSort(set, 0, size-1);
	}

	@Override
	public void remove(Integer n) {
		if(size>0) {
			quickSort(set, 0, size-1);
			int posicao = binarySearch(set, size-1, n);
			
			if(posicao > -1) {
				for(int i=posicao; i<size;i++) {
					set[i] = set[i+1];
				}
				
				size--;
			}
		}	
	}

	@Override
	public IntegerSet union(IntegerSet set) {
		IntegerSet unionSet = set.diff(this);
		for(int i=0; i<size; i++) {
			unionSet.add(this.set[i]);
		}
		
		return unionSet;
	}

	@Override
	public IntegerSet intersection(IntegerSet set) {
		IntegerSet intersectionSet = new ConjuntoIntegerArray();
		for(int i=0; i<size; i++) {
			if(set.isBelongToSet(this.set[i])) {
				intersectionSet.add(this.set[i]);
			}
		}
		return intersectionSet;
	}

	@Override
	public IntegerSet diff(IntegerSet set) {
		IntegerSet intersectionSet = new ConjuntoIntegerArray();
		for(int i=0; i<size; i++) {
			if(!set.isBelongToSet(this.set[i])) {
				intersectionSet.add(this.set[i]);
			}
		}
		return intersectionSet;
	}
	
	@Override
	public boolean isBelongToSet(Integer n) {
		boolean retorno = false;
		if(binarySearch(set, size-1, n) > -1) {
			retorno = true;
		}
		
		return retorno;
	}
	
	@Override
	public void imprimeIntegerSet() {
		System.out.printf("{ ");
		for(int i=0; i<size; i++) {
			System.out.printf(set[i].toString() + " ");
		}
		System.out.printf("}");
		System.out.println();
	}
	
	/**
	 * Método de ordenação usando o algoritmo quickSort.
	 * @param array
	 * @param inicio
	 * @param fim
	 */
	private void quickSort(Integer[] array, int inicio, int fim) {
        int i = inicio;
        int j = fim;
        
        int pivot = set[inicio+(fim-inicio)/2];//pivot no meio
        
        while (i <= j) {
            while (set[i] < pivot) {
                i++;
            }
            while (set[j] > pivot) {
                j--;
            }
            if (i <= j) {
            	int aux = set[i];
                set[i] = set[j];
                set[j] = aux;

                i++;
                j--;
            }
        }
        if (inicio < j)
            quickSort(array, inicio, j);
        if (i < fim)
            quickSort(array, i, fim);
    }

	/**
	 * Método de busca usando o algoritimo de buscaBinaria.
	 * @param array
	 * @param size
	 * @param valor
	 * @return o valor encontrado ou -1, caso não tenha sido encontrado
	 */
	private int binarySearch(Integer[] array, int size, int valor) {
		int inicio = 0;
		int fim = size;

		while(inicio <= fim) {
			int meio = (inicio+fim)/2;

			if(array[meio] == valor) {
				return meio;
			}

			if(valor > array[meio]) {
				inicio = meio+1;
			} 
			else {
				fim = meio-1;
			}
		}
		return -1;
	}
	
}
