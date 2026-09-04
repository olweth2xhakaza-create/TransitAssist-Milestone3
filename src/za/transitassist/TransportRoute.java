package src.za.transitassist;

public class TransportRoute {

    // --- Fields ---
    private String routeNumber;
    private String origin;
    private String destination;
    private String intermediateStops;
    private String transportType;
    private String departureTime;
    private double estimatedTravelTime;
    private double fare;
    private boolean accessibility;
    private int safetyRating;
    private String operatingStatus;
    private String disruptionMessage;

    // --- Constructor ---
    public TransportRoute(String routeNumber, String origin, String destination,
                          String intermediateStops, String transportType,
                          String departureTime, double estimatedTravelTime,
                          double fare, boolean accessibility, int safetyRating,
                          String operatingStatus, String disruptionMessage) {
        this.routeNumber = routeNumber;
        this.origin = origin;
        this.destination = destination;
        this.intermediateStops = intermediateStops;
        this.transportType = transportType;
        this.departureTime = departureTime;
        this.estimatedTravelTime = estimatedTravelTime;
        this.fare = fare;
        this.accessibility = accessibility;
        this.safetyRating = safetyRating;
        this.operatingStatus = operatingStatus;
        this.disruptionMessage = disruptionMessage;
    }

    // --- Getters ---
    public String getRouteNumber() { return routeNumber; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getIntermediateStops() { return intermediateStops; }
    public String getTransportType() { return transportType; }
    public String getDepartureTime() { return departureTime; }
    public double getEstimatedTravelTime() { return estimatedTravelTime; }
    public double getFare() { return fare; }
    public boolean isAccessibility() { return accessibility; }
    public int getSafetyRating() { return safetyRating; }
    public String getOperatingStatus() { return operatingStatus; }
    public String getDisruptionMessage() { return disruptionMessage; }

    // --- Setters ---
    public void setRouteNumber(String routeNumber) { this.routeNumber = routeNumber; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setIntermediateStops(String intermediateStops) { this.intermediateStops = intermediateStops; }
    public void setTransportType(String transportType) { this.transportType = transportType; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public void setEstimatedTravelTime(double estimatedTravelTime) { this.estimatedTravelTime = estimatedTravelTime; }
    public void setFare(double fare) { this.fare = fare; }
    public void setAccessibility(boolean accessibility) { this.accessibility = accessibility; }
    public void setSafetyRating(int safetyRating) { this.safetyRating = safetyRating; }
    public void setOperatingStatus(String operatingStatus) { this.operatingStatus = operatingStatus; }
    public void setDisruptionMessage(String disruptionMessage) { this.disruptionMessage = disruptionMessage; }

    // --- Display method ---
    public void displayRoute() {
        System.out.println("========================================");
        System.out.println("Route Number   : " + routeNumber);
        System.out.println("Origin         : " + origin);
        System.out.println("Destination    : " + destination);
        System.out.println("Stops          : " + intermediateStops);
        System.out.println("Transport Type : " + transportType);
        System.out.println("Departure Time : " + departureTime);
        System.out.println("Travel Time    : " + estimatedTravelTime + " min");
        System.out.println("Fare           : R" + fare);
        System.out.println("Accessible     : " + (accessibility ? "Yes" : "No"));
        System.out.println("Safety Rating  : " + safetyRating + "/5");
        System.out.println("Status         : " + operatingStatus);
        if (disruptionMessage != null && !disruptionMessage.isEmpty()) {
            System.out.println("Disruption     : " + disruptionMessage);
        }
        System.out.println("========================================");
    }
}