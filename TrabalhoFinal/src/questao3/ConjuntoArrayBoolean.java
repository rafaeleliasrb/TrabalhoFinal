package questao3;

public class ConjuntoArrayBoolean implements IntegerSet {

	private Integer sizeMax = 100;
	private Boolean[] set = new Boolean[sizeMax];
	//private Integer size = 0;
	
	@Override
	public void add(Integer n) {
		set[n] = true;
	}

	@Override
	public void remove(Integer n) {
		set[n] = false;
	}

	@Override
	public IntegerSet union(IntegerSet set) {
		IntegerSet unionSet = set.diff(this);
		for(int i=0; i<sizeMax; i++) {
			if(this.set[i]!=null && this.set[i]) {
				unionSet.add(i);
			}
		}
		
		return unionSet;
	}

	@Override
	public IntegerSet intersection(IntegerSet set) {
		IntegerSet intersectionSet = new ConjuntoArrayBoolean();
		for(int i=0; i<sizeMax; i++) {
			if(this.set[i]!=null && this.set[i] && set.isBelongToSet(i)) {
				intersectionSet.add(i);
			}
		}
		return intersectionSet;
	}

	@Override
	public IntegerSet diff(IntegerSet set) {
		IntegerSet intersectionSet = new ConjuntoArrayBoolean();
		for(int i=0; i<sizeMax; i++) {
			if(this.set[i]!=null && this.set[i] && !set.isBelongToSet(i)) {
				intersectionSet.add(i);
			}
		}
		return intersectionSet;
	}
	
	@Override
	public boolean isBelongToSet(Integer n) {
		boolean retorno = false;
		if(set[n]!=null) {
			retorno = set[n];
		}
		return retorno;
	}
	
	@Override
	public void imprimeIntegerSet() {
		System.out.printf("{ ");
		for(int i=0; i<sizeMax; i++) {
			if(set[i]!=null && set[i]) {
				System.out.printf(String.valueOf(i) + " ");
			}
		}
		System.out.printf("}");
		System.out.println();
	}
}
