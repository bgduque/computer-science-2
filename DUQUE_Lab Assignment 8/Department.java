public class Department extends CompositeUnit {
    public Department(String name) {
        super(name);
    }

    @Override
    public void displayDetails(int indentation) {
        System.out.println("  ".repeat(indentation) + "Department: " + name);
        for (EducationalUnit child : children) {
            child.displayDetails(indentation + 1);
        }
    }
}