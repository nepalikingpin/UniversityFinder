package model;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ChoicesListTest {

    @Test
    public void AddTest() {
        ChoicesList<Integer> choicesList = new ChoicesList<>();

        for (int i = 0; i < 10; i++) {
            choicesList.add(i);
        }
        assertEquals(10, choicesList.size());

    }

    @Test
    public void AddAtIndexTest() {
        ChoicesList<Integer> choicesList = new ChoicesList<>();

        for (int i = 0; i < 10; i++) {
            choicesList.add(i, i+1);
        }
        choicesList.add(1,99);
        assertEquals(99,choicesList.get(1));
        assertEquals(3, choicesList.get(3));
    }

    @Test
    public void RemoveTest() {
        ChoicesList<Integer> choicesList = new ChoicesList<>();

        for (int i = 0; i < 10; i++) {
            choicesList.add(i,1);

        }
        choicesList.remove(2);
        assertEquals(9, choicesList.size());
    }

    @Test
    public void RemoveAllTest() {
        ChoicesList<Integer> choicesList = new ChoicesList<>();

        for (int i = 0; i < 10; i++) {
            choicesList.add(i,1);

        }
        choicesList.removeAll();

        assertEquals(0, choicesList.size());
    }

    @Test
    public void EmptyListTest() {
        ChoicesList<Integer> choicesList = new ChoicesList<>();

        assertTrue(choicesList.isEmpty());
    }

    @Test
    public void NotEmptyTest() {
        ChoicesList<Integer> choicesList = new ChoicesList<>();
        choicesList.add(1);

        assertFalse(choicesList.isEmpty());
    }

    @Test
    public void ContainsTrueTest() {
        ChoicesList<Integer> choicesList = new ChoicesList<>();
        choicesList.add(1);
        choicesList.add(2);
        choicesList.add(3);

        assertTrue(choicesList.contains(3));

    }

    @Test
    public void ContainsFalseTest() {
        ChoicesList<Integer> choicesList = new ChoicesList<>();
        choicesList.add(1);
        choicesList.add(2);
        choicesList.add(3);

        assertFalse(choicesList.contains(4));
    }



}