public class Table implements Furniture {
    private double length;
    private double width;

    public Table(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    @Override
    public void accept(ShippingCostVisitor visitor) {
        visitor.visit(this);
    }
}
