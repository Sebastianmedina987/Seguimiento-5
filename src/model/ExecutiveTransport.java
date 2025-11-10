package model;

import java.lang.reflect.Type;

public class ExecutiveTransport extends ServiceDelivery implements Discountable {

    private VehicleType vehicleType;
    private int numberOfPassengers;
    private boolean vipService;

    public ExecutiveTransport(VehicleType vehicleType, int numberOfPassengers, String codeService,
            String clientName, double distance, boolean vipService) {
        super(codeService, clientName, calculateBaseCost(vehicleType), distance);
        this.vehicleType = vehicleType;
        this.numberOfPassengers = numberOfPassengers;
        this.vipService = vipService;

    }
    /**
     * Calcula el costo base según el tipo de vehículo.
     * Método utilizado internamente para determinar costos.
     * 
     * 
     * 
     * @param type Tipo de vehículo
     * @return double con el costo base correspondiente al tipo de vehículo
     * @pre type no debe ser nulo
     * @post Retorna el costo base sin modificar ningún estado
     */
    private static double calculateBaseCost(VehicleType type){
        switch (type) {
            case ECONOMY:
                
                return 50000;
            case LUXURY:

                return 80000;

            case EXECUTIVE:

                return 120000;

        
            default:

                return 0 ;
                
        }
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
    /**
     * Calcula el costo total del servicio de transporte ejecutivo.
     * 
     * Fórmula de cálculo:
     * 1. Costo base (getBaseCost) + (distancia * tarifa por km según tipo de vehículo)
     *    ECONOMY: 80 por km
     *    EXECUTIVE: 100 por km
     *    LUXURY: 150 por km
     * 2. Si el número de pasajeros es mayor a 3, se aplica un recargo del 10%
     * 
     * @return double con el costo total calculado
     * @pre Los atributos vehicleType, distance y numberOfPassengers deben estar inicializados
     * @post Retorna el costo total sin modificar el estado del objeto
     */
    @Override
    public double calculateTotalCost() {
        double costperKm = 0;

        switch (vehicleType) {
            case ECONOMY:

                
                costperKm =  80;

                break;

            case EXECUTIVE:
                
                costperKm = 100;
                break;

            
            case LUXURY:

                costperKm = 150;
                break;
        }
        double totalCost = getBaseCost() + (getDistance() * costperKm);
        if (numberOfPassengers > 3) {
            totalCost *= 1.10;
        
        }
        return totalCost;
    }
    /**
     * Calcula el descuento aplicable al servicio.
     * 
     * 
     * Si el servicio es VIP, se aplica un descuento del 20% sobre el costo total.
     * Si no es VIP, no hay descuento .
     * 
     * @return double con el valor del descuento (20% si es VIP, 0 en caso contrario)
     * @pre El costo total debe poder ser calculado
     * @post Retorna el descuento sin modificar el estado del objeto
     */
    public double calculateDiscount(){
        if(vipService){
            return calculateTotalCost() * 0.20;
        }
        return 0;
    }
    /**
     * Obtiene los beneficios del servicio de transporte ejecutivo.
     * Implementación del método abstracto de ServiceDelivery.
     * 
     * @return String describiendo los beneficios: comodidades y atención personalizada
     */
    @Override
    public String getBenefits() {
        return  "Beneficios: comodidades y atención personalizada.";
    }
    /**
     * Genera una representación en texto del servicio de transporte ejecutivo.
     * Incluye información del servicio base más detalles específicos del transporte.
     * 
     * @return String con información completa: código, cliente, distancia,
     *         tipo de transporte, vehículo, número de pasajeros y si es VIP
     */
    @Override
    public String toString() {
        return super.toString() +  "Tipo de transporte ejecutivo | vehiculo: " + vehicleType + " Pasajeros :" + numberOfPassengers
                + ", Vip :" + vipService + "]";
    }
    


}
