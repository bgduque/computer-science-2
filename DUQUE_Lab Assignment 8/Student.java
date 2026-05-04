public class Student implements EducationalUnit {
    private String name;
    private String studentId;
    private double tuitionFee;

    public Student(String name, String studentId, double tuitionFee) {
        this.name = name;
        this.studentId = studentId;
        this.tuitionFee = tuitionFee;
    }

    @Override
    public void displayDetails(int indentation) {
        System.out.println("  ".repeat(indentation) + "Student: " + name + 
                           " (ID: " + studentId + ") | Tuition: " + tuitionFee);
    }

    @Override
    public int getStudentCount() {
        return 1; // Represents one student
    }

    @Override
    public double getBudget() {
        return -tuitionFee; // Budget is the negative sum of tuition fees[cite: 1]
    }

    @Override
    public String getName() { return name; }
}