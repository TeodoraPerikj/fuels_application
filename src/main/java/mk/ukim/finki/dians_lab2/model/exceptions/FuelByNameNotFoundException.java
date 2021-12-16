package mk.ukim.finki.dians_lab2.model.exceptions;

public class FuelByNameNotFoundException extends RuntimeException {
    public FuelByNameNotFoundException(String name) {
        super(String.format("Fuel with name %s not found.",name));
    }
}
