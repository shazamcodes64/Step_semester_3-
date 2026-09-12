package strings.assigment_problems;

/**
 * Problem 2: The Typing Speed Test Accuracy Checker
 *
 * Compares two equal-length strings character by character,
 * calculates accuracy percentage, and reports the first mismatch position.
 */
public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1; // 1-based position, -1 means no mismatch

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1; // convert to 1-based index
                }
            }
        }

        double accuracy = ((double) matched / total) * 100;

        String mismatchInfo;
        if (firstMismatchPos == -1) {
            mismatchInfo = "No Mismatches";
        } else {
            char expectedChar = original.charAt(firstMismatchPos - 1);
            char typedChar    = typed.charAt(firstMismatchPos - 1);
            mismatchInfo = "First Mismatch at position " + firstMismatchPos
                    + " ('" + expectedChar + "' vs '" + typedChar + "')";
        }

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | %s%n",
                matched, total, accuracy, mismatchInfo);
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\nTest 2:");
        checkTypingAccuracy("coding", "coding");
    }
}
