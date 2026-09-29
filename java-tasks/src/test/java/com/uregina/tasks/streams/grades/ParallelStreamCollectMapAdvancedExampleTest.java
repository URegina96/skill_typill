package com.uregina.tasks.streams.grades;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParallelStreamCollectMapAdvancedExampleTest {

    @Test
    void averagesBySubject() {
        List<Student> students = List.of(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        Map<String, Double> result = ParallelStreamCollectMapAdvancedExample.averageGradeBySubject(students);

        assertEquals(3, result.size());
        assertEquals(91.0, result.get("Math"), 1e-9);
        assertEquals(83.666666666, result.get("Physics"), 1e-6);
        assertEquals(88.5, result.get("Chemistry"), 1e-9);
    }

    @Test
    void emptyList() {
        assertTrue(ParallelStreamCollectMapAdvancedExample.averageGradeBySubject(List.of()).isEmpty());
    }
}
