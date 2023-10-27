package q1_LucasComaru;

public class Car extends Vehicle {
    private String transmission;

    public Car(String registrationNumber, String transmission) {
        super(registrationNumber);
        this.transmission = transmission;
    }
}
