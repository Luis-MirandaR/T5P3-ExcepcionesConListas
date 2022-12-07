package uaslp.objetos.list.ArrayList;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.NullNotAllowedException;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_SIZE = 5;
    private T[] array;
    private int size;

    public ArrayList(int size) {
        this.array = (T[]) new Object[size];
    }

    public ArrayList() {
        this.array = (T[]) new Object[5];
    }

    public void addAtTail(T data) throws NullNotAllowedException {
        if (data == null) {
            throw new NullNotAllowedException();
        } else {
            if (this.size == this.array.length) {
                this.increaseArrayList();
            }

            this.array[this.size] = data;
            ++this.size;
        }
    }

    public void addAtFront(T data) throws NullNotAllowedException {
        if (data == null) {
            throw new NullNotAllowedException();
        } else {
            if (this.size == this.array.length) {
                this.increaseArrayList();
            }

            if (this.size >= 0) {
                System.arraycopy(this.array, 0, this.array, 1, this.size);
            }

            this.array[0] = data;
            ++this.size;
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < this.size) {
            if (this.size - 1 - index >= 0) {
                System.arraycopy(this.array, index + 1, this.array, index, this.size - 1 - index);
            }

            this.array[this.size - 1] = null;
            --this.size;
            return true;
        } else {
            return false;
        }
    }

    public void removeAll() {
        for(int i = 0; i < this.size; ++i) {
            this.array[i] = null;
        }

        this.size = 0;
    }

    public T getAt(int index) {
        return index >= 0 && index < this.size ? this.array[index] : null;
    }

    public boolean setAt(int index, T data) throws NullNotAllowedException {
        if (data == null) {
            throw new NullNotAllowedException();
        } else {
            if (index >= 0 && index < this.size) {
                this.array[index] = data;
            }

            return true;
        }
    }

    public int getSize() {
        return this.size;
    }

    public Iterator<T> getIterator() {
        return new Iterator<T>() {
            private int currentItem;

            public boolean hasNext() {
                return this.currentItem < ArrayList.this.size;
            }

            public T next() {
                return ArrayList.this.array[this.currentItem++];
            }
        };
    }

    private void increaseArrayList() {
        T[] newArray = (T[]) new Object[this.array.length * 2];
        if (this.size >= 0) {
            System.arraycopy(this.array, 0, newArray, 0, this.size);
        }

        this.array = newArray;
    }
}