public class Teacher implements EducationalUnit {
    private String name;
    private String subject;
    private double salary;

    public Teacher(String name, String subject, double salary) {
        this.name = name;
        this.subject = subject;
        this.salary = salary;
    }

    @Override
    public void displayDetails(int indentation) {
        System.out.println("  ".repeat(indentation) + "Teacher: " + name + 
                           " | Subject: " + subject + " | Salary: " + salary);
    }

    @Override
    public int getStudentCount() {
        return 0; // Teachers do not count as students
    }

    @Override
    public double getBudget() {
        return salary; // Budget is the teacher's salary
    }

    @Override
    public String getName() { return name; }
}