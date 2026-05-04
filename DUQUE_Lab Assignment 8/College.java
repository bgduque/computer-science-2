public class College extends CompositeUnit {
    public College(String name) {
        super(name);
    }

    @Override
    public void displayDetails(int indentation) {
        System.out.println("  ".repeat(indentation) + "College: " + name);
        for (EducationalUnit child : children) {
            child.displayDetails(indentation + 1);
        }
    }
}