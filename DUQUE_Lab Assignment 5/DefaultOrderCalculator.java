/// Default calculator that computes total as price times quantity.
public class DefaultOrderCalculator implements OrderCalculator {

    @Override
    public double calculateTotal(Order order) {
        return order.price() * order.quantity();
    }
}
