package uaslp.objetos.list.LinkedList;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
    }

    public void addAtTail(T data) throws NullNotAllowedException {
        if (data == null) {
            throw new NullNotAllowedException();
        } else {
            Node<T> node = new Node(data);
            if (this.size == 0) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.previous = this.tail;
            }

            this.tail = node;
            ++this.size;
        }
    }

    public void addAtFront(T data) throws NullNotAllowedException {
        if (data == null) {
            throw new NullNotAllowedException();
        } else {
            Node<T> node = new Node(data);
            if (this.size == 0) {
                this.tail = node;
            } else {
                this.head.previous = node;
            }

            node.next = this.head;
            this.head = node;
            ++this.size;
        }
    }

    public boolean remove(int index) throws WrongIndexException {
        Node<T> node = this.findNode(index);
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else if (node == this.head) {
            this.head = node.next;
            if (this.head != null) {
                this.head.previous = null;
            }
        } else if (node == this.tail) {
            this.tail = node.previous;
            if (this.tail != null) {
                this.tail.next = null;
            }
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }

        --this.size;
        return true;
    }

    public void removeAll() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public T getAt(int index) throws WrongIndexException {
        Node<T> node = this.findNode(index);
        return node == null ? null : node.data;
    }

    public boolean setAt(int index, T data) throws WrongIndexException, NullNotAllowedException {
        if (data == null) {
            throw new NullNotAllowedException();
        } else if (index >= 0 && index < this.size) {
            Node<T> node = this.findNode(index);
            node.data = data;
            return true;
        } else {
            throw new WrongIndexException(index);
        }
    }

    private Node<T> findNode(int index) throws WrongIndexException {
        if (index >= 0 && index < this.size) {
            Node<T> node = this.head;

            for(int currentIndex = 0; currentIndex != index; node = node.next) {
                ++currentIndex;
            }

            return node;
        } else {
            throw new WrongIndexException(index);
        }
    }

    public int getSize() {
        return this.size;
    }

    public LinkedList<T>.LinkedListIterator<T> getIterator() {
        return new LinkedListIterator(this);
    }

    public static class Node<T> {
        Node<T> next;
        Node<T> previous;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public class LinkedListIterator<T> implements Iterator<T> {
        private Node<T> currentNode;

        LinkedListIterator(LinkedList<T> lista) {
            this.currentNode = lista.head;
        }

        public boolean hasNext() {
            return this.currentNode != null;
        }

        public T next() {
            T data = this.currentNode.data;
            this.currentNode = this.currentNode.next;
            return data;
        }
    }
}
