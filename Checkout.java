
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Checkout {
    public static boolean checkoutfun(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error : The Cart is Empty");
            return false;
        }
        double subtotal = 0.0;
        List<Shippable> shippableProducts = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int quantity = entry.getValue();

            if (p.isExpirable() && p.isExpired()) {
                System.out.println(" Error : " + p.getName() + " is Expired");
                return false;
            }

            if (quantity > p.getQuantity()) {
                System.out.println(" Error : " + p.getName() + " out of stock ");
                return false;
            }
            subtotal += p.getPrice() * quantity;
            if (p.isShippable()) {
                shippableProducts.add(p);
            }
        }
            double shippingFees = 30;
            double total = subtotal + shippingFees;

            if (customer.getBalance() < total) {
                System.out.println("Error :Your balance is insufficient\n");
                return false;
            }

            customer.deduct(total);

            for (Map.Entry<Product, Integer> en : cart.getItems().entrySet()) {
                Product p = en.getKey();
                int quantity = en.getValue();
                p.updateQuantity(quantity);
            }

        System.out.println("Checkout receipt");
        for (Map.Entry<Product, Integer> e : cart.getItems().entrySet()) {
            Product p = e.getKey();
            int quantity = e.getValue();
            System.out.println(quantity + "x " + p.getName() + "   " + (p.getPrice() * quantity));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFees);
        System.out.println("Amount: " + total);
        System.out.println("Remaining balance: " + customer.getBalance());

        if (!shippableProducts.isEmpty()) {
            ShippingService.ship(shippableProducts);
        }

        return true;






    }
}
