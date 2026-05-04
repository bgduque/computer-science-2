import java.util.ArrayList;
import java.util.List;

public abstract class CompositeUnit implements EducationalUnit {
    protected String name;
    protected List<EducationalUnit> children = new ArrayList<>();

    public CompositeUnit(String name) {
        this.name = name;
    }

    public void add(EducationalUnit unit) {
        children.add(unit);
    }

    public void remove(EducationalUnit unit) {
        children.remove(unit);
    }

    @Override
    public int getStudentCount() {
        // Recursively sums student counts from all children[cite: 1]
        return children.stream().mapToInt(EducationalUnit::getStudentCount).sum();
    }

    @Override
    public double getBudget() {
        // Sum of budgets of departments, teachers, and negative tuition[cite: 1]
        return children.stream().mapToDouble(EducationalUnit::getBudget).sum();
    }

    @Override
    public String getName() { return name; }
}