package q1_LucasComaru;

public class Truck extends Vehicle {
    private int mass;

    public Truck(String registrationNumber, int mass) {
        super(registrationNumber);
        this.mass = mass;
    }
}
