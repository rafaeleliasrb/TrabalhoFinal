package questao3;

/** 
 * Representa um conjunto (elementos sem repeti��o) de n�meros inteiros entre 0 e 100. 
 */
public interface IntegerSet { 
	/**  
	 * this = {1, 2, 3} e n = 4 -> this = {1, 2, 3, 4}  
	 */ 
	public void add(Integer n); 
	
	/**  
	 * this = {1, 2, 3} e n = 2 -> this = {1, 3}  
	 */ 
	public void remove(Integer n);
	
	/**  
	 * this = {1, 2, 3} e set = {3, 4, 5}  
	 * @return {1, 2, 3, 4, 5}  
	 */ 
	public IntegerSet union(IntegerSet set); 

	/**  
	 * this = {1, 2, 3} e set = {3, 4, 5}  
	 * @return {3}  
	 */ 
	public IntegerSet intersection(IntegerSet set); 

	/**  
	 * this = {1, 2, 3} e set = {3, 4, 5}  
	 * @return {1, 2}  
	 */ 
	public IntegerSet diff(IntegerSet set);
	
	/**  
	 * this = {1, 2, 3} e n = 2  
	 * @return true 
	 */
	public boolean isBelongToSet(Integer n);
	
	/**
	 * Imprime os valores do IntegerSet
	 */
	public void imprimeIntegerSet();
}


