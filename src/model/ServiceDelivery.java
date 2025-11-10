package model;

public abstract class ServiceDelivery {

    private String codeService;
    private String clientName;
    private double baseCost;
    private double distance;

    public ServiceDelivery(String codeService, String clientName, double baseCost, double distance) {
        this.codeService = codeService;
        this.clientName = clientName;
        this.baseCost = baseCost;
        this.distance = distance;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String toString() {
        return "Servicio " + codeService + " para cliente " + clientName + " con distancia " + distance + " km";
    }

    public abstract double calculateTotalCost();

    public abstract String getBenefits();

    

}
