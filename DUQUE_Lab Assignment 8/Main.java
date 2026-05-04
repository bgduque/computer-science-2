public class Main {
    public static void main(String[] args) {
        // Create individual entities
        Teacher profEsperanza = new Teacher("Jeremias Esperanza", "Software Engineering", 60000.0);
        Student boris = new Student("Boris Gamaliel D. Duque", "2024-12345", 30000.0);
        Student peer = new Student("Jane Doe", "2024-54321", 28000.0);

        // Build Department
        Department csDept = new Department("Department of Computer Science");
        csDept.add(profEsperanza);
        csDept.add(boris);

        // Build College
        College cics = new College("College of Informatics and Computing Studies");
        cics.add(csDept);
        cics.add(peer);

        // Top-level University structure
        College neu = new College("New Era University");
        neu.add(cics);

        // Output results
        System.out.println("--- University Hierarchy Details ---");
        neu.displayDetails(0);

        System.out.println("\n--- Summary for " + cics.getName() + " ---");
        System.out.println("Total Students: " + cics.getStudentCount());
        System.out.printf("Total Budget: PHP %.2f%n", cics.getBudget());
    }
}