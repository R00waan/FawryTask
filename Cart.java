
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Error : the required quantity is not available");
            return;
        }
        items.put(product, quantity);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

}


