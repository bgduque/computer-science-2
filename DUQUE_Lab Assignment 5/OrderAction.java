/// Entry point demonstrating the SOLID-refactored order system.
///
/// Uses Java 25 instance main (JEP 495) — no explicit class wrapper needed.
void main() {
    var order      = new Order("John Doe", "123 Main St", 10.0, 2);
    var calculator = new DefaultOrderCalculator();
    var placer     = new DefaultOrderPlacer();
    var invoiceGen = new DefaultInvoiceGenerator();
    var notifier   = new DefaultEmailNotifier();

    var service = new OrderService(calculator, placer, invoiceGen, notifier);
    service.processOrder(order, "order_123.pdf", "johndoe@example.com");
}
