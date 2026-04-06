/// Default implementation that confirms order placement.
public class DefaultOrderPlacer implements OrderPlacer {

    @Override
    public void placeOrder(Order order) {
        System.out.println("Order placed for " + order.customerName() + " at " + order.address());
    }
}
