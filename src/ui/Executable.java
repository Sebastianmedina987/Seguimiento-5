package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {
    private Controller controller;
    private Scanner scanner;

    public Executable() {
        controller = new Controller();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.start();
    }

    public void start() {
        System.out.println("Welcome to the Logistics Management System");
        String in;
        do {
            displayMenu();
            System.out.print("Please select an option: ");
            in = scanner.nextLine();

            switch (in) {
                case "1":
                    registerParcelShipping();
                    break;
                case "2":
                    registerExecutiveTransport();
                    break;
                case "3":
                    showRegisteredServicesShipping();
                    break;
                case "4":
                    showRegisteredServicesExecutive();
                    break;
                case "5":
                    showCostsAndOtherDetails();
                    break;
                case "6":
                    showBenefitsAllServices();
                    break;
                case "7":
                    System.out.println("Thank you for using GlobalLogistics S.A.S.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }


                
                
           } while (!in.equals("8"));

        scanner.close();
    }

    public void displayMenu() {

        System.out.println("\nMAIN MENU");
        System.out.println("-----------------------------------------------------------");
        System.out.println("1. Registrar servicio de Paquetería");
        System.out.println("2. Registrar servicio de Transporte Ejecutivo");
        System.out.println("3. Mostrar todos los servicios de Paqueteria");
        System.out.println("4. Mostrar todos los servicios de Transporte Ejecutivo");
        System.out.println("5. Mostrar los costos totales y sus descuentos/impuestos");
        System.out.println("6. Mostrar todos los beneficios");
        System.out.println("7. Salir");
    }

    public void displayShippingPriorityMenu() {
        System.out.println("Seleccione la prioridad de envío:");
        System.out.println("1. NORMAL");
        System.out.println("2. URGENT");
    }

    public void displayVehicleMenu() {
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. ECONOMY");
        System.out.println("2. LUXURY");
        System.out.println("3. EXECUTIVE");
    }

    public void registerParcelShipping() {
        displayShippingPriorityMenu();
        int shippingPriority = -1;
        do {
            System.out.print("Please select an option: ");
            shippingPriority = scanner.nextInt();

            switch (shippingPriority) {
                case 1:
                case 2:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    shippingPriority = -1;
                    break;
            }
        } while (shippingPriority == -1);

        scanner.nextLine();

        System.out.print("Enter name of the client: ");
        String clientName = scanner.nextLine();
        System.out.print("Enter base cost of package: ");
        double baseCost = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter distance to be covered (in km): ");
        double distance = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter weight of the package (in kg): ");
        double weight = Double.parseDouble(scanner.nextLine());

        this.controller.addParcelShipping(clientName, baseCost, distance, shippingPriority, weight);

        System.out.println("------------------------------------------");
        System.out.println("Parcel shipping registered successfully.");
    }

    public void registerExecutiveTransport() {
        displayVehicleMenu();

        int vehicleType = -1;
        do {
            System.out.print("Please select an option: ");
            vehicleType = scanner.nextInt();
            switch (vehicleType) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    vehicleType = -1;
            }
        } while (vehicleType == -1);

        System.out.print("Enter name of the client: ");
        String clientName = scanner.nextLine();
        System.out.print("Enter distance to be covered (in km): ");
        double distance = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter number of passengers: ");
        int numberOfPassengers = Integer.parseInt(scanner.nextLine());
        System.out.print("Is it a VIP service? (true or false): ");
        boolean vipService = Boolean.parseBoolean(scanner.nextLine());

        this.controller.addExecutiveTransport(clientName, distance, vehicleType, numberOfPassengers, vipService);

        System.out.println("---------------------------------------");
        System.out.println("Executive transport registered successfully.");
    }

    public void showRegisteredServicesShipping() {
        System.out.println("Registered Shipping Services:");
        String info = controller.getInfoServicesShipping();
        System.out.println(info);
        System.out.println("------------------------------------------");
    }

    public void showRegisteredServicesExecutive() {
        System.out.println("Registered Executive Transport Services:");
        String info = controller.getInfoServicesExecutive();
        System.out.println(info);
        System.out.println("------------------------------------------");
    }

    public void showCostsAndOtherDetails() {
        System.out.println("Service Costs and Details:");
        String infoShipping = controller.getInfoCostsWithAdjustments();
        System.out.println(infoShipping);
        System.out.println("-------------------------------------------");
    }

    public void showBenefitsAllServices() {
        System.out.println("Benefits of All Services:");
        String benefits = controller.getBenefitsAllServices();
        System.out.println(benefits);
        System.out.println("----------------------------------------");
    }
}
