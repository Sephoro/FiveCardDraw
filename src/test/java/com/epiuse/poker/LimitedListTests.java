package com.epiuse.poker;

import com.epiuse.poker.utils.LimitedList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LimitedListTests {

    @Test
    public void testAddElementWithinCapacity() {
        int capacity = 3;
        LimitedList<String> limitedList = new LimitedList<>(capacity);

        limitedList.add("A");
        limitedList.add("1");
        limitedList.add("2");

        List<String> elements = limitedList.getList();

        assertEquals(3, elements.size());
        assertTrue(elements.contains("A"));
        assertTrue(elements.contains("1"));
        assertTrue(elements.contains("2"));
    }

    @Test
    public void testAddElementExceedingCapacity() {
        int capacity = 2;
        LimitedList<String> limitedList = new LimitedList<>(capacity);

        limitedList.add("A");
        limitedList.add("2");

        // Adding one more element should result in a UnsupportedOperationException exception
        assertThrows(UnsupportedOperationException.class, () -> limitedList.add("3"));
    }

    @Test
    public void testAddElementAndRemove(){

        int capacity = 2;

        LimitedList<String> limitedList = new LimitedList<>(capacity);

        limitedList.add("A");
        limitedList.add("2");

        limitedList.getList().remove(0);

        assertEquals(1, limitedList.getList().size());

        limitedList.add("3");

        assertEquals(2, limitedList.getList().size());
        assertFalse(limitedList.getList().contains("A"));

        assertTrue(limitedList.getList().contains("2"));
        assertTrue(limitedList.getList().contains("3"));

    }

}
