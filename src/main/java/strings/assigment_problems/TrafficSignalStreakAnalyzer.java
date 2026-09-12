package strings.assigment_problems;

/**
 * Problem 3: The Traffic Signal Streak Analyzer
 *
 * Scans a string of signal readings (R/Y/G) and reports
 * the longest consecutive streak of a single color.
 */
public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data provided.");
            return;
        }

        char bestColor    = signalLog.charAt(0);
        int  bestLength   = 1;
        int  currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentLength++;
                // Update best if current streak is now the longest
                if (currentLength > bestLength) {
                    bestLength = currentLength;
                    bestColor  = signalLog.charAt(i);
                }
            } else {
                // Streak broke — reset counter
                currentLength = 1;
            }
        }

        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLength + " times");
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        findLongestStreak("RRGGGYRR");

        System.out.println("\nTest 2:");
        findLongestStreak("RRRRYYGG");
    }
}
