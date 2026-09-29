package com.uregina.tasks.collections.mapping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayMapperTest {

    @Test
    void appliesFunctionToEachElement() {
        Integer[] source = {1, 2, 3};
        Integer[] result = ArrayMapper.arrayMapping(source, new ArrayMapper.Square());

        assertArrayEquals(new Integer[]{1, 4, 9}, result);
    }

    @Test
    void returnsNewArrayAndKeepsSource() {
        String[] source = {"a", "b"};
        String[] result = ArrayMapper.arrayMapping(source, new ArrayMapper.UpperCase());

        assertNotSame(source, result);
        assertArrayEquals(new String[]{"a", "b"}, source);
        assertArrayEquals(new String[]{"A", "B"}, result);
        assertEquals(String[].class, result.getClass());
    }

    @Test
    void worksWithLambdaAndEmptyArray() {
        assertArrayEquals(new Double[]{0.5}, ArrayMapper.arrayMapping(new Double[]{1.0}, d -> d / 2));
        assertEquals(0, ArrayMapper.arrayMapping(new String[0], s -> s).length);
    }

    @Test
    void rejectsNulls() {
        assertThrows(NullPointerException.class, () -> ArrayMapper.arrayMapping(null, s -> s));
        assertThrows(NullPointerException.class, () -> ArrayMapper.arrayMapping(new String[]{"a"}, null));
    }
}
