package src.za.transitassist;

public class TransitManager {

    // --- Data Structure (Array) ---
    private TransportRoute[] routes;
    private int routeCount;

    // --- Constructor ---
    public TransitManager() {
        routes = new TransportRoute[50]; // We can store up to 50 routes
        routeCount = 0;
    }

    // --- 1. Add a new route ---
    public boolean addRoute(TransportRoute route) {
        if (routeCount < routes.length) {
            routes[routeCount] = route;
            routeCount++;
            return true;
        }
        return false; // Array is full
    }

    // --- 2. Display all routes ---
    public void displayAllRoutes() {
        if (routeCount == 0) {
            System.out.println("No routes available in the system yet.");
            return;
        }
        System.out.println("\n--- ALL AVAILABLE ROUTES ---");
        for (int i = 0; i < routeCount; i++) {
            routes[i].displayRoute();
        }
    }

    // --- 3. Search by Origin and Destination ---
    public void searchRoutes(String origin, String destination) {
        boolean found = false;
        System.out.println("\n--- SEARCH RESULTS ---");
        for (int i = 0; i < routeCount; i++) {
            if (routes[i].getOrigin().equalsIgnoreCase(origin) && 
                routes[i].getDestination().equalsIgnoreCase(destination)) {
                routes[i].displayRoute();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No routes found from " + origin + " to " + destination);
        }
    }

    // --- 4. Update Route Status ---
    public boolean updateRouteStatus(String routeNumber, String newStatus) {
        for (int i = 0; i < routeCount; i++) {
            if (routes[i].getRouteNumber().equalsIgnoreCase(routeNumber)) {
                routes[i].setOperatingStatus(newStatus);
                return true; // Found and updated
            }
        }
        return false; // Route not found
    }

    // --- 5. Calculate Summary/Statistics ---
    public void displayStatistics() {
        if (routeCount == 0) {
            System.out.println("No routes to calculate statistics.");
            return;
        }
        double totalFare = 0;
        int accessibleCount = 0;
        
        for (int i = 0; i < routeCount; i++) {
            totalFare += routes[i].getFare();
            if (routes[i].isAccessibility()) {
                accessibleCount++;
            }
        }
        
        double averageFare = totalFare / routeCount;
        System.out.println("\n--- TRANSIT ASSIST STATISTICS ---");
        System.out.println("Total Routes       : " + routeCount);
        System.out.println("Average Fare       : R" + String.format("%.2f", averageFare));
        System.out.println("Accessible Routes  : " + accessibleCount + " out of " + routeCount);
    }

    // --- Helper: Find a specific route by number (Useful for calculating arrival times later) ---
    public TransportRoute getRouteByNumber(String routeNumber) {
        for (int i = 0; i < routeCount; i++) {
            if (routes[i].getRouteNumber().equalsIgnoreCase(routeNumber)) {
                return routes[i];
            }
        }
        return null; // Not found
    }
}
