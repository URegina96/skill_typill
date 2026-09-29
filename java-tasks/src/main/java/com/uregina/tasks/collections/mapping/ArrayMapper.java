package com.uregina.tasks.collections.mapping;

import java.util.Arrays;
import java.util.Objects;

public final class ArrayMapper {

    private ArrayMapper() {
    }

    public static <T> T[] arrayMapping(T[] array, Function<T> function) {
        Objects.requireNonNull(array, "array");
        Objects.requireNonNull(function, "function");
        T[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = function.apply(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        String[] words = {"java", "maven", "stream"};

        System.out.println(Arrays.toString(arrayMapping(numbers, new Square())));
        System.out.println(Arrays.toString(arrayMapping(words, new UpperCase())));
        System.out.println(Arrays.toString(arrayMapping(words, s -> s + "!")));
        System.out.println(Arrays.toString(numbers));
    }

    static class Square implements Function<Integer> {

        @Override
        public Integer apply(Integer o) {
            return o * o;
        }
    }

    static class UpperCase implements Function<String> {

        @Override
        public String apply(String o) {
            return o.toUpperCase();
        }
    }
}
