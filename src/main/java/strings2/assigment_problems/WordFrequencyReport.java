package strings2.assigment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 5: Stop-Word-Filtered Word Frequency Report
 *
 * Counts word frequencies in a feedback paragraph, skipping common stop words.
 * Results are printed sorted by frequency (descending).
 *
 * Stop words: the, was, and, a, is, of, in
 */
public class WordFrequencyReport {

    // Fixed stop-word list
    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    private static boolean isStopWord(String word) {
        for (String stop : STOP_WORDS) {
            if (stop.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void printFilteredWordFrequency(String feedback) {
        // Normalize: lowercase and strip punctuation (periods and commas)
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "");

        // Split on one or more whitespace characters
        String[] words = cleaned.split("\\s+");

        // Count frequencies, skipping stop words
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count descending, then alphabetically for stable tie-breaking
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                int cmp = b.getValue().compareTo(a.getValue()); // descending by count
                if (cmp != 0) return cmp;
                return a.getKey().compareTo(b.getKey());        // ascending alpha on tie
            }
        });

        // Print results
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
