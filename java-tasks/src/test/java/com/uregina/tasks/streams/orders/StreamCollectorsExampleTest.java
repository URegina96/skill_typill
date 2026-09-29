package com.uregina.tasks.streams.orders;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamCollectorsExampleTest {

    private final List<Order> orders = List.of(
            new Order("Laptop", 1200.0),
            new Order("Smartphone", 800.0),
            new Order("Laptop", 1500.0),
            new Order("Tablet", 500.0),
            new Order("Smartphone", 900.0),
            new Order("Mouse", 50.0)
    );

    @Test
    void groupsAndSums() {
        assertEquals(2, StreamCollectorsExample.groupByProduct(orders).get("Laptop").size());
        assertEquals(1700.0, StreamCollectorsExample.totalCostByProduct(orders).get("Smartphone"));
    }

    @Test
    void topThreeInDescendingOrder() {
        Map<String, Double> top = StreamCollectorsExample.topProducts(orders, 3);
        assertEquals(List.of("Laptop", "Smartphone", "Tablet"), List.copyOf(top.keySet()));
        assertEquals(List.of(2700.0, 1700.0, 500.0), List.copyOf(top.values()));
    }
}
