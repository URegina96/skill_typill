package com.uregina.tasks.collections.mapping;

@FunctionalInterface
public interface Function<T> {

    T apply(T o);
}
