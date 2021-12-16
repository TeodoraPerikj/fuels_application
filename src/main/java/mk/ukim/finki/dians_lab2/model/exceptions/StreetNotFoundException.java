package mk.ukim.finki.dians_lab2.model.exceptions;

public class StreetNotFoundException extends RuntimeException {
    public StreetNotFoundException(Long id) {
        super(String.format("Street with id %d not found.",id));
    }
}
