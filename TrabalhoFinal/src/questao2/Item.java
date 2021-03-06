package questao2;

/**
 * @author RafaelElias
 * Classe que simula um Item de um Carrinho de compras.
 */
public class Item {

	private Product product;
	private Integer amount;
	
	public Item(Product product, Integer amount) {
		super();
		this.product = product;
		this.amount = amount;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
