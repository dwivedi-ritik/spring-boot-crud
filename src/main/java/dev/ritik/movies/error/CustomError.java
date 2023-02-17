package dev.ritik.movies.error;

public class CustomError {
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomError(String message) {
        this.message = message;
    }
}
