package src.za.transitassist;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TransitManager manager = new TransitManager();
        
        // Load the 15 localized sample routes required by the brief
        loadSampleData(manager);

        int choice;
        do {
            displayMenu();
            choice = getMenuChoice(input);

            switch (choice) {
                case 1:
                    addRoute(input, manager);
                    break;
                case 2:
                    manager.displayAllRoutes();
                    break;
                case 3:
                    searchRoutes(input, manager);
                    break;
                case 4:
                    updateRouteStatus(input, manager);
                    break;
                case 5:
                    manager.displayStatistics();
                    break;
                case 6:
                    System.out.println("\nThank you for using TransitAssist. Hamba kahle (Go well).");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        input.close();
    }

    public static void displayMenu() {
        System.out.println("\n=================================");
        System.out.println("      TRANSIT ASSIST (ZULULAND)");
        System.out.println("=================================");
        System.out.println("1. Add a new transport route (Operator)");
        System.out.println("2. Display all routes");
        System.out.println("3. Search routes by Origin & Destination");
        System.out.println("4. Update route operating status (Operator)");
        System.out.println("5. Display system statistics (Summary)");
        System.out.println("6. Exit");
    }

    public static int getMenuChoice(Scanner input) {
        while (true) {
            System.out.print("Enter your choice (1-6): ");
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine(); // Consume the newline character
                if (choice >= 1 && choice <= 6) {
                    return choice;
                }
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next(); // Clear the invalid input
            }
        }
    }

    public static void searchRoutes(Scanner input, TransitManager manager) {
        System.out.println("\n--- Search Routes ---");
        System.out.print("Enter Origin (e.g., Nongoma): ");
        String origin = input.nextLine();
        System.out.print("Enter Destination (e.g., Ulundi): ");
        String destination = input.nextLine();
        manager.searchRoutes(origin, destination);
    }

    public static void updateRouteStatus(Scanner input, TransitManager manager) {
        System.out.println("\n--- Update Route Status ---");
        System.out.print("Enter Route Number to update: ");
        String routeNum = input.nextLine();
        System.out.print("Enter New Status (e.g., Delayed, Operating Normally): ");
        String newStatus = input.nextLine();
        
        if (manager.updateRouteStatus(routeNum, newStatus)) {
            System.out.println("Success: Route status updated.");
        } else {
            System.out.println("Error: Route number not found.");
        }
    }

    public static void addRoute(Scanner input, TransitManager manager) {
        System.out.println("\n--- Add New Route ---");
        System.out.print("Route Number: ");
        String routeNum = input.nextLine();
        System.out.print("Origin: ");
        String origin = input.nextLine();
        System.out.print("Destination: ");
        String dest = input.nextLine();
        System.out.print("Transport Type (Bus/Taxi/Train): ");
        String type = input.nextLine();
        System.out.print("Departure Time (e.g., 08:00): ");
        String depTime = input.nextLine();
        
        double travelTime = getDoubleInput(input, "Estimated Travel Time (mins): ");
        double fare = getDoubleInput(input, "Fare (R): ");
        int safety = getIntInput(input, "Safety Rating (1-5): ");
        
        System.out.print("Operating Status: ");
        String status = input.nextLine();
        System.out.print("Disruption Message (or press Enter for none): ");
        String disruption = input.nextLine();

        // Simplified add for prototype: defaults to Bus if not specified perfectly
        TransportRoute newRoute = new BusRoute(routeNum, origin, dest, "Various", depTime, 
                travelTime, fare, true, safety, status, disruption, 50, false);
        
        if (manager.addRoute(newRoute)) {
            System.out.println("Route added successfully.");
        } else {
            System.out.println("Error: Route list is full.");
        }
    }

    private static double getDoubleInput(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextDouble()) {
                double val = input.nextDouble();
                input.nextLine(); // consume newline
                return val;
            } else {
                System.out.println("Invalid number. Please try again.");
                input.next();
            }
        }
    }

    private static int getIntInput(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                int val = input.nextInt();
                input.nextLine(); // consume newline
                return val;
            } else {
                System.out.println("Invalid whole number. Please try again.");
                input.next();
            }
        }
    }

    // --- LOCALIZED SAMPLE DATA (KZN / ZULULAND REGION) ---
    private static void loadSampleData(TransitManager manager) {
        manager.addRoute(new BusRoute("B01", "Nongoma", "Ulundi", "Umkhuze", "06:00", 60, 45.00, true, 4, "Operating Normally", "", 50, true));
        manager.addRoute(new TaxiRoute("X01", "Hluhluwe", "Mtubatuba", "None", "07:30", 30, 35.00, false, 3, "Operating Normally", "", "Hluhluwe Rank", true));
        manager.addRoute(new BusRoute("B02", "Hlabisa", "Mtubatuba", "Hluhluwe", "08:15", 45, 50.00, true, 3, "Delayed", "Heavy rain on R618", 45, false));
        manager.addRoute(new TrainRoute("T01", "Empangeni", "Richards Bay", "Meerensee", "09:00", 25, 20.00, true, 4, "Operating Normally", "", "Economy", 4));
        manager.addRoute(new TaxiRoute("X02", "Ulundi", "Vryheid", "None", "10:30", 90, 80.00, false, 3, "Operating Normally", "", "Ulundi Rank", true));
        manager.addRoute(new BusRoute("B03", "Eshowe", "Melmoth", "None", "11:00", 40, 40.00, true, 4, "Operating Normally", "", 40, true));
        manager.addRoute(new TaxiRoute("X03", "Nongoma", "Hlabisa", "Umkhuze", "12:15", 50, 40.00, false, 2, "Weather Affected", "Flooding near Umkhuze bridge", "Nongoma Rank", false));
        manager.addRoute(new BusRoute("B04", "Dundee", "Vryheid", "Glencoe", "13:00", 70, 60.00, true, 4, "Operating Normally", "", 55, true));
        manager.addRoute(new TrainRoute("T02", "Richards Bay", "Empangeni", "Ngwelezane", "14:30", 25, 20.00, true, 4, "Infrastructure Damage", "Track maintenance in progress", "Economy", 3));
        manager.addRoute(new TaxiRoute("X04", "Mtubatuba", "Hluhluwe", "None", "15:00", 30, 35.00, true, 3, "Operating Normally", "", "Mtubatuba Rank", true));
        manager.addRoute(new BusRoute("B05", "Ulundi", "Nongoma", "Umkhuze", "16:00", 60, 45.00, false, 3, "Alternative Route Available", "Road closure on main R34", 45, false));
        manager.addRoute(new TaxiRoute("X05", "Vryheid", "Utrecht", "None", "17:15", 45, 55.00, true, 4, "Operating Normally", "", "Vryheid Rank", true));
        manager.addRoute(new BusRoute("B06", "Eshowe", "Gingindlovu", "None", "18:00", 20, 30.00, true, 5, "Operating Normally", "", 35, true));
        manager.addRoute(new TaxiRoute("X06", "Hlabisa", "Nongoma", "Umkhuze", "19:30", 50, 40.00, false, 2, "Temporarily Suspended", "Vehicle breakdown at rank", "Hlabisa Rank", false));
        manager.addRoute(new TrainRoute("T03", "Empangeni", "Somkele", "None", "06:45", 15, 15.00, true, 4, "Operating Normally", "", "Shuttle", 2));
    }
}