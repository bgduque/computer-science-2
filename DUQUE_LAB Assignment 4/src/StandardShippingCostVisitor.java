public class StandardShippingCostVisitor implements ShippingCostVisitor {
    private double totalCost = 0.0;

    @Override
    public void visit(Chair chair) {
        // Flat rate + slight weight factor 
        double cost = 10.0 + (chair.getWeight() * 0.5);
        System.out.println("Chair shipping cost: $" + String.format("%.2f", cost));
        totalCost += cost;
    }

    @Override
    public void visit(Table table) {
        // Flat rate + area factor
        double cost = 20.0 + (table.getArea() * 1.5);
        System.out.println("Table shipping cost: $" + String.format("%.2f", cost));
        totalCost += cost;
    }

    @Override
    public void visit(Sofa sofa) {
        // Bulky handling fee + distance-based cost
        double cost = 50.0 + (sofa.getVolume() * 5.0) + (sofa.getShippingDistanceMiles() * 1.2);
        System.out.println("Sofa shipping cost: $" + String.format("%.2f", cost));
        totalCost += cost;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
