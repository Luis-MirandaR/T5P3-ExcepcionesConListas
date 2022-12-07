package uaslp.objetos.list.exceptions;

public class WrongIndexException extends RuntimeException {
    public WrongIndexException(int wrongIndex) {
        super("Index " + wrongIndex + " is out of bounds");
    }
}
