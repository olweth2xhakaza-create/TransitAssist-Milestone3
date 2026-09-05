package src.za.transitassist;

public class TaxiRoute extends TransportRoute{

	 // --- Taxi-specific Fields ---
    private String taxiRank;
    private boolean metered;

    // --- Constructor ---
    public TaxiRoute(String routeNumber, String origin, String destination,
                     String intermediateStops, String departureTime,
                     double estimatedTravelTime, double fare,
                     boolean accessibility, int safetyRating,
                     String operatingStatus, String disruptionMessage,
                     String taxiRank, boolean metered) {

        // Call the TransportRoute superclass constructor
        super(routeNumber, origin, destination, intermediateStops,
              "Taxi", departureTime, estimatedTravelTime, fare,
              accessibility, safetyRating, operatingStatus,
              disruptionMessage);

        // Initialise taxi-specific fields
        this.taxiRank = taxiRank;
        this.metered = metered;
    }

    // --- Getters ---

    public String getTaxiRank() {
        return taxiRank;
    }

    public boolean isMetered() {
        return metered;
    }

    // --- Setters ---

    public void setTaxiRank(String taxiRank) {
        this.taxiRank = taxiRank;
    }

    public void setMetered(boolean metered) {
        this.metered = metered;
    }

    // --- Display Taxi Route ---
    public void displayRoute() {

        // Display all common route information
        displayRoute();

        // Display taxi-specific information
        System.out.println("Taxi Rank : " + taxiRank);
        System.out.println("Metered : " + (metered ? "Yes" : "No"));

        System.out.println("========================================");
    }
}