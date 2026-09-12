package strings.assigment_problems;

/**
 * Problem 1: The Exam Hall Seat Duplication Checker
 *
 * Scans an array of assigned seat numbers and flags any duplicates
 * using only arrays and nested loops (no Collections).
 */
public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundAny = false;

        // Track which duplicates have already been reported so we don't print the same number twice
        boolean[] reported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (reported[i]) {
                continue; // already flagged as a duplicate, skip
            }
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    reported[j] = true; // mark the later occurrence so it isn't re-reported
                    foundAny = true;
                    break; // one report per unique duplicate number is enough
                }
            }
        }

        if (!foundAny) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});

        System.out.println("\nTest 2:");
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }
}
