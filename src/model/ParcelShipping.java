package model;

public class ParcelShipping extends ServiceDelivery implements Taxable{

    private ShippingPriority shippingPriority;
    private double weight;

    public ParcelShipping(ShippingPriority shippingPriority, double weight, double baseCost, String codeService,
            String clientName, double distance) {
        super(codeService, clientName, baseCost, distance);
        this.shippingPriority = shippingPriority;
        this.weight = weight;
    }

    public ShippingPriority getShippingPriority() {
        return shippingPriority;
    }

    public void setShippingPriority(ShippingPriority shippingPriority) {
        this.shippingPriority = shippingPriority;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
     /**
     * Calcula el costo total del servicio de paquetería.
     * 
     * Fórmula de cálculo:
     * Costo base + (distancia * 80) + (peso * 5)
     * Si la prioridad es URGENT, se le aplica un 15%
     * 
     * @return double con el costo total calculado
     * @pre Los atributos baseCost, distance, weight y shippingPriority deben estar inicializados
     * @post Retorna el costo total sin modificar el estado del objeto
     */
    @Override
    public double calculateTotalCost(){
        double totalCost = getBaseCost() + (getDistance() * 80 + (weight * 5));
        if(shippingPriority == ShippingPriority.URGENT){
            totalCost *= 1.15;
        }
        return totalCost;


    }
    /**
     * Calcula el impuesto aplicable al servicio de paquetería.
     * Implementación del método de la interfaz Taxable.
     * 
     * El impuesto es del 12% sobre el costo total del servicio.
     * 
     * @return double con el valor del impuesto (12% del costo total)
     * @pre El costo total debe poder ser calculado
     * @post Retorna el impuesto sin modificar el estado del objeto
     */
    @Override
    public double calculateTax(){
        return calculateTotalCost() * 0.12;
    }
    /**
     * Obtiene los beneficios del servicio de paquetería.
     * Implementación del método abstracto de ServiceDelivery.
     * 
     * @return String describiendo los beneficios: seguimiento y seguro de envío
     */
    @Override

    public String getBenefits(){
        return "Beneficios: Seguimeinto y seguro de envio";

    }
    /**
     * Genera una representación en texto del servicio de paquetería.
     * Incluye información del servicio base más detalles específicos de paquetería.
     * 
     * @return String con información completa: código, cliente, distancia,
     *         tipo de servicio, prioridad y peso
     */
    @Override
    public String toString() {
        return super.toString() + "  | tipo de paqueteria | Priorioda :  " + shippingPriority + " | Peso=" + weight + "kg";
    }
    
    

    
    }

