package questao3;

import java.math.BigDecimal;

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
		for(int i=0; i<sizeMax; i++) {
			if(this.set[i]) {
				set.add(i);
			}
		}
		
		return set;
	}

	@Override
	public IntegerSet intersection(IntegerSet set) {
		IntegerSet intersectionSet = new IntegerSet();
		for(int i=0; i<sizeMax; i++) {
			if(this.set[i] && !set.isBelongToSet(i)) {
				this.set.remove(i);
			}
		}
		return this.set;
	}

	@Override
	public IntegerSet diff(IntegerSet set) {
		IntegerSet intersectionSet = new IntegerSet();
		for(int i=0; i<sizeMax; i++) {
			if(set.isBelongToSet(i)) {
				this.set.remove(i);
			}
		}
		return this.set;
	}
	
	@Override
	public boolean isBelongToSet(Integer n) {
		return set[n];
	}
	
	public void imprimeConjunto() {
		System.out.printf("{ ");
		for(int i=0; i<sizeMax; i++) {
			if(set[i]) {
				System.out.printf(String.toString(i) + " ");
			}
		}
		System.out.printf("}");
	}
}
