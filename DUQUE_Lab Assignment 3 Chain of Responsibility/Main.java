import java.util.Scanner;

/**
 * CLI entry point for the Automated Waste Management System.
 * Provides an interactive menu as well as a built-in demo mode.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   AUTOMATED WASTE MANAGEMENT SYSTEM         ║");
        System.out.println("║   Chain of Responsibility Pattern            ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        WasteManagementSystem system = new WasteManagementSystem();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addContainerMenu(system);
                    break;
                case "2":
                    fillContainerMenu(system);
                    break;
                case "3":
                    system.printStatus();
                    break;
                case "4":
                    system.processAllContainers();
                    break;
                case "5":
                    runDemo(system);
                    break;
                case "0":
                    running = false;
                    System.out.println("Shutting down Waste Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("──── MAIN MENU ────────────────────────────────");
        System.out.println("  1) Add a new waste container");
        System.out.println("  2) Fill an existing container");
        System.out.println("  3) View all container statuses");
        System.out.println("  4) Run waste collection cycle");
        System.out.println("  5) Run automated demo");
        System.out.println("  0) Exit");
        System.out.print("Choose an option: ");
    }

    private static void addContainerMenu(WasteManagementSystem system) {
        System.out.print("Enter container ID: ");
        String id = scanner.nextLine().trim();

        System.out.print("Enter waste type (Organic / Recyclable / Hazardous): ");
        String typeStr = scanner.nextLine().trim();

        WasteType type;
        try {
            type = WasteType.fromString(typeStr);
        } catch (IllegalArgumentException e) {
            System.out.println("  ERROR: " + e.getMessage() + "\n");
            return;
        }

        System.out.print("Enter capacity (kg): ");
        double capacity;
        try {
            capacity = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  ERROR: Capacity must be a number.\n");
            return;
        }

        WasteContainer container = new WasteContainer(id, type, capacity);
        system.addContainer(container);
        System.out.println();
    }

    private static void fillContainerMenu(WasteManagementSystem system) {
        if (system.getContainers().isEmpty()) {
            System.out.println("  No containers registered yet.\n");
            return;
        }

        System.out.println("  Registered containers:");
        for (int i = 0; i < system.getContainers().size(); i++) {
            System.out.printf("    %d) %s%n", i + 1, system.getContainers().get(i));
        }

        System.out.print("Select container number: ");
        int index;
        try {
            index = Integer.parseInt(scanner.nextLine().trim()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("  ERROR: Enter a valid number.\n");
            return;
        }

        if (index < 0 || index >= system.getContainers().size()) {
            System.out.println("  ERROR: Invalid container number.\n");
            return;
        }

        System.out.print("Enter amount of waste to add (kg): ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  ERROR: Amount must be a number.\n");
            return;
        }

        WasteContainer container = system.getContainers().get(index);
        container.addWaste(amount);
        System.out.println("  Updated: " + container + "\n");
    }


    private static void runDemo(WasteManagementSystem system) {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║             RUNNING AUTOMATED DEMO           ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        WasteContainer organic1    = new WasteContainer("ORG-001", WasteType.ORGANIC, 100);
        WasteContainer recyclable1 = new WasteContainer("REC-001", WasteType.RECYCLABLE, 150);
        WasteContainer hazardous1  = new WasteContainer("HAZ-001", WasteType.HAZARDOUS, 50);
        WasteContainer organic2    = new WasteContainer("ORG-002", WasteType.ORGANIC, 200);
        WasteContainer recyclable2 = new WasteContainer("REC-002", WasteType.RECYCLABLE, 120);

        system.addContainer(organic1);
        system.addContainer(recyclable1);
        system.addContainer(hazardous1);
        system.addContainer(organic2);
        system.addContainer(recyclable2);

        System.out.println("\n--- Simulating waste accumulation ---\n");

        organic1.addWaste(95);      // 95% full  -> needs disposal
        recyclable1.addWaste(140);  // 93% full  -> needs disposal
        hazardous1.addWaste(50);    // 100% full -> needs disposal
        organic2.addWaste(100);     // 50% full  -> does NOT need disposal
        recyclable2.addWaste(60);   // 50% full  -> does NOT need disposal
         
        system.printStatus();

        system.processAllContainers();

        system.printStatus();

        System.out.println("══════════════ DEMO COMPLETE ══════════════\n");
    }
}
