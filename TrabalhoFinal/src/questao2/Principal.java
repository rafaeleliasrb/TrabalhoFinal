package questao2;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author RafaelElias
 * Classe para testar o funcionamento de um Carrinho de compras.
 */
public class Principal {

	public static void main(String[] args) {
		ShoppingCart carrinho1 = new ListCart();
		ShoppingCart carrinho2 = new SetCart();
		ShoppingCart carrinho3 = new MapCart(); 
		
		Product product1 = new Product(1, "Feijão", 10.00);
		Product product2 = new Product(2, "Arroz", 12.50);
		Product product3 = new Product(3, "Macarrão", 15.00);
		Product product4 = new Product(4, "Tomate", 17.50);
		
		adicionaItemCarrinho(product1, 4, carrinho1);
		adicionaItemCarrinho(product2, 3, carrinho1);
		adicionaItemCarrinho(product3, 2, carrinho1);
		adicionaItemCarrinho(product4, 1, carrinho1);
		
		adicionaItemCarrinho(product1, 4, carrinho2);
		adicionaItemCarrinho(product2, 3, carrinho2);
		adicionaItemCarrinho(product3, 2, carrinho2);
		adicionaItemCarrinho(product4, 1, carrinho2);
		
		adicionaItemCarrinho(product1, 4, carrinho3);
		adicionaItemCarrinho(product2, 3, carrinho3);
		adicionaItemCarrinho(product3, 2, carrinho3);
		adicionaItemCarrinho(product4, 1, carrinho3);
		
		System.out.println("Carrinho 1:");
		testeCarrinho(carrinho1, product3);
		
		System.out.println("Carrinho 2:");
		testeCarrinho(carrinho2, product3);
		
		System.out.println("Carrinho 3:");
		testeCarrinho(carrinho3, product3);
		
	}
	
	public static void adicionaItemCarrinho(
			Product product, Integer amount, ShoppingCart carrinho) {
		carrinho.addItem(product, amount);
	}
	
	public static void imprimeProducts(Collection<Product> products) {
		products.forEach(product -> System.out.printf(product.getName() + " "));
		System.out.println();
	}
	
	public static void imprimeItens(Iterator<Item> it) {
		System.out.println("Produto : Preço : Quantidade");
		while(it.hasNext()) {
			Item item = it.next();
			System.out.println(item.getProduct().getName() + " : " + item.getProduct().getPrice() + " : " + item.getAmount());
		}
		System.out.println();
	}
	
	public static void testeCarrinho(ShoppingCart carrinho, Product productRemove) {
		imprimeProducts(carrinho.getProductsOrderByNameAsc());
		System.out.println("Total: R$" + carrinho.getTotal());
		System.out.println("Itens:");
		imprimeItens(carrinho.getItems());
		carrinho.removeItemByProductId(productRemove.getId());
		System.out.println("Depois de remover o " + productRemove.getName() + " do carrinho...");
		imprimeProducts(carrinho.getProductsOrderByNameAsc());
		System.out.println("Total: R$" + carrinho.getTotal());
		System.out.println("Itens:");
		imprimeItens(carrinho.getItems());
	}
}
