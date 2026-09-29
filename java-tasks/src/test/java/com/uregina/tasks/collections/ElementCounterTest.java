package com.uregina.tasks.collections;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ElementCounterTest {

    @Test
    void countsEachElement() {
        Map<String, Integer> result = ElementCounter.countElements(new String[]{"a", "b", "a", "c", "a"});
        assertEquals(Map.of("a", 3, "b", 1, "c", 1), result);
    }

    @Test
    void supportsNullElements() {
        Map<Integer, Integer> result = ElementCounter.countElements(new Integer[]{1, null, null});
        assertEquals(1, result.get(1));
        assertEquals(2, result.get(null));
    }

    @Test
    void emptyAndNullArrays() {
        assertTrue(ElementCounter.countElements(new String[0]).isEmpty());
        assertTrue(ElementCounter.countElements((String[]) null).isEmpty());
    }
}
