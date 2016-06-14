package questao2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author RafaelElias
 * ShoppingCart implementado com a classe Map.
 */
public class MapCart implements ShoppingCart {

	Map<Integer, Item> carrinho;
	
	public MapCart() {
		carrinho = new HashMap<Integer, Item>();
	}
	
	@Override
	public Item addItem(Product product, Integer amount) {
		if(carrinho.containsKey(product.getId())) {
			amount += carrinho.get(product.getId()).getAmount();
		}
		
		Item novoItem = new Item(product, amount);
		carrinho.put(product.getId(), novoItem);

		return novoItem;
	}

	@Override
	public Collection<Product> getProductsOrderByNameAsc() {
		List<Product> products = 
				carrinho.values().stream().
				map(Item::getProduct).
				collect(Collectors.toCollection(ArrayList::new));
		
		Collections.sort(products, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		return products;
	}

	@Override
	public Iterator<Item> getItems() {
		Iterator<Item> it = carrinho.values().iterator();
		return it;
	}

	@Override
	public void removeItemByProductId(Integer productId) {
		carrinho.remove(productId);
	}

	@Override
	public Double getTotal() {
		Double total = 0.0;
		for(Item item : carrinho.values()) {
			total += item.getProduct().getPrice()*item.getAmount();
		}
		return total;
	}

}
