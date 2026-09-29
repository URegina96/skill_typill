package com.uregina.tasks.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class ElementCounter {

    private ElementCounter() {
    }

    public static <T> Map<T, Integer> countElements(T[] array) {
        Map<T, Integer> counts = new HashMap<>();
        if (array == null) {
            return counts;
        }
        for (T element : array) {
            counts.merge(element, 1, Integer::sum);
        }
        return counts;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        Integer[] numbers = {1, 2, 2, 3, 3, 3, null, null};

        System.out.println(Arrays.toString(words) + " -> " + countElements(words));
        System.out.println(Arrays.toString(numbers) + " -> " + countElements(numbers));
    }
}
