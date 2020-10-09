package model;

import java.util.*;

public class UserChoicesList<E> {
    private int size = 0;
    private static final int INITIAL_CAPACITY = 5;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];

    public int size() {
        return size();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        checkIndexForAdd(index);
        ensureCapacity();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    public E remove(int index) {
        checkIndex(index);

        E temp = data[index];
        for (int i = index; i <= size; i--) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;

        return temp;
    }

    public E get(int index) {
        checkIndex(index);

        return data[index];
    }

    public boolean contains(E e) {
        for (int i = 0; i <= size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    private class MyIterator implements Iterator<E> {
        private int current = 0;

        public boolean hasNext() {
            return (current < size);
        }

        public E next() {
            return data[current++];
        }
    }

    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[])new Object[2 * size + 1];

            System.arraycopy(data, 0, newData, 0, data.length);

            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

}
