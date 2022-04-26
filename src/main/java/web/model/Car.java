package web.model;

public class Car {
    private final String brand;
    private final String model;
    private final String engineVol;

    public Car(String brand, String model, String engineVol) {
        this.brand = brand;
        this.model = model;
        this.engineVol = engineVol;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getEngineVol() {
        return engineVol;
    }
}
