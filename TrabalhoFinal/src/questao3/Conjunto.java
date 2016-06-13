package questao3;

import java.math.BigDecimal;

public class Conjunto implements IntegerSet {

	private Integer sizeMax = 2;
	private Integer[] set = new Integer[sizeMax];
	private Integer size = 0;
	
	@Override
	public void add(Integer n) {
		if(size==0 || binarySearch(set, size-1, n) == -1) {
			if(size == sizeMax) {
				set = alteraTamanhoSet(set, sizeMax*2);
				sizeMax *= 2;
			}
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
				if(size == sizeMax/2) {
					set = alteraTamanhoSet(set, sizeMax/2);
					sizeMax /= 2; 
				}
			}
		}	
	}

	@Override
	public IntegerSet union(IntegerSet set) {
		for(int i=0; i<size; i++) {
			set.add(this.set[i]);
		}
		
		return set;
	}

	@Override
	public IntegerSet intersection(IntegerSet set) {
		IntegerSet intersectionSet = new IntegerSet();
		for(int i=0; i<size; i++) {
			if(set.isBelongToSet(this.set[i])) {
				intersectionSet.add(set[i]);
			}
		}
		return intersectionSet;
	}

	@Override
	public IntegerSet diff(IntegerSet set) {
		IntegerSet intersectionSet = new IntegerSet();
		for(int i=0; i<size; i++) {
			if(!set.isBelongToSet(this.set[i])) {
				intersectionSet.add(set[i]);
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

	private Integer[] alteraTamanhoSet(Integer[] set, Integer novoTamanho) {
		Integer[] setAux = set;
		set = new Integer[novoTamanho];
		for(int i=0; i<size; i++) {
			set[i] = setAux[i];
		}
		
		return set;
	}
	
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
	
	public void imprimeConjunto() {
		System.out.printf("{ ");
		for(int i=0; i<size; i++) {
			System.out.printf(set[i].toString() + " ");
		}
		System.out.printf("}");
	}
}
