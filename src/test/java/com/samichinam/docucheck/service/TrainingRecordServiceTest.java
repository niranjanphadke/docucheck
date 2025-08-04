package com.samichinam.docucheck.service;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TrainingRecordServiceTest {

    private final TrainingRecordService service = new TrainingRecordService();

    @Test
    void findsMissingTraining() {
        Map<String, List<String>> db = new HashMap<>();
        db.put("Alice", List.of("GMP"));
        List<String> missing = service.findMissingTrainings("Alice", db, List.of("GMP", "Safety"));
        assertTrue(missing.contains("Safety"));
        assertTrue(!missing.contains("GMP"));
    }

    @Test
    void unknownPersonMissingAll() {
        Map<String, List<String>> db = new HashMap<>();
        List<String> missing = service.findMissingTrainings("Bob", db, List.of("GMP"));
        assertTrue(missing.contains("GMP"));
    }
}
