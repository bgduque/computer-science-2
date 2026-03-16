import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an inventory/cart of furniture (Concrete Elements)
        List<Furniture> cart = new ArrayList<>();
        cart.add(new Chair(12.5)); // 12.5 lbs/kg weight
        cart.add(new Table(4.0, 3.0)); // 4x3 area
        cart.add(new Sofa(15.0, 100.0)); // 15 volume/cubic ft, 100 miles distance

        // Instantiate the Concrete Visitor
        StandardShippingCostVisitor standardShippingCalculator = new StandardShippingCostVisitor();

        System.out.println("--- E-Commerce Delivery Calculator ---");
        
        // Use the Visitor pattern to apply the shipping algorithm to each item
        for (Furniture item : cart) {
            item.accept(standardShippingCalculator);
        }

        System.out.println("--------------------------------------");
        System.out.println("Total Cart Shipping Cost: $" + String.format("%.2f", standardShippingCalculator.getTotalCost()));
    }
}
