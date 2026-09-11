package src.za.transitassist; // FIXED: Removed 'src.'

public class TrainRoute extends TransportRoute {

    // --- Train-specific fields ---
    private String trainClass;
    private int numberOfCarriages;

    // --- Constructor ---
    public TrainRoute(String routeNumber, String origin, String destination, String intermediateStops,
                      String departureTime, double estimatedTravelTime, double fare, boolean accessibility,
                      int safetyRating, String operatingStatus, String disruptionMessage,
                      String trainClass, int numberOfCarriages) {
        
        // Call the TransportRoute superclass constructor
        super(routeNumber, origin, destination, intermediateStops, "Train", departureTime,
              estimatedTravelTime, fare, accessibility, safetyRating, operatingStatus, disruptionMessage);
        
        // Initialize train-specific fields
        this.trainClass = trainClass;
        this.numberOfCarriages = numberOfCarriages;
    }

    // --- Getters ---
    public String getTrainClass() { return trainClass; }
    public int getNumberOfCarriages() { return numberOfCarriages; }

    // --- Setters ---
    public void setTrainClass(String trainClass) { this.trainClass = trainClass; }
    public void setNumberOfCarriages(int numberOfCarriages) { this.numberOfCarriages = numberOfCarriages; }

    // --- Display Train Route ---
    @Override
    public void displayRoute() {
        // Display common route information first
        super.displayRoute();
        // Display train-specific information
        System.out.println("Train Class    : " + trainClass);
        System.out.println("Carriages      : " + numberOfCarriages);
        System.out.println("========================================");
    }
}