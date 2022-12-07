package uaslp.objetos.list;

import uaslp.objetos.list.exceptions.WrongIndexException;

public interface Iterator<T> {
    boolean hasNext();

    T next() throws WrongIndexException;
}
