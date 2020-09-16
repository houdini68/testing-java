package api.java.util.optional.absenceofvaluebynull;

public class Person {
    private static final String UNKNOWN = "Unknown";
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCarInsuranceName(Person person) {
        if (person != null) { // defensive checking
            Car car = person.getCar();
            if (car != null) { // defensive checking
                Insurance insurance = car.getInsurance();
                if (insurance != null) { // defensive checking
                    return insurance.getName();
                }
            }
        }
        return UNKNOWN;
    }

    public String getCarInsuranceNameAvoidNestedBlocks(Person person) {
        if (person == null) {
            return UNKNOWN;
        }
        Car car = person.getCar();
        if (car == null) {
            return UNKNOWN;
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return UNKNOWN;
        }
        return insurance.getName();
    }
}