package uaslp.objetos.list;

import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public interface List<T> {
    void addAtTail(T var1) throws NullNotAllowedException;

    void addAtFront(T var1) throws NullNotAllowedException;

    void removeAll();

    boolean remove(int var1) throws WrongIndexException;

    boolean setAt(int var1, T var2) throws WrongIndexException, NullNotAllowedException;

    T getAt(int var1) throws WrongIndexException;

    Iterator<T> getIterator();

    int getSize();
}
