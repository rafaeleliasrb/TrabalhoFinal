package questao2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author RafaelElias
 * ShoppingCart implementado com a classe Set.
 */
public class SetCart implements ShoppingCart {

	Set<Item> carrinho;
	
	public SetCart() {
		carrinho = new HashSet<>();
	}
	
	@Override
	public Item addItem(Product product, Integer amount) {
		if(getProductsCarrinho().contains(product)) {
			amount += getAmountByProduct(product);
		}
		
		Item novoItem = new Item(product, amount);
		carrinho.add(novoItem);

		return novoItem;
	}

	@Override
	public Collection<Product> getProductsOrderByNameAsc() {
		List<Product> products = getProductsCarrinho();
		
		Collections.sort(products, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		return products;
	}


	@Override
	public Iterator<Item> getItems() {
		Iterator<Item> it = carrinho.iterator();
		return it;
	}

	@Override
	public void removeItemByProductId(Integer productId) {
		for(Item item : carrinho) {
			if(item.getProduct().getId().equals(productId)) {
				carrinho.remove(item);
			}
		}
	}

	@Override
	public Double getTotal() {
		Double total = 0.0;
		for(Item item : carrinho) {
			total += item.getProduct().getPrice()*item.getAmount();
		}
		return total;
	}

	private List<Product> getProductsCarrinho() {
		return carrinho.stream().
				map(Item::getProduct).
				collect(Collectors.toCollection(ArrayList::new));
	}
	
	private Integer getAmountByProduct(Product product) {
		for(Iterator<Item> it = getItems(); it.hasNext();) {
			Item item = it.next(); 
			if(item.getProduct().equals(product)) {
				return item.getAmount();
			}
		}
		
		return 0;
	}
}
