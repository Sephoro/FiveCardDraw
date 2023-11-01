package com.epiuse.poker.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LimitedList<T> {

    private List<T> list;
    private int capacity;

    public LimitedList(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>(capacity);
    }

    public void add(T item) {
        if (list.size() < capacity) {
            list.add(item);
        } else {
            throw new UnsupportedOperationException("List only limited to " + capacity  + " number of elements, remove elements before trying to add");
        }
    }
}
