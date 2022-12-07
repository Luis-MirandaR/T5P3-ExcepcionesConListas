package uaslp.objetos.list.exceptions;

public class NullNotAllowedException extends RuntimeException {
    public NullNotAllowedException() {
        super("Null values are not allowed");
    }
}