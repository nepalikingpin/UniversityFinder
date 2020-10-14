package model;

// Custom data structure that is used to store the UserChoices objects. Has methods : size, isEmpty, add on index, add
// at the end, remove, removeAll, get at index, contains element and helper methods of ensureCapacity and checkIndex

public class ChoicesList<E> {
    private int size = 0;
    private static final int INITIAL_CAPACITY = 1;
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

    //REQUIRES: index > 0 and index < size
    //MODIFIES: this
    //EFFECTS: adds the element e to the list at index i, if no other element exists at that index and if the list
    // has enough capacity
    public void add(int index, E e) {
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

    //REQUIRES: index > 0 and index < size
    //MODIFIES: this
    //EFFECTS: removes the element at index, and returns the list
    public E remove(int index) {

        E temp = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;

        return temp;
    }

    public void removeAll() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    //REQUIRES: index > 0 and index < size
    //EFFECTS: returns the element at index
    public E get(int index) {

        return data[index];
    }

    //EFFECTS: returns true if element e exists in the list, returns false otherwise
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
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

}
