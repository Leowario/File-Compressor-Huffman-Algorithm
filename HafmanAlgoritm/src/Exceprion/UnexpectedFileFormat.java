package Exceprion;

import java.io.IOException;

public class UnexpectedFileFormat extends Throwable {

    public UnexpectedFileFormat() {
        super();
    }

    public UnexpectedFileFormat(String message) {
        super(message);
    }
}
