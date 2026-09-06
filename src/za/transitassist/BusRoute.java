package src.za.transitassist;

public class BusRoute extends TransportRoute {
	private int seatingCapacity;
	private boolean hasWifi;
	
	
	public BusRoute(String routeNumber, String origin, String destination, String intermediateStops, String departureTime, double estimatedTravelTime, double fare, boolean accessibility, int safetyRating, String operatingStatus, String disruptionMessage, int seatingCapacity, boolean hasWifi) {
		
		super(routeNumber, origin, destination, intermediateStops, "Bus", departureTime, estimatedTravelTime, fare, accessibility, safetyRating, operatingStatus, disruptionMessage);
		
		this.seatingCapacity = seatingCapacity;
		this.hasWifi = hasWifi;
	}

	public BusRoute() {
		super("B000", "Unknown", "Unknown", "None", "Bus","00:00", 0.0, 0.0, false, 3, "Operational", "");
		this.seatingCapacity = 60;
		this.hasWifi = false;
	}
	
	public int getSeatingCapacity() { return seatingCapacity; }
	public void setSeatingCapacity(int seatingCapacity) {this.seatingCapacity = seatingCapacity; }
	
	public boolean isHasWifi() { return hasWifi; }
	public void setHasWifi(boolean hasWifi) { this.hasWifi = hasWifi; }
	
	public void displayRoute() {
		super.displayRoute();
		System.out.println("--- Bus Specific ---");
		System.out.println("Seating Capacity : " + seatingCapacity);
		System.out.println("Has Wifi         : " + (hasWifi ? "Yes" : "No"));
		System.out.println("========================================");
	}
}