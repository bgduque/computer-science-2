/// High-level order processing service.
///
/// Depends only on abstractions (interfaces), satisfying the
/// Dependency Inversion Principle.  Each collaborator handles
/// a single responsibility.
public class OrderService {

    private final OrderCalculator calculator;
    private final OrderPlacer placer;
    private final InvoiceGenerator invoiceGenerator;
    private final EmailNotifier emailNotifier;

    public OrderService(OrderCalculator calculator,
                        OrderPlacer placer,
                        InvoiceGenerator invoiceGenerator,
                        EmailNotifier emailNotifier) {
        this.calculator = calculator;
        this.placer = placer;
        this.invoiceGenerator = invoiceGenerator;
        this.emailNotifier = emailNotifier;
    }

    /// Runs the full order workflow: calculate, place, invoice, notify.
    public void processOrder(Order order, String invoiceFile, String email) {
        var total = calculator.calculateTotal(order);
        System.out.println("Order total: $" + total);
        placer.placeOrder(order);
        invoiceGenerator.generateInvoice(order, invoiceFile);
        emailNotifier.sendNotification(email, order);
    }
}
