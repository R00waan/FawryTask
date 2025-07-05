public class Main {
    public static void main(String[] args) {

        Product cheese = new Product("Cheese", 100, 5, true, false, true, 200);
        Product tv = new Product("TV", 5000, 2, false, false, true, 7000);
        Product biscuit = new Product("Biscuit", 50, 10, true, false, false, 0);
        Product card = new Product("Scratch Card", 20, 10, false, false, false, 0);

        Customer customer = new Customer("Ahmed", 6000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(tv, 1);
        cart.add(biscuit, 1);

        boolean result = Checkout.checkoutfun(customer, cart);

        if (result) {
            System.out.println("Your purchase was completed successfully\n");
        } else {
            System.out.println("Your purchase was not completed\n");
        }









    }
}