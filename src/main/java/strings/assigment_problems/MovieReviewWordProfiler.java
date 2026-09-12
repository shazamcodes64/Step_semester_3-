package strings.assigment_problems;

/**
 * Problem 5: The Movie Review Word Length Profiler
 *
 * Splits a movie review into words and classifies each word as:
 *   Short  — 1 to 4 letters
 *   Medium — 5 to 8 letters
 *   Long   — 9+ letters
 */
public class MovieReviewWordProfiler {

    public static void classifyWordLengths(String review) {
        // Split on one or more whitespace characters
        String[] words = review.trim().split("\\s+");

        int shortCount  = 0;
        int mediumCount = 0;
        int longCount   = 0;

        for (String word : words) {
            int len = word.length();

            if (len <= 4) {
                shortCount++;
            } else if (len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount
                + " | Medium: " + mediumCount
                + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
