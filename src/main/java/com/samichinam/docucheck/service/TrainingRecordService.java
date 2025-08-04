package com.samichinam.docucheck.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Very small service that verifies investigator training records. It demonstrates
 * the "Training and qualification checks" feature outlined in {@code features.md}.
 */
public class TrainingRecordService {

    /**
     * Determine which required trainings a person is missing.
     *
     * @param person name of the individual to check
     * @param trainingDatabase mapping from person name to list of completed training IDs
     * @param required list of trainings required for the investigation
     * @return list of missing training IDs (empty if none)
     */
    public List<String> findMissingTrainings(String person,
                                             Map<String, List<String>> trainingDatabase,
                                             List<String> required) {
        List<String> completed = trainingDatabase.getOrDefault(person, List.of());
        List<String> missing = new ArrayList<>();
        for (String need : required) {
            if (!completed.contains(need)) {
                missing.add(need);
            }
        }
        return missing;
    }
}
