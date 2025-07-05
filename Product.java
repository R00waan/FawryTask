public class Product implements Shippable {
    private String name;
    private double price;
    private int quantity;

    private boolean expirable;
    private boolean expired;

    private boolean shippable;
    private float weight;

    public Product(String name, double price, int quantity,
                   boolean expirable, boolean expired,
                   boolean shippable, float weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirable = expirable;
        this.expired = expired;
        this.shippable = shippable;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void updateQuantity(int amt){
        this.quantity-=amt;
    }

    public boolean isExpirable() { return expirable; }
    public boolean isExpired() { return expired; }
    public boolean isShippable() { return shippable; }

    @Override
    public float getWeight() { return weight; }
}
