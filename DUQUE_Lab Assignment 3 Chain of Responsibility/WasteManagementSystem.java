import java.util.ArrayList;
import java.util.List;

/**
 * Orchestrates the waste management process.
 * Initializes the chain of waste collectors and processes containers.
 */
public class WasteManagementSystem {

    private final WasteCollector chainHead;
    private final List<WasteContainer> containers;

    public WasteManagementSystem() {
        // Build the chain: Organic -> Recyclable -> Hazardous
        OrganicWasteCollector organicCollector       = new OrganicWasteCollector();
        RecyclableWasteCollector recyclableCollector  = new RecyclableWasteCollector();
        HazardousWasteCollector hazardousCollector    = new HazardousWasteCollector();

        organicCollector.setNext(recyclableCollector).setNext(hazardousCollector);

        this.chainHead  = organicCollector;
        this.containers = new ArrayList<>();

        System.out.println("=== Waste Management System Initialized ===");
        System.out.println("Chain: Organic -> Recyclable -> Hazardous\n");
    }

    /** Registers a container with the system. */
    public void addContainer(WasteContainer container) {
        containers.add(container);
        System.out.println("Registered: " + container);
    }

    /** Processes all containers that need disposal. */
    public void processAllContainers() {
        System.out.println("\n--- Starting Waste Collection Cycle ---\n");
        boolean anyProcessed = false;

        for (WasteContainer container : containers) {
            if (container.needsDisposal()) {
                anyProcessed = true;
                System.out.println(">> " + container + " needs disposal.");
                chainHead.handle(container);
            }
        }

        if (!anyProcessed) {
            System.out.println("  No containers require disposal at this time.\n");
        }

        System.out.println("--- Waste Collection Cycle Complete ---\n");
    }

    /** Processes a single container through the chain. */
    public boolean processSingleContainer(WasteContainer container) {
        if (container.needsDisposal()) {
            System.out.println(">> " + container + " needs disposal.");
            return chainHead.handle(container);
        } else {
            System.out.printf(">> Container %s is only %.0f%% full — disposal not required.%n%n",
                    container.getId(), container.getFillPercentage());
            return false;
        }
    }

    /** Prints the status of all registered containers. */
    public void printStatus() {
        System.out.println("\n=== Container Status Report ===");
        for (WasteContainer c : containers) {
            System.out.println("  " + c
                    + (c.needsDisposal() ? "  ** NEEDS DISPOSAL **" : ""));
        }
        System.out.println();
    }

    /** Returns the list of registered containers. */
    public List<WasteContainer> getContainers() {
        return containers;
    }
}
