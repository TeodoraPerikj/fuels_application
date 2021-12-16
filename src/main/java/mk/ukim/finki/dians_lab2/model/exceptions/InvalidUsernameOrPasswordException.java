package mk.ukim.finki.dians_lab2.model.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException {

    public InvalidUsernameOrPasswordException(){
        super("Invalid username or password.");
    }

}
