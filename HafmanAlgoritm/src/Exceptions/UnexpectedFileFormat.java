package Exceptions;

public class UnexpectedFileFormat extends Throwable {

    public UnexpectedFileFormat() {
        super();
    }

    public UnexpectedFileFormat(String message) {
        super(message);
    }
}
