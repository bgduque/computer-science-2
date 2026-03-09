public abstract class WasteCollector {

    private WasteCollector nextCollector;

    /**
     * Sets the next handler in the chain.
     * @param next the next WasteCollector
     * @return the next collector (for fluent chaining)
     */
    public WasteCollector setNext(WasteCollector next) {
        this.nextCollector = next;
        return next;
    }

    /**
     * Attempts to handle the container. If this collector is not responsible
     * for the container's waste type, it delegates to the next handler.
     * @param container the waste container to process
     * @return true if the container was handled, false otherwise
     */
    public boolean handle(WasteContainer container) {
        if (canHandle(container)) {
            collect(container);
            return true;
        } else if (nextCollector != null) {
            return nextCollector.handle(container);
        } else {
            System.out.println("  [WARNING] No collector available for " + container);
            return false;
        }
    }

    /**
     * Determines whether this collector can handle the given container.
     * @param container the container to check
     * @return true if this handler is responsible
     */
    protected abstract boolean canHandle(WasteContainer container);

    /**
     * Performs the actual collection and disposal logic.
     * @param container the container to collect
     */
    protected abstract void collect(WasteContainer container);
}
