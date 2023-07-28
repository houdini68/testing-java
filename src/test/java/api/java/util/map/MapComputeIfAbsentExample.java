package api.java.util.map;

import java.util.HashMap;
import java.util.Map;
public class MapComputeIfAbsentExample {
    public static void main(String[] args) {
        // Create a map
        Map<String, Integer> scores = new HashMap<>();

        // Retrieve the value for a key, or compute and store a new value if the key is absent
        int johnsScore = scores.computeIfAbsent("John", key -> computeScore(key));
        System.out.println("John's Score: " + johnsScore);

        // Retrieve the existing value for a key
        int marysScore = scores.computeIfAbsent("Mary", key -> computeScore(key));
        System.out.println("Mary's Score: " + marysScore);

        // Print the updated map
        System.out.println("Updated Map: " + scores);

        // Update the value of a non-absent key
        marysScore = scores.computeIfAbsent("Mary", key -> computeScore(key) * 2);

        // Print the updated map
        System.out.println("value of Map for Mary was not updated: " + scores);
    }

    // A method to compute the score based on the key
    private static int computeScore(String key) {
        System.out.println("Computing score for: " + key);
        return key.length() * 10;
    }
}
