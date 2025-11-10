package model;

import java.util.ArrayList;

public class Controller {

    private ArrayList<ServiceDelivery> services;

    public Controller() {
        services = new ArrayList<ServiceDelivery>();
        this.addParcelShipping("Santiago", 500, 1000, 1, 5);
        this.addExecutiveTransport("Ronaldo", 300, 2, 3, true);
    }

    public ShippingPriority calculateShippingPriority(int input) {

        return ShippingPriority.values()[input - 1];

    }

    public VehicleType calculateVehiculeType(int input) {

        return VehicleType.values()[input - 1];

    }

    public String getCodeSeries() {
        int code = 0;
        if (!services.isEmpty()) {
            code = services.size();
        }
        return "S-" + (code + 1);
    }

    
    public boolean addParcelShipping(String clientName, double baseCost, double distance,
            int shippingPriority, double weight) {

        ShippingPriority priority = calculateShippingPriority(shippingPriority);
        String code =getCodeSeries();
        ParcelShipping parcel = new ParcelShipping(priority, weight, baseCost, code, clientName, distance);
        services.add(parcel);



        return true;

       
    }

    
    public boolean addExecutiveTransport(String clientName, double distance, int vehicleType,
        int numberOfPassengers, boolean vipService) {
        VehicleType type = calculateVehiculeType(vehicleType);
        String code = getCodeSeries();
        ExecutiveTransport execT = new ExecutiveTransport(type, numberOfPassengers, code, clientName, distance, vipService);
        services.add(execT);
        return true;
    }

    
    /**
     * obtiene la informacion de los ervicios de paqueteria resgistrados
     * este metodo retorna la informacion de tdos los servicios de paqueteria
     * @pre la lista de servicios debe estar inicializada
     * @post No se modifica el estado del sistema
     * @return String con la informacion de lso serivcios de paqueteria
     * si no hay servicios retorna No hay servicios de transporte registrados
     */
    public String getInfoServicesShipping() {
    String info = "=== SERVICIOS DE PAQUETERÍA ===\n";

    for (ServiceDelivery s : services) {
        if (s instanceof ParcelShipping) {
            info += s.toString() + "\n";
        }
    }

    if (info.equals("=== SERVICIOS DE PAQUETERÍA ===\n")) {
        info += "No hay servicios de paquetería registrados.\n";
    }

    return info;
    }
    /**
     * Obtiene la informacion de todos los servicios de transporte eejcutivo registrados
     * el metodo retornal la informacion de los servicios Executive
     * @pre La lista de servicios debe estar inicializada
     * @post No se modifica el estado del sistema
     * @return String con la información formateada de todos los servicios de transporte ejecutivo.
     * Si no hay servicios registrados, retorna un mensaje indicándolo.
     */
    
    public String getInfoServicesExecutive() {
    String info = "=== SERVICIOS DE TRANSPORTE EJECUTIVO ===\n";

    for (ServiceDelivery s : services) {
        if (s instanceof ExecutiveTransport) {
            info += s.toString() + "\n";
        }
    }

    if (info.equals("=== SERVICIOS DE TRANSPORTE EJECUTIVO ===\n")) {
        info += "No hay servicios de transporte registrados.\n";
    }

    return info;
}
    /**
     * Obtiene información detallada de costos con ajustes (impuestos o descuentos) de todos los servicios.
     * Para servicios que implementan Taxable, calcula y muestra el impuesto del 12%.
     * Para servicios que implementan Discountable, calcula y muestra el descuento del 20%.
     * 
     * @pre La lista de servicios debe estar inicializada
     * @post No se modifica el estado del sistema
     * @return String con información detallada que incluye:
     *          Descripción del servicio
     *         - Costo base
     *         - Impuesto o descuento aplicable
     *         - Costo final estimado con el ajuste correspondiente
     */

public String getInfoCostsWithAdjustments() {
    String info = "=== COSTOS CON IMPUESTOS O DESCUENTOS ===\n";

    for (ServiceDelivery s : services) {
        info += s.toString() + "\n";
        info += "Costo base: $" + s.calculateTotalCost() + "\n";

        if (s instanceof Taxable) {
            double tax = ((Taxable) s).calculateTax();
            info += "Impuesto (12%): $" + tax + "\n";
            info += "Costo final con impuesto (referencial): $" + (s.calculateTotalCost() + tax) + "\n";
        } else if (s instanceof Discountable) {
            double discount = ((Discountable) s).calculateDiscount();
            info += "Descuento (20% VIP): $" + discount + "\n";
            info += "Costo final con descuento (referencial): $" + (s.calculateTotalCost() - discount) + "\n";
        }

        info += "---------------------------------\n";
    }

    return info;
}
    /**
     * Obtiene los beneficios de todos los servicios registrados en el sistema.
     * Recorre la lista completa de servicios y recopila la información de beneficios
     * que proporciona cada tipo de servicio.
     * 
     * @pre La lista de servicios debe estar inicializada
     * @post No se modifica el estado del sistema
     * @return String con la información de beneficios de todos los servicios,
     *         incluyendo la descripción del servicio y sus beneficios específicos.
     */

    
    public String getBenefitsAllServices() {
    String info = "=== BENEFICIOS DE TODOS LOS SERVICIOS ===\n";

    for (ServiceDelivery s : services) {
        info += s.toString() + "\n";
        info += s.getBenefits() + "\n";
        info += "-------------------------------\n";
    }

    return info;
}
}
