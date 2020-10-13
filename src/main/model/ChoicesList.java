package model;

import java.util.*;

public class ChoicesList<E> {
    private int size = 0;
    private static final int INITIAL_CAPACITY = 5;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];

    //REQUIRES: size >= 0
    //EFFECTS: returns number of objects in the list
    public int size() {
        return size;
    }

    //EFFECTS: returns true if the number of objects in the list is 0, returns false otherwise.
    public boolean isEmpty() {
        return size == 0;
    }

    //MODIFIES: this
    //EFFECTS: adds the element e to the list at index i, if no other element exists at that index and if the list
    // has enough capacity
    public void add(int index, E e) {
        checkIndexForAdd(index);
        ensureCapacity();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    //EFFECTS: calls the add(int index,E e) method to add the element at last
    public void add(E e) {
        add(size, e);
    }

    //REQUIRES: size>0
    //MODIFIES: this
    //EFFECTS: removes the element at index, and returns the list
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

    //EFFECTS: returns the element at index
    public E get(int index) {
        checkIndex(index);

        return data[index];
    }

    //EFFECTS: returns true if element e exists in the list, returns false otherwise
    public boolean contains(E e) {
        for (int i = 0; i <= size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //EFFECTS: implements an Iterator with hasNext and next methods
    private class MyIterator implements Iterator<E> {
        private int current = 0;

        public boolean hasNext() {
            return (current < size);
        }

        public E next() {
            return data[current++];
        }
    }

    //EFFECTS: creates an Iterator
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    //HELPER METHODS

    //MODIFIES: this
    //EFFECTS: checks if there is capacity in the current list to add elements; if number of elements equals capacity,
    // then expands
    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[])new Object[2 * size + 1];

            System.arraycopy(data, 0, newData, 0, data.length);

            data = newData;
        }
    }

    //EFFECTS: checks if index is less than 0, or if index is less than or equal to size;
    // throws an IndexOutOfBoundsException if either is true
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    //EFFECTS: checks if index is less than 0, or if index is less than size;
    // throws an IndexOutOfBoundsException if either is true
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

}
