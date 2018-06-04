package br.sumbp.datastructures;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private class Node<T> {
        T data;
        Node next;
        Node previous;

        Node(final T data) {
            this.data = data;
        }
    }

    public void append(final T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            linkHead(node);
        } else {
            linkTail(node);
        }
        ++size;
    }

    private void linkTail(final Node<T> node) {
        node.previous = tail;
        tail.next = node;
        tail = node;
    }

    private void linkHead(final Node<T> node) {
        head = node;
        tail = node;
    }

    public T get(final int index) {
        Node<T> node = getNode(index);
        return node.data;
    }

    public T get(final T element) {
        Node<T> node = getNode(element);
        return node !=null ? node.data : null;
    }

    private Node getNode(final int index) {
        checkBounds(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private Node getNode(final T element) {
        for (Node<T> current = head; current.next != null; current = current.next) {
            if(current.data.equals(element)) {
                return current;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void remove(final int index) {
        checkBounds(index);
        if (index == 0)
        {
            unlinkHead();
        } else if (index == size - 1) {
            unlinkTail();
        } else {
            unlinkMiddle(index);
        }
        --size;
    }

    private void unlinkMiddle(final int index) {
        Node<T> previous = head;
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                previous.next = current.next;
                break;
            }
            previous = current;
            current = current.next;
        }
    }

    private void unlinkTail() {
        tail = tail.previous;
        tail.next = null;
    }

    private void unlinkHead() {
        head = head.next;
    }

    private void checkBounds(final int index) {
        if (index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
    }
}
