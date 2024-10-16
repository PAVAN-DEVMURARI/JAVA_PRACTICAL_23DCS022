import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Exception Handling
class CarNotAvailableException extends Exception {
    public CarNotAvailableException(String message) {
        super(message);
    }
}

class CarNotRentedException extends Exception {
    public CarNotRentedException(String message) {
        super(message);
    }
}

// Vehicle Class (Base Class)
abstract class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private double basePricePerHour;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String brand, String model, double basePricePerDay, double basePricePerHour) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.basePricePerHour = basePricePerHour;
        this.isAvailable = true;
    }

    // Getter and Setter methods for vehicle attributes
    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getBasePricePerHour() {
        return basePricePerHour;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public synchronized void rent() throws CarNotAvailableException {
        if (!isAvailable) {
            throw new CarNotAvailableException("Vehicle is not available for rent.");
        }
        isAvailable = false;
    }

    public synchronized void returnVehicle() throws CarNotRentedException {
        if (isAvailable) {
            throw new CarNotRentedException("Vehicle was not rented.");
        }
        isAvailable = true;
    }

    public double calculatePrice(int rentalDays, float rentalHours) {
        return (basePricePerHour * (rentalDays * 24 + rentalHours));
    }

    public abstract void displayInfo();
}

// Car Class (Derived Class)
class Car extends Vehicle {
    public Car(String carId, String brand, String model, double basePricePerDay, double basePricePerHour) {
        super(carId, brand, model, basePricePerDay, basePricePerHour);
    }

    @Override
    public void displayInfo() {
        System.out.println("Car ID: " + getVehicleId() + " - " + getBrand() + " " + getModel() +
                " (Price per hour: ₹" + getBasePricePerHour() + ")");
    }
}

// SUV Class (Derived Class)
class SUV extends Vehicle {
    private boolean isFourWheelDrive;

    public SUV(String vehicleId, String brand, String model, double basePricePerDay, double basePricePerHour, boolean isFourWheelDrive) {
        super(vehicleId, brand, model, basePricePerDay, basePricePerHour);
        this.isFourWheelDrive = isFourWheelDrive;
    }

    @Override
    public void displayInfo() {
        System.out.println("SUV ID: " + getVehicleId() + " - " + getBrand() + " " + getModel() +
                " (Price per hour: ₹" + getBasePricePerHour() + ")");
    }
}

// Electric Car Class (Derived Class)
class ElectricCar extends Vehicle {
    private int batteryCapacity;

    public ElectricCar(String vehicleId, String brand, String model, double basePricePerDay, double basePricePerHour, int batteryCapacity) {
        super(vehicleId, brand, model, basePricePerDay, basePricePerHour);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Electric Car ID: " + getVehicleId() + " - " + getBrand() + " " + getModel() +
                " (Price per hour: ₹" + getBasePricePerHour() + ")");
    }
}

// Customer Class
class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}

// Rental Class
class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private int days;
    private float hours;
    private Date startDate;
    private Date endDate;
    private double totalCost;
    private double gst;
    private double finalAmount;

    public Rental(Vehicle vehicle, Customer customer, int days, float hours, Date startDate, Date endDate) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.hours = hours;
        this.startDate = startDate;
        this.endDate = endDate;

        this.totalCost = vehicle.calculatePrice(days, hours);
        this.gst = totalCost * 0.18; // 18% GST
        this.finalAmount = totalCost + gst;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public float getHours() {
        return hours;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getGst() {
        return gst;
    }

    public double getFinalAmount() {
        return finalAmount;
    }
}

// Rental Task for Multithreading
class RentalTask implements Runnable {
    private Vehicle vehicle;
    private Customer customer;
    private int days;
    private float hours;
    private Date startDate;
    private Date endDate;

    public RentalTask(Vehicle vehicle, Customer customer, int days, float hours, Date startDate, Date endDate) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.hours = hours;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public void run() {
        try {
            System.out.println("Processing rental...");
            Thread.sleep(2000);
            vehicle.rent();

            SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE MMM dd yyyy");
            String formattedStartDate = dateFormatter.format(startDate);
            String formattedEndDate = dateFormatter.format(endDate);

            System.out.println("\nVehicle rented successfully by " + customer.getName());
            System.out.println("Rental Period: " + formattedStartDate + " to " + formattedEndDate);

            double totalCost = vehicle.calculatePrice(days, hours);
            double gst = totalCost * 0.18; // 18% GST
            double finalAmount = totalCost + gst;

            System.out.printf("Total Cost (before GST): ₹%.2f\n", totalCost);
            System.out.printf("GST (18%%): ₹%.2f\n", gst);
            System.out.printf("Final Amount (including GST): ₹%.2f\n", finalAmount);
        } catch (CarNotAvailableException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Return Task for Multithreading
class ReturnTask implements Runnable {
    private Vehicle vehicle;
    private Customer customer;

    public ReturnTask(Vehicle vehicle, Customer customer) {
        this.vehicle = vehicle;
        this.customer = customer;
    }

    @Override
    public void run() {
        try {
            System.out.println("Processing return...");
            Thread.sleep(2000);
            vehicle.returnVehicle();
            System.out.println("\nVehicle returned successfully by " + customer.getName());
        } catch (CarNotRentedException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Rental History Class
class RentalHistory {
    private Customer customer;
    private List<Rental> rentalRecords;

    public RentalHistory(Customer customer) {
        this.customer = customer;
        this.rentalRecords = new ArrayList<>();
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void addRentalRecord(Rental rental) {
        rentalRecords.add(rental);
        saveRentalToFile(rental); // Save rental history to file
    }

    public void displayRentalHistory() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("\nRental History for " + customer.getName() + ":");
        for (Rental rental : rentalRecords) {
            String startDate = dateFormatter.format(rental.getStartDate());
            String endDate = dateFormatter.format(rental.getEndDate());

            System.out.printf("\n1. Customer ID: %s\n", rental.getCustomer().getCustomerId());
            System.out.printf("2. Name: %s\n", rental.getCustomer().getName());
            System.out.printf("3. Date: From %s to %s\n", startDate, endDate);
            System.out.printf("4. Rental Days: %d, Rental Hours: %.2f\n", rental.getDays(), rental.getHours());
            System.out.printf("5. Total Price (before GST): ₹%.2f\n", rental.getTotalCost());
            System.out.printf("6. GST: ₹%.2f\n", rental.getGst());
            System.out.printf("7. Total Cost (including GST): ₹%.2f\n", rental.getFinalAmount());
            System.out.println("---------------------------------------------------");
        }
    }

    private void saveRentalToFile(Rental rental) {
        String fileName = rental.getCustomer().getCustomerId() + "_rental_history.txt"; // Use customer ID as file name
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String startDate = dateFormatter.format(rental.getStartDate());
            String endDate = dateFormatter.format(rental.getEndDate());

            writer.write("Rental Record:");
            writer.newLine();
            writer.write("Customer ID: " + rental.getCustomer().getCustomerId());
            writer.newLine();
            writer.write("Name: " + rental.getCustomer().getName());
            writer.newLine();
            writer.write("Date: From " + startDate + " to " + endDate);
            writer.newLine();
            writer.write("Rental Days: " + rental.getDays() + ", Rental Hours: " + rental.getHours());
            writer.newLine();
            writer.write("Total Price (before GST): ₹" + rental.getTotalCost());
            writer.newLine();
            writer.write("GST: ₹" + rental.getGst());
            writer.newLine();
            writer.write("Total Cost (including GST): ₹" + rental.getFinalAmount());
            writer.newLine();
            writer.write("---------------------------------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

// CarRentalSystem Class
class main {
    private List<Vehicle> vehicles;
    private List<Customer> customers;
    private List<RentalHistory> rentalHistories;

    public main() {
        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
        rentalHistories = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle getVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    public void displayAllVehicles() {
        System.out.println("\nAvailable Vehicles:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                vehicle.displayInfo();
            }
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        rentalHistories.add(new RentalHistory(customer)); // Create rental history for new customer
    }

    public Customer getCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void rentVehicle(Vehicle vehicle, Customer customer, int days, float hours, Date startDate, Date endDate) {
        Rental rental = new Rental(vehicle, customer, days, hours, startDate, endDate);
        RentalTask rentalTask = new RentalTask(vehicle, customer, days, hours, startDate, endDate);
        rentalHistories.stream().filter(rh -> rh.getCustomer().equals(customer)).findFirst().ifPresent(rh -> rh.addRentalRecord(rental));
        new Thread(rentalTask).start();
    }

    public void returnVehicle(Vehicle vehicle, Customer customer) {
        ReturnTask returnTask = new ReturnTask(vehicle, customer);
        new Thread(returnTask).start();
    }

    public void displayRentalHistory(Customer customer) {
        rentalHistories.stream().filter(rh -> rh.getCustomer().equals(customer)).findFirst()
            .ifPresent(RentalHistory::displayRentalHistory);
    }
}

// Main Class
public class Main_1 {
    public static void main(String[] args) {
        main rentalSystem = new main();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Adding Vehicles
        rentalSystem.addVehicle(new Car("C101", "Toyota", "Corolla", 500, 25));
        rentalSystem.addVehicle(new SUV("S201", "Ford", "Explorer", 1000, 50, true));
        rentalSystem.addVehicle(new ElectricCar("E301", "Tesla", "Model S", 1500, 75, 100));

        System.out.println("Enter the Name of Customer:");
        String name = scanner.next();
        System.out.println("Enter the ID:");
        String ID = scanner.next();

        // Adding Customers
        rentalSystem.addCustomer(new Customer(ID, name));

        // Menu for operations
        while (true) {
            System.out.println("\nCar Rental System");
            System.out.println("1. Display All Vehicles");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. Return a Vehicle");
            System.out.println("4. Display Rental History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rentalSystem.displayAllVehicles();
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.next();
                    Customer customer = rentalSystem.getCustomerById(customerId);
                    if (customer == null) {
                        System.out.println("Customer not found!");
                        break;
                    }

                    System.out.print("Enter Vehicle ID: ");
                    String vehicleId = scanner.next();
                    Vehicle vehicle = rentalSystem.getVehicleById(vehicleId);
                    if (vehicle == null) {
                        System.out.println("Vehicle not found!");
                        break;
                    }

                    System.out.print("Enter number of days to rent: ");
                    int days = scanner.nextInt();
                    System.out.print("Enter number of hours to rent: ");
                    float hours = scanner.nextFloat();

                    Date startDate = null;
                    Date endDate = null;
                    try {
                        System.out.print("Enter start date (dd-MM-yyyy): ");
                        startDate = dateFormat.parse(scanner.next());

                        System.out.print("Enter end date (dd-MM-yyyy): ");
                        endDate = dateFormat.parse(scanner.next());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter dates in dd-MM-yyyy format.");
                        break;
                    }

                    rentalSystem.rentVehicle(vehicle, customer, days, hours, startDate, endDate);
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    customerId = scanner.next();
                    customer = rentalSystem.getCustomerById(customerId);
                    if (customer == null) {
                        System.out.println("Customer not found!");
                        break;
                    }

                    System.out.print("Enter Vehicle ID: ");
                    vehicleId = scanner.next();
                    vehicle = rentalSystem.getVehicleById(vehicleId);
                    if (vehicle == null) {
                        System.out.println("Vehicle not found!");
                        break;
                    }

                    rentalSystem.returnVehicle(vehicle, customer);
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    customerId = scanner.next();
                    customer = rentalSystem.getCustomerById(customerId);
                    if (customer == null) {
                        System.out.println("Customer not found!");
                        break;
                    }

                    rentalSystem.displayRentalHistory(customer);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
