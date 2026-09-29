package com.uregina.tasks.streams.orders;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {

    public static Map<String, List<Order>> groupByProduct(List<Order> orders) {
        return orders.stream().collect(Collectors.groupingBy(Order::getProduct));
    }

    public static Map<String, Double> totalCostByProduct(List<Order> orders) {
        return orders.stream().collect(Collectors.groupingBy(Order::getProduct, Collectors.summingDouble(Order::getCost)));
    }

    public static Map<String, Double> topProducts(List<Order> orders, int limit) {
        return totalCostByProduct(orders).entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(limit)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        System.out.println("grouped: " + groupByProduct(orders).keySet());
        System.out.println("total by product: " + totalCostByProduct(orders));
        System.out.println("top 3:");
        topProducts(orders, 3).forEach((product, total) -> System.out.println(product + " - " + total));
    }
}
