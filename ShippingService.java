import java.util.List;
public class ShippingService {
    public static void ship(List<Shippable> shippa) {
        double totalWeight = 0.0;
        System.out.println("Shipment notice");
        for (Shippable s : shippa) {
            System.out.println(s.getName() + " -- " + s.getWeight() + "g");
            totalWeight += s.getWeight();
        }
        System.out.println("Total package weight : " + (totalWeight / 1000.0) + "kg");
    }
}
