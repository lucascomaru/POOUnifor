package q1_LucasComaru;

public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck("123456", 5000);
        Car car = new Car("654321", "Automatic");

        Employee employee1 = new Employee("John Doe", truck);
        Employee employee2 = new Employee("Jane Smith", car);

        Employee[] employees = {employee1, employee2};

        Company company = new Company("Example Company", employees);
        company.hires(employee1);
        company.hires(employee2);
    }
}
