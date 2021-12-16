package mk.ukim.finki.dians_lab2.model.exceptions;

public class FuelNotFoundException extends RuntimeException {
    public FuelNotFoundException(Long id) {
        super(String.format("Fuel with id %d not found.",id));
    }
}
